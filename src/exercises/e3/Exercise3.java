/**
 * @author      Andrew Pieniezny <andrew.pieniezny@neric.org>
 * @since       Aug 3, 2016
 */
package exercises.e3;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import riconeapi.common.Authenticator;
import riconeapi.common.XPress;
import riconeapi.models.authentication.Endpoint;
import riconeapi.models.xpress.XRosterType;

/*
 * In Exercise 3, convert XRosters by School from Exercise 1 
 * into a JSON object and print the results in the console. This exercise 
 * uses the Jackson 2 ObjectMapper.
 */
public class Exercise3
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


        /*
         * Create an XRosterType list  
         */

            
        /*
         * Create a new ObjectMapper object
         */

            
        /*
         * Create a try/catch statement with JsonProcessingException
         */

		
    	/*
    	 * Inside your try, create a variable of type String.
    	 * Set your variable equal to the object mapper and convert the roster object
    	 * HINT: use the following Jackson methods - writerWithDefaultPrettyPrinter() and writevalueAsString()
    	 */
		
	}

}
