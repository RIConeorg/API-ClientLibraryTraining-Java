///**
// * @author      Andrew Pieniezny <andrew.pieniezny@neric.org>
// * @since       Aug 3, 2016
// */
//package solutions.e4;
//
//import java.util.List;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.dataformat.xml.XmlMapper;
//
//import riconeapi.common.Authenticator;
//import riconeapi.common.XPress;
//import riconeapi.models.authentication.Endpoint;
//import riconeapi.models.xpress.XRosterCollectionType;
//import riconeapi.models.xpress.XRosterType;
//
//public class Solution_Exercise4
//{
//	final static String authUrl = "https://auth.test.ricone.org/login";
//	static final String clientId = "DevConf";
//	static final String clientSecret = "99f3a355b6e1ddb1fa39b91d5c588bc039";
//
//	static final String providerId = "sandbox";
//	
//	public static void main(String[] args)
//	{
//		Authenticator auth = new Authenticator(authUrl, clientId, clientSecret); //Pass auth url, username, and password to authenticate to auth server
//
//		for(Endpoint e : auth.getEndpoints(providerId)) //For the provided endpoint
//        {
//            XPress xPress = new XPress(e.getHref()); //Pass endpoint info to data API (token, href)
//            
//            List<XRosterType> roster = xPress.getXRostersByXStudent("669C244E-53DE-40FC-85A5-C5E2A561E809").getData(); //Create XRosters object
//            
//            ObjectMapper mapper = new XmlMapper();           
//            
//			try
//			{
//				String xml = mapper.writeValueAsString(roster);
//				System.out.println(xml);
//			}
//			catch (Exception e1)
//			{
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//        }
//	}
//
//}
