package edu.bearcat.microservice.service;

import edu.bearcat.microservice.entities.Menu;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author haohao
 * @since 2019-04-11
 */
public interface IMenuService{

    public List<Menu> selectById(Menu menu);

    public boolean insertMenu(Menu menu);

    public boolean updateMenu(Menu menu);

    public boolean deleteMenu(Menu menu);
}
