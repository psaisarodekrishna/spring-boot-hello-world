/**-------------------------------------+----------------------------------------------------------
 *
 * Description: Entry point for SpringBoot application.
 * 
 * History:
 * 
 * Change History:
 * Revision     Date        Dev         Comments
 * ------------------------------------------------------------------------------------------------
 *  1.0          18.12.2014  krishp15     -B-32518 Get Product Line Data
 * 
 * 
 * 
 * Copyright  (c) 2009 - 2014. EMC Corporation. All Rights Reserved.
 * This software contains the   intellectual property of EMC Corporation or is licensed to
 * EMC Corporation from third parties.  Use of this software and the intellectual property
 * contained therein is expressly limited to the terms and conditions of the License
 * Agreement under  which it is provided by or on behalf of EMC.
 * 
 **************************************************************************************************/

package com.beta.mag.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * The Class Application.
 */
@Configuration
@ComponentScan(basePackages = { "com.beta" })
@EnableAutoConfiguration
// @EntityScan(basePackages = { "com.beta.mag.user" })
public class Application {

	

	/**
	 * Starts Spring boot application.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Entering: main");
		System.out.println("Starting SpringBoot Portal application...");
		System.out.println("Exiting: main");
	}
}
