package net.b521.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import net.b521.dao.UserDao;
import net.b521.pojo.User;

@Transactional //������
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
	 * �ж��û��Ƿ��¼�ɹ�
	 * @param user
	 * @return
	 */
	public User login(User user) {
		//�����ݿ��в�ѯ�û����ж��˻��������Ƿ���ȷ
		User dbUser = userDao.findByUserName(user.getUsername());
		if (dbUser != null && dbUser.getPassword().equals(user.getPassword())) {
			return dbUser;
		}else {
			return null;
		}
		
	}

}
