package dk.pejomi.flywaytest.mapper;


import dk.pejomi.flywaytest.dto.RestaurantDto;
import dk.pejomi.flywaytest.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RestaurantMapper {

    RestaurantMapper INSTANCE = Mappers.getMapper( RestaurantMapper.class );

    @Mapping(target = "userId", source = "id")
    Restaurant toRestaurant(RestaurantDto restaurantDTO);

    RestaurantDto toRestaurantDTO(Restaurant restaurant);

    List<RestaurantDto> toRestaurantDTOs(List<Restaurant> restaurants);

}
