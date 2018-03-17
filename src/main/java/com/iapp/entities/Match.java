package com.iapp.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Match implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2017761861857898249L;

	private Integer setNo;
	private Integer initialScore;
	private List<String> teamName;

	Map<Integer, Integer> gameForSetsAndPoints;

	public Integer getSetNo() {
		return setNo;
	}

	public void setSetNo(Integer setNo) {
		this.setNo = setNo;
	}

	public Integer getInitialScore() {
		return initialScore;
	}

	public void setInitialScore(Integer initialScore) {
		this.initialScore = initialScore;
	}

	public List<String> getTeamName() {
		return teamName;
	}

	public void setTeamName(List<String> teamName) {
		this.teamName = teamName;
	}

	public Map<Integer, Integer> getGameForSetsAndPoints() {
		return gameForSetsAndPoints;
	}

	public void setGameForSetsAndPoints(Map<Integer, Integer> gameForSetsAndPoints) {
		this.gameForSetsAndPoints = gameForSetsAndPoints;
	}

}
