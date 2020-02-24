package si.um.feri.zs.measurements.rest;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class ApiKeyFilter implements ContainerRequestFilter {

	private static final String API_KEY="16ec1e09-aa26-446c-b6fa-f73fa89fee53";
	
	@Override 
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String apiKey = requestContext.getHeaderString("API-Key");
		if (!API_KEY.equals(apiKey)) {
			Response r = Response.status(Response.Status.UNAUTHORIZED).build();
			requestContext.abortWith(r);
		}
	}

}