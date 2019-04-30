package edu.bearcat.microservice.fallbackFactory;

import edu.bearcat.microservice.entities.Restaurant;
import edu.bearcat.microservice.service.RestaurantClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by haohao on 2019-4-11.
 */
@Component
public class RestaurantClientServiceFallBackFactory implements FallbackFactory<RestaurantClientService> {
    @Override
    public RestaurantClientService create(Throwable cause) {
        return new RestaurantClientService() {
            @Override
            public Restaurant findById(Restaurant restaurant) {
                return null;
            }

            @Override
            public List<Restaurant> findRestaurantList(Restaurant restaurant) {
                return null;
            }

            @Override
            public boolean addRestaurant(Restaurant restaurant) {
                return false;
            }

            @Override
            public boolean modifyRestaurant(Restaurant restaurant) {
                return false;
            }

            @Override
            public boolean removeRestaurant(Restaurant restaurant) {
                return false;
            }
        };
    }
}
