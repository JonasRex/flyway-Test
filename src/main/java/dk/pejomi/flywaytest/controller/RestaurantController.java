package dk.pejomi.flywaytest.controller;


import dk.pejomi.flywaytest.dto.RestaurantDto;
import dk.pejomi.flywaytest.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
@RequiredArgsConstructor
@Slf4j
public class RestaurantController {

    private final RestaurantService restaurantService;



    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDto> getRestaurantById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(restaurantService.getRestaurantById(id));
        } catch (RuntimeException e) {
            log.error("Restaurant not found with id [{}]", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @GetMapping("/zip/{zipCode}")
    public ResponseEntity<List<RestaurantDto>> getRestaurantsByZipCode(@PathVariable String zipCode) {
        return ResponseEntity.ok(restaurantService.getRestaurantsByZipCode(zipCode));
    }


    @GetMapping("/city/{city}")
    public ResponseEntity<List<RestaurantDto>> getRestaurantsByCity(@PathVariable String city) {
        return ResponseEntity.ok(restaurantService.getRestaurantsByCity(city));
    }
}
