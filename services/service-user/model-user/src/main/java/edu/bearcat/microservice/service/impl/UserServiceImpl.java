package edu.bearcat.microservice.service.impl;

import edu.bearcat.microservice.dao.UserDao;
import edu.bearcat.microservice.entities.User;
import edu.bearcat.microservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by haohao on 2019-4-7.
 * 用户Service层 - 实现类
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    public User findUser(User user) {
        return userDao.findUser(user);
    }

    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    public boolean modifyUser(User user) {
        return userDao.modifyUser(user);
    }
}
