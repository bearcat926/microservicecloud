package edu.bearcat.microservice.controller;


import edu.bearcat.microservice.entities.Menu;
import edu.bearcat.microservice.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author haohao
 * @since 2019-04-11
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<Menu> selectById(@RequestBody Menu menu) {
        return menuService.selectById(menu);
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public boolean insertMenu(@RequestBody Menu menu) {
        return menuService.insertMenu(menu);
    }

    @RequestMapping(value = "",method = RequestMethod.PUT)
    public boolean updateMenu(@RequestBody Menu menu) {
        return menuService.updateMenu(menu);
    }

    @RequestMapping(value = "",method = RequestMethod.DELETE)
    public boolean deleteMenu(@RequestBody Menu menu) {
        return menuService.deleteMenu(menu);
    }

}
