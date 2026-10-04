package com.supplierpulse.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.supplierpulse.model.Product;

@Repository
public class ProductRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Product> getAllProducts() {

        String sql = "SELECT * FROM products ORDER BY product_id";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {

            Product product = new Product();

            product.setProductId(rs.getInt("product_id"));
            product.setProductName(rs.getString("product_name"));
            product.setCategory(rs.getString("category"));
            product.setUnit(rs.getString("unit"));
            product.setUnitPrice(rs.getDouble("unit_price"));

            return product;
        });
    }

    public void addProduct(Product product) {

        String sql = """
                INSERT INTO products
                (product_name, category, unit, unit_price)
                VALUES (?, ?, ?, ?)
                """;

        jdbcTemplate.update(
                sql,
                product.getProductName(),
                product.getCategory(),
                product.getUnit(),
                product.getUnitPrice()
        );
    }
}
