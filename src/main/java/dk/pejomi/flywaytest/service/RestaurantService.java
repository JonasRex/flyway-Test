package dk.pejomi.flywaytest.service;


import dk.pejomi.flywaytest.dto.RestaurantDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestaurantService {

    RestaurantDto createRestaurant(RestaurantDto restaurantDTO);
    RestaurantDto getRestaurantById(Long id);
    List<RestaurantDto> getRestaurantsByZipCode(String zipCode);
    List<RestaurantDto> getRestaurantsByCity(String city);



}
