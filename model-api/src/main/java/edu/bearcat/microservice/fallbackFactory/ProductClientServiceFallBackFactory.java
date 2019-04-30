package edu.bearcat.microservice.fallbackFactory;

import edu.bearcat.microservice.entities.Product;
import edu.bearcat.microservice.service.ProductClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by haohao on 2019-4-12.
 */
@Component
public class ProductClientServiceFallBackFactory implements FallbackFactory<ProductClientService>{
    @Override
    public ProductClientService create(Throwable cause) {
        return new ProductClientService() {
            @Override
            public Product findById(Product product) {
                return null;
            }

            @Override
            public List<Product> findProductList(Product product) {
                return null;
            }

            @Override
            public boolean addProduct(Product product) {
                return false;
            }

            @Override
            public boolean modifyProduct(Product product) {
                return false;
            }

            @Override
            public boolean removeProduct(Product product) {
                return false;
            }
        };
    }
}
