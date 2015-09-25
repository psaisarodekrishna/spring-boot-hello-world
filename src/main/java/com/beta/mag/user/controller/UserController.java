/**-------------------------------------+----------------------------------------------------------
 *
 * Description: Service interface for the User Service.
 * 
 * History:
 * ----
 * Change History:
 * Revision     Date        Dev         Comments
 * ------------------------------------------------------------------------------------------------
 * 1.0          3.14.2015  pavan Sai    create new user
 * 
 **************************************************************************************************/

package com.beta.mag.user.controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.heroku.sdk.jdbc.DatabaseUrl;


;

/**
 * The Class UserPersistence. controller is to create new user. returns the json
 * response to the REST client.
 */
@RestController
@RequestMapping(value = "/api")
public class UserController {



	@RequestMapping(value = "/v10/user/{userId}/{passCode}", method = RequestMethod.GET)
	@ResponseBody
	public String getUserProfile(@PathVariable final String userId,
			@PathVariable final String passCode)  {
		System.out.println("helloe");
		return "Hello User...Have a great Day";
	}
	
	
	
	@RequestMapping(value = "/v10/currentTime", method = RequestMethod.GET)
    @ResponseBody
    public String getAllUsers()  {

	    Connection connection = null;
	    Map<String, Object> attributes = new HashMap<>();
	    try {
	      connection = DatabaseUrl.extract().getConnection();
         System.out.println(DatabaseUrl.extract().jdbcUrl());
	      Statement stmt = connection.createStatement();
	      stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
	      stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
	      ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

	      ArrayList<String> output = new ArrayList<String>();
	      while (rs.next()) {
	        output.add( "Read from DB: " + rs.getTimestamp("tick"));
	      }
	      return "Time now as per the Heroku Server Zone :"+output.get(0);
	    } catch (Exception e) {
	        System.out.println("zill null"+ e.getLocalizedMessage());
	      return null;
	    } finally {
	      if (connection != null) try{connection.close();} catch(SQLException e){}
	    }
	  }


	}
	
	
	
	


