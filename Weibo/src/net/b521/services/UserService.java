package net.b521.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import net.b521.dao.UserDao;
import net.b521.pojo.User;

@Transactional //事务处理
public class UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public List<User> findAll() {
		return userDao.findAll();
	}
	
	public void save(User user) {
		userDao.save(user);
	}
	
	/**
	 * 判断用户是否登录成功
	 * @param user
	 * @return
	 */
	public User login(User user) {
		//从数据库中查询用户，判断账户和密码是否正确
		User dbUser = userDao.findByUserName(user.getUsername());
		if (dbUser != null && dbUser.getPassword().equals(user.getPassword())) {
			return dbUser;
		}else {
			return null;
		}
		
	}

}
