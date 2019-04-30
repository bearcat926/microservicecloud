package edu.bearcat.microservice.dao;

import edu.bearcat.microservice.entities.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author haohao
 * @since 2019-04-11
 */
@Mapper
public interface MenuDao{

    public List<Menu> selectById(Menu menu);

    public boolean insertMenu(Menu menu);

    public boolean updateMenu(Menu menu);

    public boolean deleteMenu(Menu menu);

}
