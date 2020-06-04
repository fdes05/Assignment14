package com.fabio.Assignment14.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fabio.Assignment14.domain.Message;
import com.fabio.Assignment14.domain.MessageDto;
import com.fabio.Assignment14.domain.User;
import com.fabio.Assignment14.service.MessageService;
import com.fabio.Assignment14.service.UserService;

@RestController
public class MessageController {
	
	@Autowired
	UserService userServ;
	
	@Autowired
	MessageService messageServ;
	
	@GetMapping(path = "/channel/{channelId}/get", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Message> getChannelMessages(@PathVariable Long channelId) {
		List<Message> listOfMessages = messageServ.getMessages(channelId);
		return listOfMessages;	
		
	}
			
	@PostMapping("/channel/{channelId}")
	public void saveChannelMessage(@RequestBody MessageDto messageDto) {
		String userName = messageDto.getUserName();
		String message = messageDto.getMessage();
		Long channelId = messageDto.getChannelId();
		messageServ.saveMessage(message, userName, channelId);
		
	}
	
	@PostMapping(value = "/register/checkUser" )
	@ResponseBody
	public Boolean checkUserNameExists(@RequestBody String userName) {
		if (userName != "null") {
			Boolean resultUserExists = userServ.verifyUserDoesNotExist(userName);
			if (resultUserExists == false) {
				return false;
			} 
			return true;
		} return true;		
	}
	
		
}
