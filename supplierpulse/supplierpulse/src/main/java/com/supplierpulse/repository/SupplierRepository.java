package com.supplierpulse.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.supplierpulse.model.Supplier;

@Repository
public class SupplierRepository {
    public int getSupplierCount() {

    String sql = "SELECT COUNT(*) FROM suppliers";

    return jdbcTemplate.queryForObject(
            sql,
            Integer.class
    );
}
    private final JdbcTemplate jdbcTemplate;

    public SupplierRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Supplier> getAllSuppliers() {

        String sql = "SELECT * FROM suppliers ORDER BY supplier_id";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {

            Supplier supplier = new Supplier();

            supplier.setSupplierId(rs.getInt("supplier_id"));
            supplier.setSupplierName(rs.getString("supplier_name"));
            supplier.setCompanyName(rs.getString("company_name"));
            supplier.setContactNumber(rs.getString("contact_number"));
            supplier.setEmail(rs.getString("email"));
            supplier.setAddress(rs.getString("address"));
            supplier.setCategory(rs.getString("category"));
            supplier.setStatus(rs.getString("status"));

            return supplier;
        });
    }

    // ADD THIS METHOD
    public void addSupplier(Supplier supplier) {

        String sql = """
                INSERT INTO suppliers
                (supplier_name, company_name, contact_number, email, address, category, status)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;

        jdbcTemplate.update(
                sql,
                supplier.getSupplierName(),
                supplier.getCompanyName(),
                supplier.getContactNumber(),
                supplier.getEmail(),
                supplier.getAddress(),
                supplier.getCategory(),
                supplier.getStatus()
        );
    }
}
