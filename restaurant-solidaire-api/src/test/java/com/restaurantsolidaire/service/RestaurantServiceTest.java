package com.restaurantsolidaire.service;

import com.restaurantsolidaire.model.Restaurant;
import com.restaurantsolidaire.repository.RestaurantRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

import static org.mockito.Mockito.mock;

class RestaurantServiceTest {


    RestaurantRepository repository = mock(RestaurantRepository.class);

    @Test
    void returnHelloWorld() {
        Mockito.when(repository.findAll()).thenReturn(Collections.singletonList(new Restaurant(1L, "Istanbul")));
        RestaurantService service = new RestaurantService(repository, "local");
        Assertions.assertThat(service.getAllRestaurant())
                .extracting(Restaurant::getName)
                .containsExactly("Istanbul");
    }
}
