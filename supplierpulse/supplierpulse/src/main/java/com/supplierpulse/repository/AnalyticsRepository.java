package com.supplierpulse.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.supplierpulse.model.Analytics;

@Repository
public class AnalyticsRepository {

    private final JdbcTemplate jdbcTemplate;

    public AnalyticsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Get Supplier Analytics
    public List<Analytics> getSupplierAnalytics() {

        String sql = """
                SELECT
                    s.supplier_id,
                    s.supplier_name,

                    CASE
                        WHEN COUNT(d.delivery_id) = 0
                        THEN 0
                        ELSE ROUND(
                            (
                                COUNT(
                                    CASE
                                        WHEN d.actual_delivery_date <= po.expected_delivery_date
                                        THEN 1
                                    END
                                ) * 100.0
                            ) / COUNT(d.delivery_id),
                            2
                        )
                    END AS on_time_rate,

                    CASE
                        WHEN COALESCE(SUM(qi.quantity_inspected), 0) = 0
                        THEN 0
                        ELSE ROUND(
                            (
                                SUM(qi.quantity_accepted) * 100.0
                            ) / SUM(qi.quantity_inspected),
                            2
                        )
                    END AS quality_rate,

                    CASE
                        WHEN COUNT(d.delivery_id) = 0
                             OR COALESCE(SUM(qi.quantity_inspected), 0) = 0
                        THEN 0
                        ELSE ROUND(
                            (
                                (
                                    COUNT(
                                        CASE
                                            WHEN d.actual_delivery_date <= po.expected_delivery_date
                                            THEN 1
                                        END
                                    ) * 100.0
                                    / COUNT(d.delivery_id)
                                ) * 0.40
                            )
                            +
                            (
                                (
                                    SUM(qi.quantity_accepted) * 100.0
                                    / SUM(qi.quantity_inspected)
                                ) * 0.60
                            ),
                            2
                        )
                    END AS overall_score

                FROM suppliers s

                LEFT JOIN purchase_orders po
                    ON s.supplier_id = po.supplier_id

                LEFT JOIN deliveries d
                    ON po.order_id = d.order_id

                LEFT JOIN quality_inspections qi
                    ON d.delivery_id = qi.delivery_id

                GROUP BY
                    s.supplier_id,
                    s.supplier_name

                ORDER BY
                    overall_score DESC
                """;

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> {

                    Analytics analytics = new Analytics();

                    analytics.setSupplierId(
                            rs.getInt("supplier_id")
                    );

                    analytics.setSupplierName(
                            rs.getString("supplier_name")
                    );

                    analytics.setOnTimeRate(
                            rs.getDouble("on_time_rate")
                    );

                    analytics.setQualityRate(
                            rs.getDouble("quality_rate")
                    );

                    analytics.setOverallScore(
                            rs.getDouble("overall_score")
                    );

                    return analytics;
                }
        );
    }
}
