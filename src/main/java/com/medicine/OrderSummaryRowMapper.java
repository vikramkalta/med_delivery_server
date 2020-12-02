package com.medicine;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderSummaryRowMapper implements RowMapper<OrderSummary> {
  @Override
  public OrderSummary mapRow(ResultSet rs, int rowNum) throws SQLException {
    OrderSummary orderSummary = new OrderSummary();
    orderSummary.setProductName(rs.getString("ProductName"));
    orderSummary.setProductPrice(rs.getInt("ProductPrice"));
    orderSummary.setContactName(rs.getString("ContactName"));
    orderSummary.setContactNumber(rs.getString("ContactNumber"));
    orderSummary.setPincode(rs.getString("Pincode"));
    orderSummary.setStreetAddress(rs.getString("StreetAddress"));
    orderSummary.setCity(rs.getString("City"));
    orderSummary.setState(rs.getString("State"));
    return orderSummary;
  }
}
