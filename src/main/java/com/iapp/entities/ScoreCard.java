package com.iapp.entities;

import java.io.Serializable;
import java.util.Map;

public class ScoreCard implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4762214037274271179L;

	private Map<Integer, Integer> gameForSetsAndPoints;

	public Map<Integer, Integer> getGameForSetsAndPoints() {
		return gameForSetsAndPoints;
	}

	public void setGameForSetsAndPoints(Map<Integer, Integer> gameForSetsAndPoints) {
		this.gameForSetsAndPoints = gameForSetsAndPoints;
	}

}
