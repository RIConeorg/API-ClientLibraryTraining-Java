/**
 * Exercise 2 is used to demonstrate pulling a schedule for a student
 * 
 * @author      Andrew Pieniezny <andrew.pieniezny@neric.org>
 * @since       Aug 3, 2016
 */
package solutions.e2;

import riconeapi.common.Authenticator;
import riconeapi.common.XPress;
import riconeapi.models.authentication.Endpoint;
import riconeapi.models.xpress.XMeetingTimeType;
import riconeapi.models.xpress.XRosterType;

public class Solution_Exercise2
{
	final static String authUrl = "https://auth.test.ricone.org/login";
	static final String clientId = "DevConf";
	static final String clientSecret = "99f3a355b6e1ddb1fa39b91d5c588bc039";

	static final String providerId = "sandbox";
	
	public static void main(String[] args)
	{
		Authenticator auth = new Authenticator(authUrl, clientId, clientSecret); //Pass auth url, username, and password to authenticate to auth server

		for(Endpoint e : auth.getEndpoints(providerId)) //For the provided endpoint
        {
            XPress xPress = new XPress(e.getHref()); //Pass endpoint info to data API (token, href)
            
            for(XRosterType r : xPress.getXRostersByXStudent("669C244E-53DE-40FC-85A5-C5E2A561E809").getData()) // Rosters by Student refId
            {
            	System.out.println("####courseRefId: " + r.getCourseRefId());
	        	System.out.println("courseTitle: " + r.getCourseTitle());
	        	
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
