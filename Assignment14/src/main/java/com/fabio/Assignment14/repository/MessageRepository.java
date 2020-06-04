package com.fabio.Assignment14.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.fabio.Assignment14.domain.Message;

@Repository
public class MessageRepository {

	List<Message> messageList = new ArrayList<>();
	
	public void saveMessages(Message message) {
		int numberOfElements = messageList.size();
		Long messageId = numberOfElements + 1L;
		message.setMessageId(messageId);
		messageList.add(message);
		
	}
	
	public List<Message> getAllMessagesByChannelId(Long channelId) {
		if (messageList != null) {
			List<Message> messagesByChannel = messageList.stream()
					.filter(o -> o.getChannelId().equals(channelId))
		            .collect(Collectors.toList());
			return messagesByChannel;
		} 
		List<Message> emptyList = new ArrayList<>();
		return emptyList;
		
	}
}
