/**
 * @author      Andrew Pieniezny <andrew.pieniezny@neric.org>
 * @since       Aug 3, 2016
 */
package solutions.e3;

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
public class Solution_Exercise3
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
		Authenticator auth = new Authenticator(authUrl, clientId, clientSecret); //Pass auth url, username, and password to authenticate to auth server

		/*
		 * Create a for-each loop to iterate through your providers and pass in the sandbox provider
		 */
		for(Endpoint e : auth.getEndpoints(providerId)) //For the provided endpoint
        {
			/*
			 * Create a new XPress object and pass the endpoint href
			 */
            XPress xPress = new XPress(e.getHref()); //Pass endpoint info to data API (token, href)

            /*
             * Create an XRosterType list  
             */
            List<XRosterType> roster = xPress.getXRostersByXSchool("8367CF40-9F20-4AD0-BCF5-1AB89032AFB9").getData(); //Create XRosters object
            
            /*
             * Create a new ObjectMapper object
             */
            ObjectMapper mapper = new ObjectMapper();
            
            /*
             * Create a try/catch statement with JsonProcessingException
             */
            try
			{
            	/*
            	 * Inside your try, create a variable of type String.
            	 * Set your variable equal to the object mapper and convert the roster object
            	 * HINT: use the following Jackson methods - writerWithDefaultPrettyPrinter() and writevalueAsString()
            	 */
				String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(roster); //Convert XRoster object to JSON
				System.out.println(json);
			}
			catch (JsonProcessingException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }

	}

}
