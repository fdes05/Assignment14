package com.fabio.Assignment14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabio.Assignment14.domain.Channel;
import com.fabio.Assignment14.repository.ChannelRepository;

@Service
public class ChannelService {

	@Autowired
	ChannelRepository channelRepo;
	
	public void saveChannel(String channelName) {
		int numberOfChannels = channelRepo.getListOfChannels().size();
		Long channelId = numberOfChannels + 1L;
		Channel newChannel = new Channel ();
		newChannel.setChannelId(channelId);
		newChannel.setChannelName(channelName);
		channelRepo.saveChannel(newChannel);
	}

	public Channel getChannelById(Long channelId) {
		
		return channelRepo.getChannelById(channelId);
				
	}
}
