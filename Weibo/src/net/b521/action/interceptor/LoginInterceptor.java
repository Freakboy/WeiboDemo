package net.b521.action.interceptor;

import java.util.Map;

import net.b521.pojo.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//判断当前用户是否登录，如果没有登录，则重定向到登录页面
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("curr_user");
		
		ActionProxy proxy = invocation.getProxy();
		
		if (user == null) {
			//没有登录的用户
			return "login";
		}else {
			//已登录的用户
			return proxy.execute();
		}
	}
	
}
