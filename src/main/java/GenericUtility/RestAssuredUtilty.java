package GenericUtility;
import io.restassured.response.Response;
/**
 * This class contans generic specfic to rest assured
 * @author navachetan
 *
 */
public class RestAssuredUtilty 
{
	/**
	 * This method will return the json data for json path specified
	 * @param resp
	 * @param jsonPath
	 * @return String
	 */
	public String getJSONData(Response response,String jsonPath)
	{
		
		String jsonDAta = response.jsonPath().get(jsonPath);
		return jsonDAta;
	}
}
