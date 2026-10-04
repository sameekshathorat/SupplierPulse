package com.supplierpulse.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.supplierpulse.model.Delivery;

@Repository
public class DeliveryRepository {
    public int getDeliveryCount() {

    String sql = "SELECT COUNT(*) FROM deliveries";

    return jdbcTemplate.queryForObject(
            sql,
            Integer.class
    );
}

    private final JdbcTemplate jdbcTemplate;

    public DeliveryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Add Delivery
    public void addDelivery(Delivery delivery) {

        String sql = """
                INSERT INTO deliveries
                (order_id, actual_delivery_date, quantity_received, delivery_status)
                VALUES (?, ?, ?, ?)
                """;

        jdbcTemplate.update(
                sql,
                delivery.getOrderId(),
                Date.valueOf(delivery.getActualDeliveryDate()),
                delivery.getQuantityReceived(),
                delivery.getDeliveryStatus()
        );
    }

    // Get All Deliveries
    public List<Delivery> getAllDeliveries() {

        String sql = """
                SELECT delivery_id,
                       order_id,
                       actual_delivery_date,
                       quantity_received,
                       delivery_status
                FROM deliveries
                ORDER BY delivery_id DESC
                """;

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> {

                    Delivery delivery = new Delivery();

                    delivery.setDeliveryId(
                            rs.getInt("delivery_id")
                    );

                    delivery.setOrderId(
                            rs.getInt("order_id")
                    );

                    delivery.setActualDeliveryDate(
                            rs.getDate("actual_delivery_date").toLocalDate()
                    );

                    delivery.setQuantityReceived(
                            rs.getDouble("quantity_received")
                    );

                    delivery.setDeliveryStatus(
                            rs.getString("delivery_status")
                    );

                    return delivery;
                }
        );
    }

    // Get Delivery By ID
    public Delivery getDeliveryById(int deliveryId) {

        String sql = """
                SELECT delivery_id,
                       order_id,
                       actual_delivery_date,
                       quantity_received,
                       delivery_status
                FROM deliveries
                WHERE delivery_id = ?
                """;

        return jdbcTemplate.queryForObject(
                sql,
                (rs, rowNum) -> {

                    Delivery delivery = new Delivery();

                    delivery.setDeliveryId(
                            rs.getInt("delivery_id")
                    );

                    delivery.setOrderId(
                            rs.getInt("order_id")
                    );

                    delivery.setActualDeliveryDate(
                            rs.getDate("actual_delivery_date").toLocalDate()
                    );

                    delivery.setQuantityReceived(
                            rs.getDouble("quantity_received")
                    );

                    delivery.setDeliveryStatus(
                            rs.getString("delivery_status")
                    );

                    return delivery;
                },
                deliveryId
        );
    }

    // Update Delivery
    public void updateDelivery(Delivery delivery) {

        String sql = """
                UPDATE deliveries
                SET order_id = ?,
                    actual_delivery_date = ?,
                    quantity_received = ?,
                    delivery_status = ?
                WHERE delivery_id = ?
                """;

        jdbcTemplate.update(
                sql,
                delivery.getOrderId(),
                Date.valueOf(delivery.getActualDeliveryDate()),
                delivery.getQuantityReceived(),
                delivery.getDeliveryStatus(),
                delivery.getDeliveryId()
        );
    }

    // Delete Delivery
    public void deleteDelivery(int deliveryId) {

        String sql = """
                DELETE FROM deliveries
                WHERE delivery_id = ?
                """;

        jdbcTemplate.update(
                sql,
                deliveryId
        );
    }
}