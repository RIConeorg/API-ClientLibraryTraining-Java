/**
 * @author      Andrew Pieniezny <andrew.pieniezny@neric.org>
 * @since       Aug 3, 2016
 */
package solutions.e1;

import riconeapi.common.Authenticator;
import riconeapi.common.XPress;
import riconeapi.models.authentication.Endpoint;
import riconeapi.models.xpress.XPersonReferenceType;
import riconeapi.models.xpress.XRosterType;

/*
 * Excercise 1 is used to demonstrate pulling rosters by a school
 */
public class Solution_Exercise1
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
            XPress xPress = new XPress(e.getHref()); //Pass endpoint info to data API (token, href)
            
            /* 
             * Retrieve all rosters by a particular school
             * HINT: use XRosterType object and getXRostersbySchool()
             * See: school_refids.txt for list of school refIds
             */
	        for(XRosterType r : xPress.getXRostersByXSchool("8367CF40-9F20-4AD0-BCF5-1AB89032AFB9").getData()) // Rosters by School refId
	        {
	        	/*
	    		 * Display courseRefId and courseTitle within the for-each loop
	    		 */
        		System.out.println("###courseRefId: " + r.getCourseRefId());
	        	System.out.println("courseTitle: " + r.getCourseTitle());
	        	
	        	/*
	        	 * Display all students per course within the for-each loop
	        	 * HINT: use XPersonReferenceType to iterate though getStudents().getStudentReference()
	        	 */
	        	for(XPersonReferenceType p : r.getStudents().getStudentReference()) //Students for each course
                {
                    System.out.println("refId: " + p.getRefId());
                    System.out.println("localId: " + p.getLocalId());
                    System.out.println("givenName: " + p.getGivenName());
                    System.out.println("familyName: " + p.getFamilyName());
                }	
            }
        }
	}
}
