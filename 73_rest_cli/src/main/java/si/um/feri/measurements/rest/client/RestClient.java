package si.um.feri.measurements.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestClient {
	
	private static String API_KEY = "16ec1e09-aa26-446c-b6fa-f73fa89fee53"; 
	
	private static String URL_PROFILE = 		"http://127.0.0.1:8080/measurements/rest/profile";
	private static String URL_MEASUREMENTS = 	"http://127.0.0.1:8080/measurements/rest/measurements";
	
	private static String JSON_PROFILE =
			"	{"+
			"		\"name\": \"No\","+
			"		\"surname\": \"Name\","+
			"		\"email\": \"dummy@user.si\","+
			"		\"heigth\": 1.89"+
			"	}";
	
	private static String JSON_MEAS =
			"	{"+
			"		\"id\": 1,"+
			"		\"measurementType\": \"BODY_WEIGTH\","+
			"		\"timeStamp\": 1549877500611,"+
			"		\"unit\": \"kg\","+
			"		\"userEmail\": \"dummy@user.si\","+
			"		\"value\": 95.5,"+
			"		\"label\": \"Telesna teza\","+
			"		\"comment\": \"Jutranja meritev\","+
			"		\"geo\": \"15.43, 43.432\""+
			"	}";
	

	public RestClient() {
        client = ClientBuilder.newClient();
        targetProfile = client.target(URL_PROFILE);
        targetMeasurements = client.target(URL_MEASUREMENTS);
	}
	
	WebTarget targetProfile=null;
	WebTarget targetMeasurements=null;
	Client client=null;
	
	public String getProfile(String user) {
        Response response = targetProfile.
        		request().
        		header("API-Key", API_KEY).
        		header("user", user).
        		get();
        String value = response.readEntity(String.class);
        int status = response.getStatus();
        response.close();  

        System.out.println("getProfile - " +user+ " - "+status);
        return value;
	}

	public String putProfile(String user, String json) {
        Response response = targetProfile.
        		request().
        		header("API-Key", API_KEY).
        		header("user", user).
        		put(Entity.entity(json, MediaType.APPLICATION_JSON));
        String value = response.readEntity(String.class);
        int status = response.getStatus();
        response.close();

        System.out.println("putProfile - " +user+ " - "+status);
        return value;
	}
	
	public String getMeasurements(String user) {
        Response response = targetMeasurements.
        		request().
        		header("API-Key", API_KEY).
        		header("user", user).
        		get();
        String value = response.readEntity(String.class);
        int status = response.getStatus();
        response.close();  

        System.out.println("getMeasurements - " +user+ " - "+status);
        return value;
	}
	
	public String getMeasurement(String user, String id) {
		WebTarget targetMeasurementsId = client.target(URL_MEASUREMENTS+"/"+id);
        Response response = targetMeasurementsId.
        		request().
        		header("API-Key", API_KEY).
        		header("user", user).
        		get();
        String value = response.readEntity(String.class);
        int status = response.getStatus();
        response.close();  

        System.out.println("getMeasurement - "+id+" - " +user+ " - "+status);
        return value;
	}
	
	public String deleteMeasurement(String user, String id) {
		WebTarget targetMeasurementsId = client.target(URL_MEASUREMENTS+"/"+id);
        Response response = targetMeasurementsId.
        		request().
        		header("API-Key", API_KEY).
        		header("user", user).
        		delete();
        String value = response.readEntity(String.class);
        int status = response.getStatus();
        response.close();  

        System.out.println("deleteMeasurement - "+id+" - " +user+ " - "+status);
        return value;
	}
	
	public String postMeasurement(String user, String json) {
        Response response = targetMeasurements.
        		request().
        		header("API-Key", API_KEY).
        		header("user", user).
        		post(Entity.entity(json, MediaType.APPLICATION_JSON));
        String value = response.readEntity(String.class);
        int status = response.getStatus();
        response.close();

        System.out.println("postMeasurement - " +user+ " - "+status);
        return value;
	}
	
	public static void main(String[] args) {

		RestClient rc=new RestClient();
		
		System.out.println(rc.getProfile("user@gmail.com"));
		System.out.println(rc.getProfile("dummy@user.si"));
		System.out.println(rc.putProfile("dummy@user.si", JSON_PROFILE));
		System.out.println(rc.getProfile("dummy@user.si"));
		
		System.out.println(rc.getMeasurements("dummy@user.si"));
		System.out.println(rc.postMeasurement("dummy@user.si",JSON_MEAS));
		System.out.println(rc.getMeasurements("dummy@user.si"));
		System.out.println(rc.getMeasurement("dummy@user.si","1582574926229"));
		System.out.println(rc.deleteMeasurement("dummy@user.si","1582574926229"));
		
	}
	
}
