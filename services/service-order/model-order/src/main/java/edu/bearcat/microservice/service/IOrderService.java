package edu.bearcat.microservice.service;

import edu.bearcat.microservice.entities.Order;
import edu.bearcat.microservice.entities.ProductVO;

import java.util.List;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author haohao
 * @since 2019-04-11
 */
public interface IOrderService {

    public List<Order> selectByIds (Order order);

    public Order selectByOrderId (Order order);

    public boolean insertOrder (Order order);

    public boolean insertOrderDetails(ProductVO productVO);

    public boolean updateOrder (Order order);
}
