package jbr.spring.dao;
import jbr.spring.model.Login;
import jbr.spring.model.User;
public interface UserDao {
  void register(User user);
  User validateUser(Login login);
}
