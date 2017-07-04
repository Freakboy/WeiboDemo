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
	 * ΢����ҳ
	 * @return
	 */
	public String execute() {
		messageList = messageService.findAll();
		return "success";
	}
	
	/**
	 * ������΢��
	 * @param messageService
	 */
	
	public String save() {
		//��ȡ��ǰ��¼�û�
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
