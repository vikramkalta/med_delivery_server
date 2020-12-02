package com.medicine;

import javax.persistence.*;

@Entity
@Table(name = "Address")
public class Address {
  @Id
  @Column(name = "AddressID")
//  @GeneratedValue(strategy = GenerationType.AUTO)
//  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @GeneratedValue
  private long AddressID;

  @Column(name = "ContactName")
  private String ContactName;

  @Column(name = "ContactNumber")
  private String ContactNumber;

  @Column(name = "Pincode")
  private String Pincode;

  @Column(name = "StreetAddress")
  private String StreetAddress;

  @Column(name = "City")
  private String City;

  @Column(name = "State")
  private String State;

  public long getAddressID() {
    return AddressID;
  }

  public void setAddressID(long addressID) {
    AddressID = addressID;
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
