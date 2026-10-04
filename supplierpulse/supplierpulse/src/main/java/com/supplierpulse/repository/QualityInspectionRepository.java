package com.supplierpulse.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.supplierpulse.model.QualityInspection;

@Repository
public class QualityInspectionRepository {
    public int getQualityInspectionCount() {

    String sql = "SELECT COUNT(*) FROM quality_inspections";

    return jdbcTemplate.queryForObject(
            sql,
            Integer.class
    );
}

    private final JdbcTemplate jdbcTemplate;

    public QualityInspectionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Add Quality Inspection
    public void addInspection(QualityInspection inspection) {

        String sql = """
                INSERT INTO quality_inspections
                (delivery_id, inspection_date, quantity_inspected,
                 quantity_accepted, quantity_rejected, remarks)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        jdbcTemplate.update(
                sql,
                inspection.getDeliveryId(),
                Date.valueOf(inspection.getInspectionDate()),
                inspection.getQuantityInspected(),
                inspection.getQuantityAccepted(),
                inspection.getQuantityRejected(),
                inspection.getRemarks()
        );
    }

    // Get All Quality Inspections
    public List<QualityInspection> getAllInspections() {

        String sql = """
                SELECT inspection_id,
                       delivery_id,
                       inspection_date,
                       quantity_inspected,
                       quantity_accepted,
                       quantity_rejected,
                       remarks
                FROM quality_inspections
                ORDER BY inspection_id DESC
                """;

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> {

                    QualityInspection inspection =
                            new QualityInspection();

                    inspection.setInspectionId(
                            rs.getInt("inspection_id")
                    );

                    inspection.setDeliveryId(
                            rs.getInt("delivery_id")
                    );

                    inspection.setInspectionDate(
                            rs.getDate("inspection_date").toLocalDate()
                    );

                    inspection.setQuantityInspected(
                            rs.getDouble("quantity_inspected")
                    );

                    inspection.setQuantityAccepted(
                            rs.getDouble("quantity_accepted")
                    );

                    inspection.setQuantityRejected(
                            rs.getDouble("quantity_rejected")
                    );

                    inspection.setRemarks(
                            rs.getString("remarks")
                    );

                    return inspection;
                }
        );
    }

    // Get Quality Inspection By ID
    public QualityInspection getInspectionById(int inspectionId) {

        String sql = """
                SELECT inspection_id,
                       delivery_id,
                       inspection_date,
                       quantity_inspected,
                       quantity_accepted,
                       quantity_rejected,
                       remarks
                FROM quality_inspections
                WHERE inspection_id = ?
                """;

        return jdbcTemplate.queryForObject(
                sql,
                (rs, rowNum) -> {

                    QualityInspection inspection =
                            new QualityInspection();

                    inspection.setInspectionId(
                            rs.getInt("inspection_id")
                    );

                    inspection.setDeliveryId(
                            rs.getInt("delivery_id")
                    );

                    inspection.setInspectionDate(
                            rs.getDate("inspection_date").toLocalDate()
                    );

                    inspection.setQuantityInspected(
                            rs.getDouble("quantity_inspected")
                    );

                    inspection.setQuantityAccepted(
                            rs.getDouble("quantity_accepted")
                    );

                    inspection.setQuantityRejected(
                            rs.getDouble("quantity_rejected")
                    );

                    inspection.setRemarks(
                            rs.getString("remarks")
                    );

                    return inspection;
                },
                inspectionId
        );
    }

    // Update Quality Inspection
    public void updateInspection(QualityInspection inspection) {

        String sql = """
                UPDATE quality_inspections
                SET delivery_id = ?,
                    inspection_date = ?,
                    quantity_inspected = ?,
                    quantity_accepted = ?,
                    quantity_rejected = ?,
                    remarks = ?
                WHERE inspection_id = ?
                """;

        jdbcTemplate.update(
                sql,
                inspection.getDeliveryId(),
                Date.valueOf(inspection.getInspectionDate()),
                inspection.getQuantityInspected(),
                inspection.getQuantityAccepted(),
                inspection.getQuantityRejected(),
                inspection.getRemarks(),
                inspection.getInspectionId()
        );
    }

    // Delete Quality Inspection
    public void deleteInspection(int inspectionId) {

        String sql = """
                DELETE FROM quality_inspections
                WHERE inspection_id = ?
                """;

        jdbcTemplate.update(
                sql,
                inspectionId
        );
    }
}