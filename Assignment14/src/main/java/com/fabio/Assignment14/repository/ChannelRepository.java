package com.fabio.Assignment14.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fabio.Assignment14.domain.Channel;

@Repository
public class ChannelRepository {

	private List<Channel> listOfChannels = new ArrayList<Channel>();
	
	public void saveChannel(Channel channel) {
		listOfChannels.add(channel);
	}

	public Channel getChannelById(Long channelId) {
		Channel channel = listOfChannels.get(channelId.intValue() - 1);
		return channel;
	}
	
	public List<Channel> getListOfChannels() {
		return listOfChannels;
	}

	public void setListOfChannels(List<Channel> listOfChannels) {
		this.listOfChannels = listOfChannels;
	}
	
	
}
