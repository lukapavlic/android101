package si.um.feri.weather.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestClient {
	
	private static String URL = "http://__:8080/weather/rest/users/";
	private static String JSON = "{\"bodyHeigth\":1.83,\"bodyWeigth\":94.0,\"favouritePlaces\":[\"Maribor\",\"Slovenj Gradec\"],\"name\":\"Dummy\",\"surname\":\"User\",\"userId\":\"dummy.user@email.com\"}";
	
	public static void get(String url) {
		System.out.println(url);
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        
        Response response = target.request().get();
        String value = response.readEntity(String.class);
        int status = response.getStatus();
        response.close();  

        System.out.println(status);
        System.out.println(value);
	}

	public static void put(String url, String json) {
		System.out.println(url);
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        
        Response response = target.request().put(Entity.entity(json, MediaType.APPLICATION_JSON));
        String value = response.readEntity(String.class);
        int status = response.getStatus();
        response.close();

        System.out.println(status);
        System.out.println(value);
	}
	
	public static void post(String url, String json) {
		System.out.println(url);
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        
        Response response = target.request().post(Entity.entity(json, MediaType.APPLICATION_JSON));
        String value = response.readEntity(String.class);
        int status = response.getStatus();
        response.close();  

        System.out.println(status);
        System.out.println(value);
	}

	
	public static void main(String[] args) {

		get(URL);
		put(URL,JSON);
		get(URL);
		
	}
	
}
