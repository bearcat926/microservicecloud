package edu.bearcat.microservice.dao;

import edu.bearcat.microservice.entities.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by haohao on 2019-4-7.
 * 用户Dao层
 */

@Mapper
public interface UserDao {

    public User findUser(User user);

    public boolean addUser(User user);

    public boolean modifyUser(User user);
}
