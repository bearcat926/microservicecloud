package edu.bearcat.microservice.service;

import edu.bearcat.microservice.entities.Restaurant;
import edu.bearcat.microservice.fallbackFactory.RestaurantClientServiceFallBackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by haohao on 2019-4-11.
 */
@FeignClient(value = "springcloud-service-restaurant",fallbackFactory = RestaurantClientServiceFallBackFactory.class)
@RequestMapping("/restaurant")
public interface RestaurantClientService {

    @RequestMapping(value = "/id", method = RequestMethod.GET)
    public Restaurant findById(Restaurant restaurant);

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Restaurant> findRestaurantList(Restaurant restaurant);

    @RequestMapping(value = "", method = RequestMethod.POST)
    public boolean addRestaurant(@RequestBody Restaurant restaurant);

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public boolean modifyRestaurant(@RequestBody Restaurant restaurant);

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public boolean removeRestaurant(@RequestBody Restaurant restaurant);
}
