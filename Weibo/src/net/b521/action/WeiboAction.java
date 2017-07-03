package net.b521.action;

import java.util.List;
import java.util.Map;

import net.b521.pojo.Message;
import net.b521.pojo.User;
import net.b521.services.MessageService;

import com.opensymphony.xwork2.ActionContext;

public class WeiboAction {
	
	private MessageService messageService;
	
	private Message message;
	
	private List<Message> messageList;
	
	/**
	 * 微博首页
	 * @return
	 */
	public String execute() {
		messageList = messageService.findAll();
		return "success";
	}
	
	/**
	 * 发布新微博
	 * @param messageService
	 */
	
	public String save() {
		//获取当前登录用户
		Map<String, Object> session = ActionContext.getContext().getSession();
		
		User user = (User) session.get("curr_user");
		message.setUser(user);
		messageService.save(message);
		return "success";
	}
	
	//get and set
	
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	
	public Message getMessage() {
		return message;
	}
	
	public void setMessage(Message message) {
		this.message = message;
	}
	
	public List<Message> getMessageList() {
		return messageList;
	}
	
	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}

}
