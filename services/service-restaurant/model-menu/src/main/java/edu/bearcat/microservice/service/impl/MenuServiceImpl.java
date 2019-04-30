package edu.bearcat.microservice.service.impl;

import edu.bearcat.microservice.dao.MenuDao;
import edu.bearcat.microservice.entities.Menu;
import edu.bearcat.microservice.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author haohao
 * @since 2019-04-11
 */
@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Menu> selectById(Menu menu) {
        return menuDao.selectById(menu);
    }

    @Override
    public boolean insertMenu(Menu menu) {
        return menuDao.insertMenu(menu);
    }

    @Override
    public boolean updateMenu(Menu menu) {
        return menuDao.updateMenu(menu);
    }

    @Override
    public boolean deleteMenu(Menu menu) {
        return menuDao.deleteMenu(menu);
    }
}
