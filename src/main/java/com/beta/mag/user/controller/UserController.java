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

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.heroku.sdk.jdbc.DatabaseUrl;

;

/**
 * The Class UserPersistence. controller is to create new user. returns the json response to the
 * REST client.
 */
@RestController
@RequestMapping(value = "/api")
public class UserController {

  

    @RequestMapping(value = "/v10/user/{userId}/{passCode}", method = RequestMethod.GET)
    @ResponseBody
    public String storeProfile(@PathVariable final String userId, @PathVariable final String passCode) throws URISyntaxException {
        try {
            Connection connection = null;
            connection = DatabaseUrl.extract().getConnection();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS User (userId varchar,passcode varchar,createDate timestamp,)");
            String insertquery = "INSERT INTO User VALUES (" + userId + "," + passCode + ",now())";
            System.out.println(insertquery);
            stmt.executeUpdate(insertquery);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "User Inserted Successfully";
    }

    @RequestMapping(value = "/v10/firstUser", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<String> getAllUsers() {

        Connection connection = null;
        try {
            connection = DatabaseUrl.extract().getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT userId FROM User");
            ArrayList<String> output = new ArrayList<String>();
            while (rs.next()) {
                output.add("Read from DB: " + rs.getString("userId"));
            }
            return output;
        } catch (Exception e) {
            return null;
        } finally {
            if (connection != null)
                try {
                    connection.close();
                } catch (SQLException e) {
                }
        }
    }

}
