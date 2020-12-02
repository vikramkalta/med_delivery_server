package com.medicine;

import javax.persistence.*;

@Entity
@Table(name = "CartProduct")
public class CartProduct {
  @Id
  @Column(name = "CartProductID")
  @GeneratedValue
  private long CartProductID;

  @Column(name = "AddressID")
  private long AddressID;

  @Column(name = "ProductID")
  private long ProductID;

  @Column(name = "Quantity")
  private int Quantity;

  public long getCartProductID() {
    return CartProductID;
  }

  public void setCartProductID(long cartProductID) {
    CartProductID = cartProductID;
  }

  public long getAddressID() {
    return AddressID;
  }

  public void setAddressID(long addressID) {
    AddressID = addressID;
  }

  public long getProductID() {
    return ProductID;
  }

  public void setProductID(long productID) {
    ProductID = productID;
  }

  public int getQuantity() {
    return Quantity;
  }

  public void setQuantity(int quantity) {
    Quantity = quantity;
  }
}
