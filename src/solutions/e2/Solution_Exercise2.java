/**
 * @author      Andrew Pieniezny <andrew.pieniezny@neric.org>
 * @since       Aug 3, 2016
 */
package solutions.e2;

import riconeapi.common.Authenticator;
import riconeapi.common.XPress;
import riconeapi.models.authentication.Endpoint;
import riconeapi.models.xpress.XMeetingTimeType;
import riconeapi.models.xpress.XRosterType;

/*
 *  Exercise 2 is used to demonstrate pulling a schedule for a student.
 */
public class Solution_Exercise2
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
		Authenticator auth = new Authenticator(authUrl, clientId, clientSecret);
		
		/*
		 * Create a for-each loop to iterate through your providers and pass in the sandbox provider
		 */
		for(Endpoint e : auth.getEndpoints(providerId))
        {
			/*
			 * Create a new XPress object and pass the endpoint href
			 */

            XPress xPress = new XPress(e.getHref());
            
            /* Retrieve a student's schedule
             * HINT: use XRosterType object and getXRostersbyStudent()
             * See: student_refids.txt for list of student refIds
             */
            for(XRosterType r : xPress.getXRostersByXStudent("669C244E-53DE-40FC-85A5-C5E2A561E809").getData()) // Rosters by Student refId
            {
            	/*
        		 * Display courseRefId and courseTitle within the for-each loop
        		 */
            	System.out.println("####courseRefId: " + r.getCourseRefId());
	        	System.out.println("courseTitle: " + r.getCourseTitle());
	        	
	        	/*
	        	 * Display meeting time information per course within the for-each loop
	        	 * HINT: use XMeetingTimeType to iterate though getMeetingTimes().getMeetingTime()
	        	 */
	        	for(XMeetingTimeType m : r.getMeetingTimes().getMeetingTime())
	        	{
	        		System.out.println("bellScheduleDay: " + m.getClassMeetingDays().getBellScheduleDay());
	        		System.out.println("timeTablePeriod: " + m.getTimeTablePeriod());
	        		System.out.println("roomNumber: " + m.getRoomNumber());
	        		System.out.println("classBeginningTime: " + m.getClassBeginningTime());
	        		System.out.println("classEndingTime: " + m.getClassEndingTime());
	        	}
            }
        }
		
	}

}
