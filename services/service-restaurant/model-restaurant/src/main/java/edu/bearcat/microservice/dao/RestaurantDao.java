package edu.bearcat.microservice.dao;

import edu.bearcat.microservice.entities.Restaurant;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 餐馆表 Mapper 接口
 * </p>
 *
 * @author haohao
 * @since 2019-04-11
 */
@Mapper
public interface RestaurantDao {

    public Restaurant selectById(Restaurant restaurant);

    public List<Restaurant> selectRestaurantList(Restaurant restaurant);

    public boolean insertRestaurant(Restaurant restaurant);

    public boolean updateRestaurant(Restaurant restaurant);

    public boolean deleteRestaurant(Restaurant restaurant);
}
