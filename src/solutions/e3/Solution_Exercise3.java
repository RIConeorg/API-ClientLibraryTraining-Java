/**
 * In Exercise 3, convert XRosters by School from Exercise 1 
 * into a JSON object and print results.
 * 
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

public class Solution_Exercise3
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

            List<XRosterType> roster = xPress.getXRostersByXSchool("8367CF40-9F20-4AD0-BCF5-1AB89032AFB9").getData(); //Create XRosters object
            
            ObjectMapper mapper = new ObjectMapper();
            
            try
			{
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
