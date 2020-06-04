package com.fabio.Assignment14.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.fabio.Assignment14.domain.Channel;
import com.fabio.Assignment14.domain.Message;
import com.fabio.Assignment14.repository.ChannelRepository;
import com.fabio.Assignment14.service.ChannelService;
import com.fabio.Assignment14.service.MessageService;
import com.fabio.Assignment14.service.UserService;

@Controller
public class ChannelController {

	@Autowired
	ChannelService channelServ;
	@Autowired
	ChannelRepository channelRepo;
	@Autowired
	MessageService messageServ;
	@Autowired
	UserService userServ;
	
	@GetMapping("/channel/{channelId}")
	public String getChannel(@PathVariable Long channelId, ModelMap model) {
		Channel channel = channelServ.getChannelById(channelId);
		List<Message> channelMessages = messageServ.getMessages(channelId);
		model.put("channel", channel);
		model.put("messages", channelMessages);
		return "channel";
	}
	
	
		
	@GetMapping("/welcome")
	public String getWelcomePage(ModelMap model) {
		List<Channel> channelList = channelRepo.getListOfChannels();
		model.put("channels", channelList);
		model.put("newChannel", new Channel());
				
		return "welcome";
	}
	
	@PostMapping ("/welcome")
	public String saveChannel(Channel newChannel) {
		String channelName = newChannel.getChannelName();
		channelServ.saveChannel(channelName);
		
		return "redirect:/welcome";
	}
}
