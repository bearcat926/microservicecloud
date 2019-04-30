package edu.bearcat.microservice.service.impl;

import edu.bearcat.microservice.dao.OrderDao;
import edu.bearcat.microservice.entities.Order;
import edu.bearcat.microservice.entities.ProductVO;
import edu.bearcat.microservice.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author haohao
 * @since 2019-04-11
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderDao orderDao;
    @Override
    public List<Order> selectByIds(Order order) {
        return orderDao.selectByIds(order);
    }

    @Override
    public Order selectByOrderId(Order order) {
        return orderDao.selectByOrderId(order);
    }

    @Override
    public boolean insertOrder(Order order) {
        return orderDao.insertOrder(order);
    }

    @Override
    public boolean insertOrderDetails(ProductVO productVO) {
        return orderDao.insertOrderDetails(productVO);
    }

    @Override
    public boolean updateOrder(Order order) {
        return orderDao.updateOrder(order);
    }
}
