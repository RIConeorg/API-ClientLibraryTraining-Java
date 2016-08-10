/**
 * @author      Andrew Pieniezny <andrew.pieniezny@neric.org>
 * @since       Aug 3, 2016
 */
package exercises.e1;

import riconeapi.common.Authenticator;
import riconeapi.common.XPress;
import riconeapi.models.authentication.Endpoint;
import riconeapi.models.xpress.XPersonReferenceType;
import riconeapi.models.xpress.XRosterType;

/*
 * Excercise 1 is used to demonstrate pulling rosters by a school
 */
public class Exercise1
{
	final static String authUrl = "https://auth.test.ricone.org/login";
	static final String clientId = "DevConf";
	static final String clientSecret = "test-password";

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
    
		
        /* 
         * Retrieve all rosters by a particular school
         * HINT: use XRosterType object and getXRostersbySchool()
         * See: school_refids.txt for list of school refIds
         */
      
		
		/*
		 * Display courseRefId and courseTitle within the for-each loop
		 */
	       
		
    	/*
    	 * Display all students per course within the for-each loop
    	 * HINT: use XPersonReferenceType to iterate though getStudents().getStudentReference()
    	 */
	}
}
