package com.medicine;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartProductRowMapper implements RowMapper<CartProduct> {

  @Override
  public CartProduct mapRow(ResultSet rs, int rowNum) throws SQLException {
    CartProduct cartProduct = new CartProduct();
    cartProduct.setCartProductID(rs.getLong("CartProductID"));
    cartProduct.setAddressID(rs.getLong("AddressID"));
    cartProduct.setProductID(rs.getLong("ProductID"));
    cartProduct.setQuantity(rs.getInt("Quantity"));
    return  cartProduct;
  }
}
