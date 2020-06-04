package com.fabio.Assignment14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabio.Assignment14.domain.Channel;
import com.fabio.Assignment14.domain.Message;
import com.fabio.Assignment14.repository.MessageRepository;

@Service
public class MessageService {

	@Autowired
	MessageRepository messageRepo;
	
	public List<Message> getMessages(Long channelId) {
		
		List<Message> messagesByChannelId = messageRepo.getAllMessagesByChannelId(channelId);
		return messagesByChannelId;
	}
	
	public void saveMessage(String message, String userName, Long channelId) {
		Message newMessage = new Message();
		newMessage.setMessage(message);
		newMessage.setUserName(userName);
		newMessage.setChannelId(channelId);
		messageRepo.saveMessages(newMessage);
	}
}
