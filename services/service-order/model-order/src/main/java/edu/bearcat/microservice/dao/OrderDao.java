package edu.bearcat.microservice.dao;

import edu.bearcat.microservice.entities.Order;
import edu.bearcat.microservice.entities.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author haohao
 * @since 2019-04-11
 */
@Mapper
public interface OrderDao {

    public List<Order> selectByIds (Order order);

    public Order selectByOrderId (Order order);

    public boolean insertOrder (Order order);

    public boolean insertOrderDetails(ProductVO productVO);

    public boolean updateOrder (Order order);
}
