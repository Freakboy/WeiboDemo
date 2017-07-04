package net.b521.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import net.b521.pojo.User;
import net.b521.services.UserService;

public class UserAction {
	
	private UserService userService;
	
	private List<User> userList;
	private User user;
	
	public String execute() {
		userList = userService.findAll();
		System.out.println("Hello Struts2 :" + userList.size());
		return "success";
	}
	
	/**
	 * ȥ��¼ҳ��
	 * @return
	 */
	public String toLogin() {
		return "success";
	}
	
	/**
	 * ȥ�û�ע��ҳ��
	 * @return
	 */
	public String toReg() {
		return "success";
	}
	
	/**
	 * �û�ע��
	 * @return
	 */
	public String userReg() {
		userService.save(user);
		return "success";
	}
	
	/**
	 * �û���¼����
	 * @return
	 */
	public String login() {
		User dbUser = userService.login(user);
		if (dbUser == null) {
			//�˻����������
			return "error";
		} else {
			//��¼�ɹ�,����¼�ɹ����û�����session��
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("curr_user", dbUser);
			return "success";
		}
	}
	
	//get and set
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
