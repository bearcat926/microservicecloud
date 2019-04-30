package edu.bearcat.microservice.fallbackFactory;

import edu.bearcat.microservice.entities.Menu;
import edu.bearcat.microservice.service.MenuClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by haohao on 2019-4-12.
 */
@Component
public class MenuClientServiceFallBackFactory implements FallbackFactory<MenuClientService> {
    @Override
    public MenuClientService create(Throwable cause) {
        return new MenuClientService() {
            @Override
            public List<Menu> findById(Menu menu) {
                return null;
            }

            @Override
            public boolean addMenu(Menu menu) {
                return false;
            }

            @Override
            public boolean modifyMenu(Menu menu) {
                return false;
            }

            @Override
            public boolean removeMenu(Menu menu) {
                return false;
            }
        };
    }
}
