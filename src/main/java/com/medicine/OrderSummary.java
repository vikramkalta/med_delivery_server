package com.medicine;

public class OrderSummary {
  private String  ProductName;
  private int ProductPrice;
  private String ContactName;
  private String ContactNumber;
  private String Pincode;
  private String StreetAddress;
  private String City;
  private String State;

  public String getProductName() {
    return ProductName;
  }

  public void setProductName(String productName) {
    ProductName = productName;
  }

  public int getProductPrice() {
    return ProductPrice;
  }

  public void setProductPrice(int productPrice) {
    ProductPrice = productPrice;
  }

  public String getContactName() {
    return ContactName;
  }

  public void setContactName(String contactName) {
    ContactName = contactName;
  }

  public String getContactNumber() {
    return ContactNumber;
  }

  public void setContactNumber(String contactNumber) {
    ContactNumber = contactNumber;
  }

  public String getPincode() {
    return Pincode;
  }

  public void setPincode(String pincode) {
    Pincode = pincode;
  }

  public String getStreetAddress() {
    return StreetAddress;
  }

  public void setStreetAddress(String streetAddress) {
    StreetAddress = streetAddress;
  }

  public String getCity() {
    return City;
  }

  public void setCity(String city) {
    City = city;
  }

  public String getState() {
    return State;
  }

  public void setState(String state) {
    State = state;
  }
}
