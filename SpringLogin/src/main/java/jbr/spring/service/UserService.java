package jbr.spring.service;

import jbr.spring.model.Login;
import jbr.spring.model.User;

public interface UserService {

  void register(User user);

  User validateUser(Login login);
}
