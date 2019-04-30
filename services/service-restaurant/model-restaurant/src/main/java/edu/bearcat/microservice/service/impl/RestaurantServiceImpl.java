package edu.bearcat.microservice.service.impl;

import edu.bearcat.microservice.dao.RestaurantDao;
import edu.bearcat.microservice.entities.Restaurant;
import edu.bearcat.microservice.service.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 餐馆表 服务实现类
 * </p>
 *
 * @author haohao
 * @since 2019-04-11
 */
@Service
public class RestaurantServiceImpl implements IRestaurantService {

    @Autowired
    private RestaurantDao restaurantDao;

    @Override
    public Restaurant selectById(Restaurant restaurant) {
        return restaurantDao.selectById(restaurant);
    }

    @Override
    public List<Restaurant> selectRestaurantList(Restaurant restaurant) {
        return restaurantDao.selectRestaurantList(restaurant);
    }

    @Override
    public boolean insertRestaurant(Restaurant restaurant) {
        return restaurantDao.insertRestaurant(restaurant);
    }

    @Override
    public boolean updateRestaurant(Restaurant restaurant) {
        return restaurantDao.updateRestaurant(restaurant);
    }

    @Override
    public boolean deleteRestaurant(Restaurant restaurant) {
        return restaurantDao.deleteRestaurant(restaurant);
    }
}
