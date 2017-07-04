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
		//�жϵ�ǰ�û��Ƿ��¼�����û�е�¼�����ض��򵽵�¼ҳ��
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("curr_user");
		
		ActionProxy proxy = invocation.getProxy();
		
		if (user == null) {
			//û�е�¼���û�
			return "login";
		}else {
			//�ѵ�¼���û�
			return proxy.execute();
		}
	}
	
}
