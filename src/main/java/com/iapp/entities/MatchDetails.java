package com.iapp.entities;

import java.io.Serializable;
import java.util.Map;

public class MatchDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 835485535676224999L;

	// Top header binding
	private Map<Integer, String> matchTeams;
	private Map<Integer, String> tossWonBy;
	private Map<Integer, String> choiceAfterToss;
	private boolean walkOver;
	private Map<Integer, String> walkOverGivenTo;
	// TRUE - only when walkover is given
	private boolean endGame;

	// For Live score of Teams and update on UI module
	private Integer setNumber;
	private Map<Integer, String> teamOne;
	private Map<Integer, String> teamTwo;

	// Winning Team
	private String matchWonBy;

	// Match stats table
	private Match matchData;

}
