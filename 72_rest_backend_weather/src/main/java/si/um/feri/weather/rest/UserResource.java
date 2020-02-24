package si.um.feri.weather.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import si.um.feri.weather.vao.User;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

	static Map<String, User> users;
	
	static synchronized Map<String, User> getUsers() {
		if (users==null) {
			users=Collections.synchronizedMap(new HashMap<String, User>());
			users.put(
					"DUMMY.USER@EMAIL.COM", 
					new User(
							"dummy.user@email.com",new ArrayList<String>(),"Dummy","User",1.85d,95d
					));
			users.put(
					"DUMMY.USER2@EMAIL.COM", 
					new User(
							"dummy.user2@email.com",new ArrayList<String>(),"Dummy","User2",1.85d,95d
					));
		}		
		return users;
	}
	
	@GET
	@Path("/{userId}")
	public Response getUser(@PathParam("userId") String userId) {
		return Response.ok(getUsers().get(userId.toUpperCase())).build();
	}
	
	@GET
	@Path("/")
	public Response getAllUsers(@PathParam("userId") String userId) {
		return Response.ok(getUsers().values()).build();
	}
	
	@PUT
	@Path("/")
	public Response postUser(User u) {
		if (u==null) return Response.status(400).build();
		getUsers().put(u.getUserId().toUpperCase(), u);
		return Response.ok().build();
	}
	
}
