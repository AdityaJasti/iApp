package com.iapp.entities;

import java.io.Serializable;

public class LiveUpdate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2798422084230357108L;

	private Integer setNumber;
	private String teamAlpha;
	private String teamEcho;

	private Integer teamAlphaScore;
	private Integer teamEchoScore;
	private Integer teamAlphaTimeOuts;
	private Integer teamEchoTimeOuts;

	private String matchWonBy;

	private Integer setsWonByAlpha;
	private Integer setsWonByEcho;

	public Integer getSetNumber() {
		return setNumber;
	}

	public void setSetNumber(Integer setNumber) {
		this.setNumber = setNumber;
	}

	public String getTeamAlpha() {
		return teamAlpha;
	}

	public void setTeamAlpha(String teamAlpha) {
		this.teamAlpha = teamAlpha;
	}

	public String getTeamEcho() {
		return teamEcho;
	}

	public void setTeamEcho(String teamEcho) {
		this.teamEcho = teamEcho;
	}

	public Integer getTeamAlphaScore() {
		return teamAlphaScore;
	}

	public void setTeamAlphaScore(Integer teamAlphaScore) {
		this.teamAlphaScore = teamAlphaScore;
	}

	public Integer getTeamEchoScore() {
		return teamEchoScore;
	}

	public void setTeamEchoScore(Integer teamEchoScore) {
		this.teamEchoScore = teamEchoScore;
	}

	public Integer getTeamAlphaTimeOuts() {
		return teamAlphaTimeOuts;
	}

	public void setTeamAlphaTimeOuts(Integer teamAlphaTimeOuts) {
		this.teamAlphaTimeOuts = teamAlphaTimeOuts;
	}

	public Integer getTeamEchoTimeOuts() {
		return teamEchoTimeOuts;
	}

	public void setTeamEchoTimeOuts(Integer teamEchoTimeOuts) {
		this.teamEchoTimeOuts = teamEchoTimeOuts;
	}

	public String getMatchWonBy() {
		return matchWonBy;
	}

	public void setMatchWonBy(String matchWonBy) {
		this.matchWonBy = matchWonBy;
	}

	public Integer getSetsWonByAlpha() {
		return setsWonByAlpha;
	}

	public void setSetsWonByAlpha(Integer setsWonByAlpha) {
		this.setsWonByAlpha = setsWonByAlpha;
	}

	public Integer getSetsWonByEcho() {
		return setsWonByEcho;
	}

	public void setSetsWonByEcho(Integer setsWonByEcho) {
		this.setsWonByEcho = setsWonByEcho;
	}

}
