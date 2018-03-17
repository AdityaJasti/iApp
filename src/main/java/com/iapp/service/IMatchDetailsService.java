package com.iapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.iapp.entities.MatchData;

@Service
public interface IMatchDetailsService {

	//for loading the team data before match start
	public List<String> getTeamsData();
	
}
