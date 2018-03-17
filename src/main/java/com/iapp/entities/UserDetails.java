package com.iapp.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class UserDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3619188533464455440L;

	private String username;
	private String password;

	private String userrole;

	private Map<Integer, String> matches;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

	public Map<Integer, String> getMatches() {
		return matches;
	}

	public void setMatches(Map<Integer, String> matches) {
		this.matches = matches;
	}

}
