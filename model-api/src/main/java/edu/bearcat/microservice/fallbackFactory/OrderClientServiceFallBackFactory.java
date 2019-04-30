package edu.bearcat.microservice.fallbackFactory;

import edu.bearcat.microservice.entities.Order;
import edu.bearcat.microservice.entities.ProductVO;
import edu.bearcat.microservice.service.OrderClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by haohao on 2019-4-11.
 */
@Component
public class OrderClientServiceFallBackFactory implements FallbackFactory<OrderClientService>{
    @Override
    public OrderClientService create(Throwable cause) {
        return new OrderClientService() {
            @Override
            public List<Order> findByIds(Order order) {
                return null;
            }

            @Override
            public Order findByOrderId(Order order) {
                return null;
            }

            @Override
            public boolean addOrder(Order order) {
                return false;
            }

            @Override
            public boolean addOrderDetails(ProductVO productVO) {
                return false;
            }

            @Override
            public boolean modifyOrder(Order order) {
                return false;
            }
        };
    }
}
