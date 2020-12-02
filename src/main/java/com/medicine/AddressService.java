package com.medicine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

  @Autowired
  AddressRepository addressRepository;

  public Address getAddressById(long id) {
    return addressRepository.findById(id).get();
  }

  public void saveOrUpdate(Address address) {
//    System.out.println("address::---->"+address);
//    System.out.println("id"+address.getAddressID());
//    System.out.println("cn"+address.getContactName());
//    System.out.println("cn"+address.getContactNumber());
//    System.out.println("c"+address.getCity());
//    System.out.println(address);
    addressRepository.save(address);
  }

}
