package com.supplierpulse.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.supplierpulse.model.PurchaseOrder;

@Repository
public class PurchaseOrderRepository {
    public int getPurchaseOrderCount() {

    String sql = "SELECT COUNT(*) FROM purchase_orders";

    return jdbcTemplate.queryForObject(
            sql,
            Integer.class
    );
}

    private final JdbcTemplate jdbcTemplate;

    public PurchaseOrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Add Purchase Order
    public void addPurchaseOrder(PurchaseOrder order) {

        String sql = """
                INSERT INTO purchase_orders
                (supplier_id, order_date, expected_delivery_date, status)
                VALUES (?, ?, ?, ?)
                """;

        jdbcTemplate.update(
                sql,
                order.getSupplierId(),
                Date.valueOf(order.getOrderDate()),
                Date.valueOf(order.getExpectedDeliveryDate()),
                order.getStatus()
        );
    }


    // Get All Purchase Orders
    public List<PurchaseOrder> getAllPurchaseOrders() {

        String sql = """
                SELECT order_id,
                       supplier_id,
                       order_date,
                       expected_delivery_date,
                       status
                FROM purchase_orders
                ORDER BY order_id DESC
                """;

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> {

                    PurchaseOrder order = new PurchaseOrder();

                    order.setOrderId(
                            rs.getInt("order_id")
                    );

                    order.setSupplierId(
                            rs.getInt("supplier_id")
                    );

                    order.setOrderDate(
                            rs.getDate("order_date").toLocalDate()
                    );

                    order.setExpectedDeliveryDate(
                            rs.getDate("expected_delivery_date").toLocalDate()
                    );

                    order.setStatus(
                            rs.getString("status")
                    );

                    return order;
                }
        );
    }


    // Get Purchase Order By ID
    public PurchaseOrder getPurchaseOrderById(int orderId) {

        String sql = """
                SELECT order_id,
                       supplier_id,
                       order_date,
                       expected_delivery_date,
                       status
                FROM purchase_orders
                WHERE order_id = ?
                """;

        return jdbcTemplate.queryForObject(
                sql,
                (rs, rowNum) -> {

                    PurchaseOrder order = new PurchaseOrder();

                    order.setOrderId(
                            rs.getInt("order_id")
                    );

                    order.setSupplierId(
                            rs.getInt("supplier_id")
                    );

                    order.setOrderDate(
                            rs.getDate("order_date").toLocalDate()
                    );

                    order.setExpectedDeliveryDate(
                            rs.getDate("expected_delivery_date").toLocalDate()
                    );

                    order.setStatus(
                            rs.getString("status")
                    );

                    return order;
                },
                orderId
        );
    }


    // Update Purchase Order
    public void updatePurchaseOrder(PurchaseOrder order) {

        String sql = """
                UPDATE purchase_orders
                SET supplier_id = ?,
                    order_date = ?,
                    expected_delivery_date = ?,
                    status = ?
                WHERE order_id = ?
                """;

        jdbcTemplate.update(
                sql,
                order.getSupplierId(),
                Date.valueOf(order.getOrderDate()),
                Date.valueOf(order.getExpectedDeliveryDate()),
                order.getStatus(),
                order.getOrderId()
        );
    }


    // Delete Purchase Order
    public void deletePurchaseOrder(int orderId) {

        String sql = """
                DELETE FROM purchase_orders
                WHERE order_id = ?
                """;

        jdbcTemplate.update(
                sql,
                orderId
        );
    }
}