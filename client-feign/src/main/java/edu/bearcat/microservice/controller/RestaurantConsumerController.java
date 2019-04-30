package edu.bearcat.microservice.controller;

import edu.bearcat.microservice.entities.Restaurant;
import edu.bearcat.microservice.service.RestaurantClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by haohao on 2019-4-11.
 */
@SuppressWarnings("unchecked")
@RequestMapping("/consumer/restaurant")
@RestController
public class RestaurantConsumerController {

    @Autowired
    private RestaurantClientService restaurantClientService;

    @ResponseBody
    @RequestMapping(value = "/id", method = RequestMethod.GET)
    public Map<String, Object> findByIds(Restaurant restaurant) {
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("restaurant",restaurantClientService.findById(restaurant));
        return resultMap;
    }

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map<String, Object> findRestaurantList(Restaurant restaurant) {
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("restaurantList",restaurantClientService.findRestaurantList(restaurant));
        return resultMap;
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Map<String, Object> addRestaurant(@RequestBody Restaurant restaurant) {
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("addFlag",restaurantClientService.addRestaurant(restaurant));
        return resultMap;
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Map<String, Object> modifyRestaurant(@RequestBody Restaurant restaurant) {
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("modifyFlag",restaurantClientService.modifyRestaurant(restaurant));
        return resultMap;
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public Map<String, Object> deleteRestaurant(@RequestBody Restaurant restaurant) {
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("removeFlag",restaurantClientService.removeRestaurant(restaurant));
        return resultMap;
    }
}
