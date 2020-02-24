package si.um.feri.zs.measurements.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import si.um.feri.zs.measurements.ejb.Profiles;
import si.um.feri.zs.measurements.vao.Profile;

@Path("/profile")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {

	@EJB
	Profiles profEjb;
	
	@GET
	@Path("/")
	public Response getProfile(@HeaderParam("user") String user)  throws Exception {
		return Response.ok(profEjb.getProfile(user)).build();
	}

	@PUT
	@Path("/")
	public Response postProfile(Profile p, @HeaderParam("user") String user)  throws Exception {
		p.setEmail(user);
		profEjb.persistProfile(p);
		return Response.ok(profEjb.getProfile(user)).build();
	}
	
}
