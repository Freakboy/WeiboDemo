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
	 * 去登录页面
	 * @return
	 */
	public String toLogin() {
		return "success";
	}
	
	/**
	 * 去用户注册页面
	 * @return
	 */
	public String toReg() {
		return "success";
	}
	
	/**
	 * 用户注册
	 * @return
	 */
	public String userReg() {
		userService.save(user);
		return "success";
	}
	
	/**
	 * 用户登录操作
	 * @return
	 */
	public String login() {
		User dbUser = userService.login(user);
		if (dbUser == null) {
			//账户或密码错误
			return "error";
		} else {
			//登录成功,将登录成功的用户放入session中
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
