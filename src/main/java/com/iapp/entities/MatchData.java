package com.iapp.entities;

import java.io.Serializable;
import java.util.List;

public class MatchData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2237277035495456840L;

	private Integer dayNumber;
	private Integer matchNumber;
	private String scheduledMatch;
	private String scheduledTime;

	private List<String> teams;

	private List<String> tossCallOptions;

	public List<String> getTossCallOptions() {
		return tossCallOptions;
	}

	public void setTossCallOptions(List<String> tossCallOptions) {
		this.tossCallOptions = tossCallOptions;
	}

	public Integer getDayNumber() {
		return dayNumber;
	}

	public void setDayNumber(Integer dayNumber) {
		this.dayNumber = dayNumber;
	}

	public Integer getMatchNumber() {
		return matchNumber;
	}

	public void setMatchNumber(Integer matchNumber) {
		this.matchNumber = matchNumber;
	}

	public String getScheduledMatch() {
		return scheduledMatch;
	}

	public void setScheduledMatch(String scheduledMatch) {
		this.scheduledMatch = scheduledMatch;
	}

	public String getScheduledTime() {
		return scheduledTime;
	}

	public void setScheduledTime(String scheduledTime) {
		this.scheduledTime = scheduledTime;
	}

	public List<String> getTeams() {
		return teams;
	}

	public void setTeams(List<String> teams) {
		this.teams = teams;
	}

}
