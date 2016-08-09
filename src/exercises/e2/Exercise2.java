/**
 * @author      Andrew Pieniezny <andrew.pieniezny@neric.org>
 * @since       Aug 3, 2016
 */
package exercises.e2;

import riconeapi.common.Authenticator;
import riconeapi.common.XPress;
import riconeapi.models.authentication.Endpoint;
import riconeapi.models.xpress.XMeetingTimeType;
import riconeapi.models.xpress.XRosterType;

/*
 *  Exercise 2 is used to demonstrate pulling a schedule for a student.
 */
public class Exercise2
{
	final static String authUrl = "https://auth.test.ricone.org/login";
	static final String clientId = "DevConf";
	static final String clientSecret = "99f3a355b6e1ddb1fa39b91d5c588bc039";

	static final String providerId = "sandbox";
	
	public static void main(String[] args)
	{
		/*
		 * Create a new Authenticator object and pass authUrl, clientId, and clientSecret
		 */
		

		/*
		 * Create a for-each loop to iterate through your providers and pass in the sandbox provider
		 */

		
		/*
		 * Create a new XPress object and pass the endpoint href
		 */

            
        /* Retrieve a student's schedule
         * HINT: use XRosterType object and getXRostersbyStudent()
         * See: student_refids.txt for list of student refIds
         */

		
    	/*
		 * Display courseRefId and courseTitle within the for-each loop
		 */
            	
		
    	/*
    	 * Display meeting time information per course within the for-each loop
    	 * HINT: use XMeetingTimeType to iterate though getMeetingTimes().getMeetingTime()
    	 */

	}

}
