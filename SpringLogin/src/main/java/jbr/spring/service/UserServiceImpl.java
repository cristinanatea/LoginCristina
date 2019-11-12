package jbr.spring.service;

import org.springframework.beans.factory.annotation.Autowired;

import jbr.spring.dao.UserDao;
import jbr.spring.model.Login;
import jbr.spring.model.User;

public class UserServiceImpl implements UserService {

  @Autowired
  public UserDao userDao;

  public void register(User user) {
    userDao.register(user);
  }

  public User validateUser(Login login) {
    return userDao.validateUser(login);
  }

}
