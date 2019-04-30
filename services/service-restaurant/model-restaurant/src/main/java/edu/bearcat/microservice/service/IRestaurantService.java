package edu.bearcat.microservice.service;

import edu.bearcat.microservice.entities.Restaurant;

import java.util.List;

/**
 * <p>
 * 餐馆表 服务类
 * </p>
 *
 * @author haohao
 * @since 2019-04-11
 */
public interface IRestaurantService {

    public Restaurant selectById(Restaurant restaurant);

    public List<Restaurant> selectRestaurantList(Restaurant restaurant);

    public boolean insertRestaurant(Restaurant restaurant);

    public boolean updateRestaurant(Restaurant restaurant);

    public boolean deleteRestaurant(Restaurant restaurant);
}
