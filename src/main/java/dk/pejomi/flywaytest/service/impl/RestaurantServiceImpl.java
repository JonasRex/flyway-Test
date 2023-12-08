package dk.pejomi.flywaytest.service.impl;


import dk.pejomi.flywaytest.dto.RestaurantDto;
import dk.pejomi.flywaytest.mapper.RestaurantMapper;
import dk.pejomi.flywaytest.model.Restaurant;
import dk.pejomi.flywaytest.repository.RestaurantRepository;
import dk.pejomi.flywaytest.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    @Override
    public RestaurantDto createRestaurant(RestaurantDto restaurantDTO) {

        Restaurant restaurant = restaurantRepository.save(RestaurantMapper.INSTANCE.toRestaurant(restaurantDTO));

        return RestaurantMapper.INSTANCE.toRestaurantDTO(restaurant);

    }

    @Override
    public RestaurantDto getRestaurantById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new RuntimeException("Restaurant not found"));
        return RestaurantMapper.INSTANCE.toRestaurantDTO(restaurant);
    }

    @Override
    public List<RestaurantDto> getRestaurantsByZipCode(String zipCode) {
        List<Restaurant> restaurants = restaurantRepository.findAllByZipCode(zipCode);
        return RestaurantMapper.INSTANCE.toRestaurantDTOs(restaurants);
    }

    @Override
    public List<RestaurantDto> getRestaurantsByCity(String city) {
        List<Restaurant> restaurants = restaurantRepository.findAllByCity(city);
        return RestaurantMapper.INSTANCE.toRestaurantDTOs(restaurants);
    }

}
