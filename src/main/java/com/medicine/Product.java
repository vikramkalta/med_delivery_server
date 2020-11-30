package com.medicine;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Products")
public class Product {
  @Id
  @Column(name = "ProductID")
  @GeneratedValue
  private long ProductID;

  @Column(name="ProductName")
  private String ProductName;

  @Column(name = "ProductPrice")
  private Integer ProductPrice;

  @Column(name = "Category")
  private String Category;

//  @Column(name = "CreatedAt")
//  private Date CreatedAt;

  public Product() {
    super();
  }

  public Product(long productID, String productName, Integer productPrice, String category, Date createdAt) {
    super();
    this.ProductID = productID;
    this.ProductName = productName;
    this.ProductPrice = productPrice;
    this.Category = category;
//    CreatedAt = createdAt;
  }

  public long getProductID() {
    return this.ProductID;
  }

  public void setProductID(long productID) {
    this.ProductID = productID;
  }

  public String getProductName() {
    return this.ProductName;
  }

  public void setProductName(String productName) {
    this.ProductName = productName;
  }

  public Integer getProductPrice() {
    return this.ProductPrice;
  }

  public void setProductPrice(Integer productPrice) {
    this.ProductPrice = productPrice;
  }

  public String getCategory() {
    return this.Category;
  }

  public void setCategory(String category) {
    this.Category = category;
  }
}
