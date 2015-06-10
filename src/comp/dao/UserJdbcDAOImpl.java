package comp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import comp.orm.User;

public class UserJdbcDAOImpl {

	 private JdbcTemplate jdbcTemplate;

	    public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }
	    public List<User> list() {      
	        
	    	List<User> users = this.jdbcTemplate.query(
	    	        "select id, name from users",
	    	        new RowMapper<User>() {
	    	            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	    	                User user = new User();
	    	                user.setId(rs.getInt("id"));
	    	                user.setName(rs.getString("name"));
	    	                return user;
	    	            }
	    	        });
	    	return users;
	    }
	    
	    public void add(){
	    	this.jdbcTemplate.update("insert into users values (?, ?)",
	    	        145, "jdbcDao1");
	    }
	    
}
