package com.iapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iapp.dao.IMatchDetailsDao;

@Service
public class MatchDetailsServiceImpl implements IMatchDetailsService {
	
	@Autowired IMatchDetailsDao iMatchDetailsDao;

	@Override
	public List<String> getTeamsData() {
		return iMatchDetailsDao.getTeamsData();
	}

}
