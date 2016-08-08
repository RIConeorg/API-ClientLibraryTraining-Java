/**
 * Excercise 1 is used to demonstrate pulling rosters by a school
 * 
 * @author      Andrew Pieniezny <andrew.pieniezny@neric.org>
 * @since       Aug 3, 2016
 */
package solutions.e1;

import riconeapi.common.Authenticator;
import riconeapi.common.XPress;
import riconeapi.models.authentication.Endpoint;
import riconeapi.models.xpress.XPersonReferenceType;
import riconeapi.models.xpress.XRosterType;

public class Solution_Exercise1
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
            
	        for(XRosterType r : xPress.getXRostersByXSchool("8367CF40-9F20-4AD0-BCF5-1AB89032AFB9").getData()) // Rosters by School refId
	        {
	        	if(r.getStudents().getStudentReference() != null && !r.getStudents().getStudentReference().isEmpty()) // Retrieve rosters with students
	        	{
	        		System.out.println("###courseRefId: " + r.getCourseRefId());
		        	System.out.println("courseTitle: " + r.getCourseTitle());
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
}
