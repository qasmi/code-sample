package com.restaurantsolidaire.controller;

import com.restaurantsolidaire.model.Restaurant;
import com.restaurantsolidaire.service.RestaurantService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

  private RestaurantService helloWorldService;

  public RestaurantController(RestaurantService helloWorldService) {
    this.helloWorldService = helloWorldService;
  }

  @GetMapping("index")
  public List<Restaurant> getAllRestaurants() {
    return helloWorldService.getAllRestaurant();
  }
}
