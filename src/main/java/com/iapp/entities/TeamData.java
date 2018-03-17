package com.iapp.entities;

import java.io.Serializable;

public class TeamData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8774336347201322720L;

	private String teamName;
	private Integer matchNo;

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Integer getMatchNo() {
		return matchNo;
	}

	public void setMatchNo(Integer matchNo) {
		this.matchNo = matchNo;
	}

}
