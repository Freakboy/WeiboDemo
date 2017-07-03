package net.b521.services;

import java.util.List;

import net.b521.dao.MessageDao;
import net.b521.pojo.Message;

public class MessageService {

	
	private MessageDao messageDao;
	
	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}
	
	public void save(Message message) {
		messageDao.save(message);
	}

	public List<Message> findAll() {
		return messageDao.findAll();
	}
	
}
