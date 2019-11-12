package jbr.spring.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import jbr.spring.model.Login;
import jbr.spring.model.User;
public class UserDaoImpl implements UserDao {
  @Autowired
  DataSource datasource;
  @Autowired
  JdbcTemplate jdbcTemplate;
  public void register(User user) {
    String sql = "insert into users values(1,'cnatea', 'Ausy','cristina.natea4@gmail.com')";
    jdbcTemplate.update(sql, new Object[] { user.getPassword(), user.getEmail() });
    }
    public User validateUser(Login login) {
    String sql = "select * from utilizator where username='" + login.getEmail() + "' and password='" + login.getPassword()
    + "'";
    List<User> users = jdbcTemplate.query(sql, new UserMapper());
    return users.size() > 0 ? users.get(0) : null;
    }
  }
  class UserMapper implements RowMapper<User> {
  public User mapRow(ResultSet rs, int arg1) throws SQLException {
    User user = new User();
    user.setPassword(rs.getString("password"));
    user.setEmail(rs.getString("email"));
    
    return user;
  }
}

