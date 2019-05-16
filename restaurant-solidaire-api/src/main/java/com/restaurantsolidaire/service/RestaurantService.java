package com.restaurantsolidaire.service;

import com.restaurantsolidaire.model.Restaurant;
import com.restaurantsolidaire.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RestaurantService {

  private RestaurantRepository repository;
  private String env;
  public RestaurantService(RestaurantRepository repository,  @Value("${test}") String env) {
    this.repository = repository;
    this.env = env;
  }

  public List<Restaurant> getAllRestaurant() {
    if(env.equals("local")) {
      repository.save(new Restaurant( 1L, "mongoo in db qa"));
      repository.save(new Restaurant( 1L, "xkki in db qa"));
      return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());
    }
      repository.save(new Restaurant( 1L, "mongoo in db prd"));
      return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());
  }
}
