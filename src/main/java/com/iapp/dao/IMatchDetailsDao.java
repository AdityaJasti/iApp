package com.iapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface IMatchDetailsDao {

	// for loading the team data before match start
	public List<String> getTeamsData();

}
