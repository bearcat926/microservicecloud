package edu.bearcat.microservice.controller;


import edu.bearcat.microservice.entities.Restaurant;
import edu.bearcat.microservice.service.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 餐馆表 前端控制器
 * </p>
 *
 * @author haohao
 * @since 2019-04-11
 */
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private IRestaurantService restaurantService;

    @RequestMapping(value = "/id", method = RequestMethod.GET)
    public Restaurant selectById(@RequestBody Restaurant restaurant) {
        return restaurantService.selectById(restaurant);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Restaurant> selectRestaurantList(@RequestBody Restaurant restaurant) {
        return restaurantService.selectRestaurantList(restaurant);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public boolean insertRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.insertRestaurant(restaurant);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public boolean updateRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.updateRestaurant(restaurant);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public boolean deleteRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.deleteRestaurant(restaurant);
    }
}
