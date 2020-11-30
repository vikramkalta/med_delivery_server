package com.medicine;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ApiController {
  private ProductService productService;

  @Autowired
  public ApiController(ProductService productService) {
    super();
    this.productService = productService;
  }

  @GetMapping("/products")
  public HashMap<String, Object> getAllProducts() {

    List<Product> products = this.productService.getAllProducts();

    HashMap<String, Object> map = new HashMap<>();
    map.put("statusCode", 200);
    map.put("data", products);

    return map;
  }
}
