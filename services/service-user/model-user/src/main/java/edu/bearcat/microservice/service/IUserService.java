package edu.bearcat.microservice.service;


import edu.bearcat.microservice.entities.User;

/**
 * Created by haohao on 2019-4-7.
 * 用户Service层
 */
public interface IUserService {

    public User findUser(User user);

    public boolean addUser(User user);

    public boolean modifyUser(User user);
}
