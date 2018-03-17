package com.iapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.iapp.entities.LiveUpdate;
import com.iapp.entities.Match;
import com.iapp.entities.MatchData;
import com.iapp.entities.ScoreCard;

@Controller
@RequestMapping("/Match")
public class ScoreBoardController {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ScoreBoardController.class.getName());
	
	@RequestMapping(value = "/TeamsData", method = RequestMethod.GET,produces = "application/json")
	@JsonInclude(value=Include.NON_ABSENT)
	public @ResponseBody Object fetchDBInfo(@RequestParam(value = "matchID",required=true) String matchID,HttpServletRequest servletRequest) {
		
		MatchData matchData = getTeamsByMatchNumber(Integer.parseInt(matchID));
		matchData.setTossCallOptions(setTossCallOptions());
		
		return matchData;
		
	}
	
	
	
	@RequestMapping(value = "/StartGame", method = RequestMethod.GET,produces = "application/json")
	@JsonInclude(value=Include.NON_ABSENT)
	public @ResponseBody Object startGame(@RequestParam(value = "matchID",required=true) String matchID, @RequestParam(value = "tossWinningTeam",required=true) String tossWinningTeam, @RequestParam(value = "TossWinningOption",required=true) String TossWinningOption,HttpServletRequest servletRequest) {
		
		Match match = setGameInfoToUI(Integer.parseInt(matchID));
		
		return match;
		
	}
	
	
	@RequestMapping(value = "/LiveUpdate", method = RequestMethod.POST,produces = "application/json")
	@JsonInclude(value=Include.NON_ABSENT)
	public @ResponseBody Object liveUpdate(@RequestBody LiveUpdate liveUpdate, HttpServletRequest servletRequest) {
		
		System.out.println(liveUpdate);
		
		return liveUpdate;
		
	}
	
	
	//Fetch No of Sets for the game and each set points
	private Match setGameInfoToUI(Integer matchID) {
		Match match = new Match();
		
		MatchData matchData = getTeamsByMatchNumber(matchID);
		
		ScoreCard scoreCard = new ScoreCard();
		Map<Integer, Integer> gameForSetsAndPoints = new HashMap<Integer, Integer>();
		gameForSetsAndPoints.put(1, 25);
		gameForSetsAndPoints.put(2,25);
		gameForSetsAndPoints.put(3,15);
		
		
		
		match.setInitialScore(0);
		match.setSetNo(1);
		match.setTeamName(matchData.getTeams());
		match.setGameForSetsAndPoints(gameForSetsAndPoints);
		
		
		return match;
	}
	
	
	//Mock data for fetching teams by match number
	private MatchData getTeamsByMatchNumber(Integer matchID) {
		MatchData match = new MatchData();
		List<MatchData> matchData = new ArrayList<MatchData>();
		
		List<String> teams = new ArrayList<String>();
		List<String> teams2 = new ArrayList<String>();
		List<String> teams3 = new ArrayList<String>();
		
		MatchData data = new MatchData();
		MatchData data2 = new MatchData();
		MatchData data3 = new MatchData();
		
		teams.add("One");
		teams.add("Two");
		data.setMatchNumber(1);
		data.setTeams(teams);
		
		
		teams2.add("Three");
		teams2.add("Four");
		data2.setMatchNumber(2);
		data2.setTeams(teams2);
		
		
		teams3.add("Five");
		teams3.add("Six");
		data3.setMatchNumber(3);
		data3.setTeams(teams3);
		
		matchData.add(data);
		matchData.add(data2);
		matchData.add(data3);
		
		
		for(MatchData data4 : matchData) {
			if(data4.getMatchNumber().equals(matchID)) {
				return data4;
			}
		}
		
		return match;
		
	}
	
	
	private List<String> setTossCallOptions(){
		
		List<String> options = new ArrayList<String>();
		options.add("Service");
		options.add("Court");
		options.add("Court and Receiving");
		
		return options;
		
	}

}
