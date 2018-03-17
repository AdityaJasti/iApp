package com.iapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.iapp.entities.MatchData;

@Repository
public class MatchDetailsDaoImpl implements IMatchDetailsDao {
	
	
	@Override
	public List<String> getTeamsData() {
		List<MatchData> matchData = new ArrayList<MatchData>();
		MatchData data = new MatchData();
		MatchData data2 = new MatchData();
		MatchData data3 = new MatchData();
		data.setDayNumber(1);
		data.setScheduledMatch("One vs Two");
		data.setScheduledTime("4:30 PM");
		data.setMatchNumber(1);
		data2.setDayNumber(1);
		data2.setScheduledMatch("Three vs Four");
		data2.setScheduledTime("5:00 PM");
		data2.setMatchNumber(2);
		data3.setDayNumber(1);
		data3.setScheduledMatch("Five vs Six");
		data3.setScheduledTime("5:30 PM");
		data3.setMatchNumber(3);
		matchData.add(data);
		matchData.add(data2);
		matchData.add(data3);
		return schedulePrep(matchData);
	}
	
	private List<String> schedulePrep(List<MatchData> matchData){
		List<String> strings = new ArrayList<String>();
		String temp = "";
		for(MatchData match : matchData) {
			temp = match.getMatchNumber()+" "+ match.getScheduledMatch()+" "+ match.getScheduledTime();
			strings.add(temp);
		}
		
		return strings;
		
	}
	
}
