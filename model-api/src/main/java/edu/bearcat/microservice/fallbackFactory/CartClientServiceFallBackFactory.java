package edu.bearcat.microservice.fallbackFactory;

import edu.bearcat.microservice.entities.Cart;
import edu.bearcat.microservice.entities.ProductVO;
import edu.bearcat.microservice.service.CartClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * Created by haohao on 2019-4-10.
 */
@Component  //必须添加这个注解，不然Fallback不会生效
public class CartClientServiceFallBackFactory implements FallbackFactory<CartClientService> {
    @Override
    public CartClientService create(Throwable cause) {
        return new CartClientService() {
            @Override
            public Cart findByIds(Cart cart) {
                return null;
            }

            @Override
            public Cart findByCartId(Cart cart) {
                return null;
            }

            @Override
            public boolean addCart(Cart cart) {
                return false;
            }

            @Override
            public boolean addCartDetails(ProductVO productVO) {
                return false;
            }

            @Override
            public boolean modifyCart(Cart cart) {
                return false;
            }

            @Override
            public boolean modifyCartDetails(ProductVO productVO) {
                return false;
            }

            @Override
            public boolean removeCart(Cart cart) {
                return false;
            }

            @Override
            public boolean removeCartDetails(ProductVO productVO) {
                return false;
            }
        };
    }
}
