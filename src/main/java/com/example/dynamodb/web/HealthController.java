package com.example.dynamodb.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HealthController {
  @RequestMapping(method = RequestMethod.GET)
  public String index() {
    return "index";
  }
}
