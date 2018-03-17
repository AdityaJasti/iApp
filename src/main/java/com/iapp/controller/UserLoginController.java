package com.iapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.iapp.entities.MatchData;
import com.iapp.entities.UserDetails;

/***
 * 
 * @author ajasti
 *
 */
@Controller
@RequestMapping("/User")
public class UserLoginController {

	/**
	 * user login controller - method to validate user
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(UserLoginController.class.getName());
	
	
	//@Autowired IMatchDetailsService iMatchDetailsService;
	
	@RequestMapping(value = "/Login", method = RequestMethod.POST,produces = "application/json")
	@JsonInclude(value=Include.NON_ABSENT)
	public @ResponseBody Object validateUser(@RequestBody UserDetails userLogin, HttpServletRequest servletRequest) throws Exception{
		
		UserDetails userDetails = new UserDetails();
		
		
		
		if(!userLogin.getUsername().isEmpty() && !userLogin.getPassword().isEmpty()){
			
			if(userLogin.getUsername().equalsIgnoreCase("admin")) {
				// code for admin page
				userDetails.setUsername("admin");
				userDetails.setUserrole("ADMIN");
				return new ResponseEntity<>(userDetails,HttpStatus.OK);
			}else if(userLogin.getUsername().equalsIgnoreCase("scoreboard")) {
				// code for score board page
				userDetails.setUsername("scoreboard");
				userDetails.setUserrole("SCORE");
				userDetails.setMatches(getTeamsData());
				
				servletRequest.getSession().setAttribute("MatchDetails", userDetails);
				return new ResponseEntity<>(userDetails,HttpStatus.OK);
			}else if(userLogin.getUsername().equalsIgnoreCase("lr")) {
				// code for line refree
			}else {
				//code for login page
			}
			
		}
			
					
					/*HttpSession session = servletRequest.getSession();
					if (session.isNew()) {
						servletRequest.getSession().setAttribute("username",userLogin.getUsername());
						System.out.println("Session created for USER -> " +userDetails.getfName() +" with session ID ->" +session.getId());
						userDetails.setValidSession(true);
						userDetails.setSessionID(servletRequest.getSession().getId());
						return new ResponseEntity<>(userDetails,HttpStatus.OK);
						//logger.info("New session is just created---->" + session.getId());
					} else {
						System.out.println("Existing session for USER -> " +userDetails.getfName() +" with session ID ->" +session.getId());
						userDetails.setValidSession(true);
						userDetails.setSessionID(servletRequest.getSession().getId());
						return new ResponseEntity<>(userDetails,HttpStatus.OK);
					}
				}else{
					userDetails.setMessage("Invalid credentials");
					return new ResponseEntity<>(userDetails,HttpStatus.OK);
				}*/
				
				
			return null;
		
	}
	
		
	/*@RequestMapping(value = "/LogOut", method = RequestMethod.POST)
	public @ResponseBody Object userLogOut(@RequestBody UserDetails userLogin, HttpServletRequest servletRequest){
		UserDetails userDetails = new UserDetails();
		
		if(servletRequest.isRequestedSessionIdValid() && servletRequest.getSession().getAttribute("username") != null && userLogin.getSessionID().equalsIgnoreCase(servletRequest.getSession().getId())){
			System.out.println("Invalidating the active Session -> "+ servletRequest.getSession().getId());
			String name = (String)servletRequest.getSession().getAttribute("username");
			name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
			servletRequest.getSession().invalidate();
			userDetails.setValidSession(false);
			userDetails.setMessage(name+" logged out successfully.");
			userDetails.setUserID(11);
			return new ResponseEntity<>(userDetails,HttpStatus.OK);
		}else{
			servletRequest.getSession().invalidate();
			return new ResponseEntity<>(new UserDetails(),HttpStatus.OK);
		}
		
		
	}*/
	
	private Map<Integer,String> getTeamsData() {
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
	
	
	
	/*private List<String> schedulePrep(List<MatchData> matchData){
		List<String> strings = new ArrayList<String>();
		String temp = "";
		for(MatchData match : matchData) {
			temp = match.getMatchNumber()+" "+ match.getScheduledMatch()+" "+ match.getScheduledTime();
			strings.add(temp);
		}
		
		return strings;
		
	}*/
	
	private Map<Integer,String> schedulePrep(List<MatchData> matchData){
		Map<Integer,String> map = new HashMap<Integer,String>();
		
		
		String temp = "";
		for(MatchData match : matchData) {
			temp = match.getMatchNumber()+" "+ match.getScheduledMatch()+" "+ match.getScheduledTime();
			map.put(match.getMatchNumber(), temp);
		}
		
		return map;
		
	}
	
	
}