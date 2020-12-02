package com.medicine;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service
public class CartProductService {

  CartProductRepository cartProductRepository;

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Autowired
  public CartProductService(CartProductRepository cartProductRepository) {
    super();
    this.cartProductRepository = cartProductRepository;
  }

  public CartProduct findById(long id) {
    String sql = "SELECT * FROM CartProduct WHERE CartProductID=?";
//    return jdbcTemplate.query(sql, new Object[]{id}, new CartProductRowMapper());
    CartProduct cartProduct = jdbcTemplate.queryForObject(sql, new CartProductRowMapper(), new Object[]{id});
    return  cartProduct;
  }

  public int[] bulkInsert(List<CartProduct> cartProducts) {
    return jdbcTemplate.batchUpdate(
            "INSERT INTO CartProduct (AddressID, ProductID, Quantity) VALUES (?, ?, ?)",
            new BatchPreparedStatementSetter() {
              @Override
              public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
//                System.out.println(" cartProducts.get(i).getAddressID():" +  cartProducts.get(i).getAddressID());
//                System.out.println("cartProducts.get(i).getProductID():" + cartProducts.get(i).getProductID());
//                System.out.println("cartProducts.get(i).getQuantity():" + cartProducts.get(i).getQuantity());
                preparedStatement.setLong(1, cartProducts.get(i).getAddressID());
                preparedStatement.setLong(2, cartProducts.get(i).getProductID());
                preparedStatement.setInt(3,cartProducts.get(i).getQuantity());
              }

              @Override
              public int getBatchSize() {
                return cartProducts.size();
              }
            }
    );
  }

  public List<Map<String, Object>> getOrderSummary(long id) {
    String sql = "SELECT p.ProductName, p.ProductPrice, " +
            "a.ContactName, a.ContactNumber, a.Pincode, " +
            "a.StreetAddress, a.City, a.State, cp.Quantity " +
            "FROM Products p " +
            "INNER JOIN CartProduct cp ON cp.ProductID=p.ProductID " +
            "INNER JOIN Address a ON a.AddressID=cp.AddressID " +
            "WHERE cp.AddressID = " + id;
    System.out.println("sql--->" + sql);
//    List<Map<String, Object>> orderSummaries = jdbcTemplate.queryForList(sql, new BeanPropertyRowMapper<OrderSummary>());
    List<Map<String, Object>> orderSummaries = jdbcTemplate.queryForList(sql);
//    List<Map<String, Object>> orderSummaries = jdbcTemplate.queryForList(sql,
//            new RowMapper() {
//              public OrderSummary mapRow(ResultSet rs, int numRows) throws  SQLException{
//                OrderSummary orderSummary = new OrderSummary();
//                orderSummary.setProductName(rs.getString("ProductName"));
//                orderSummary.setProductPrice(rs.getInt("ProductPrice"));
//                orderSummary.setContactName(rs.getString("ContactName"));
//                orderSummary.setContactNumber(rs.getString("ContactNumber"));
//                orderSummary.setPincode(rs.getString("Pincode"));
//                orderSummary.setStreetAddress(rs.getString("StreetAddress"));
//                orderSummary.setCity(rs.getString("City"));
//                orderSummary.setState(rs.getString("State"));
//                return orderSummary;
//              }
//            }
//    );
    System.out.println("result-->" + orderSummaries);
    return orderSummaries;
  }
}
