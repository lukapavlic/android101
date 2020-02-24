package si.um.feri.weather.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import si.um.feri.weather.vao.Weather;

@Path("/weather")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WeatherResource {
	
	static Map<String, List<Weather>> weatherItems;
	
	static Map<String, List<Weather>> getWeather() {
		if (weatherItems==null) {
			weatherItems=Collections.synchronizedMap(new HashMap<String, List<Weather>>());
			weatherItems.put("MARIBOR", 
				new ArrayList<Weather>());
			weatherItems.get("MARIBOR").add(
				new Weather(
						"Maribor",46.5547d,15.6459d,false,true,new GregorianCalendar().getTimeInMillis(),
						7.50,16.50,0.8,0.6,-5,2,1024	
				));
			
		}
		return weatherItems;
	}
	
	@GET
	@Path("/forecast/{location}")
	public Response getForecast(@PathParam("location") String location) {
		//TODO filter forecasts
		return Response.ok(getWeather().get(location.toUpperCase())).build();
	}
	
}
