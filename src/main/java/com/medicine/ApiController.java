package com.medicine;

import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ApiController {
  private ProductService productService;
  private AddressService addressService;
  private CartProductService cartProductService;

  private  static final Logger LOGGER = LoggerFactory.getLogger(ApiController.class);


  @Autowired
  public ApiController(AddressService addressService,ProductService productService, CartProductService cartProductService) {
    super();
    this.productService = productService;
    this.addressService = addressService;
    this.cartProductService = cartProductService;
  }

  @GetMapping("/products")
  public HashMap<String, Object> getAllProducts() {

    List<Product> products = this.productService.getAllProducts();

    HashMap<String, Object> map = new HashMap<>();
    map.put("statusCode", 200);
    map.put("data", products);

    return map;
  }

  @GetMapping("/address/{id}")
  private HashMap<String, Object> getAddress(@PathVariable("id") long id) {
    HashMap<String, Object> map = new HashMap<>();
    map.put("statusCode", 200);
    map.put("data", addressService.getAddressById(id));
    return map;
  }

  @PostMapping("/address")
  private HashMap<String, Object> saveAddress(@RequestBody Address address) {
//    LOGGER.info("test--->: {}",new String(address, StandardCharsets.UTF_8));
    addressService.saveOrUpdate(address);

    HashMap<String, Object> map = new HashMap<>();
    map.put("statusCode", 200);
    map.put("data", address.getAddressID());
    return  map;
  }

  @GetMapping("/cart-product/{id}")
  private HashMap<String, Object> cartProduct(@PathVariable("id") long id) {
    HashMap<String, Object> map = new HashMap<>();
    map.put("statusCode", 200);
    map.put("data", cartProductService.findById(id));
    return  map;
  }

  @PostMapping("/cart-product")
  private HashMap<String, Object> bulkInsert(@RequestBody List<CartProduct> cartProducts) {
    LOGGER.info("cart-product post: {}",cartProducts);
    HashMap<String, Object> map = new HashMap<>();
    map.put("statusCode", 200);
    map.put("data", cartProductService.bulkInsert(cartProducts));
    return map;
  }

  @GetMapping("/order-summary/{id}")
  private HashMap<String, Object> getOrderSummary(@PathVariable("id") long id) {
    HashMap<String, Object> map = new HashMap<>();
    map.put("statusCode", 200);
    map.put("data", cartProductService.getOrderSummary(id));
    return map;
  }
}
