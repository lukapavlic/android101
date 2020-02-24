package si.um.feri.zs.measurements.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import si.um.feri.zs.measurements.ejb.Measurements;
import si.um.feri.zs.measurements.vao.Measurement;

@Path("/measurements")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MeasurementsResource {

	@EJB
	Measurements measEjb;
	
	@GET
	@Path("/")
	public Response getAllMeasurements(@HeaderParam("user") String user)  throws Exception {
		return Response.ok(measEjb.getAllMeasurements(user)).build();
	}

	@GET
	@Path("/{id}")
	public Response getMeasurement(@PathParam("id") long measurementId, @HeaderParam("user") String user)  throws Exception {
		Measurement m=measEjb.getMeasurement(measurementId);
		if (m!=null)
			if (!user.equals(m.getUserEmail()))
				return Response.status(Status.FORBIDDEN).build();
		return Response.ok(m).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteMeasurement(@PathParam("id") long measurementId, @HeaderParam("user") String user)  throws Exception {
		Measurement m=measEjb.getMeasurement(measurementId);
		if (m!=null)
			if (!user.equals(m.getUserEmail()))
				return Response.status(Status.FORBIDDEN).build();
		measEjb.deleteMeasurement(measurementId);
		return Response.ok().build();
	}

	@POST
	@Path("/")
	public Response postMeasurement(Measurement m, @HeaderParam("user") String user)  throws Exception {
		m.setUserEmail(user);
		if (m.getTimeStamp()==0) m.setTimeStamp(System.currentTimeMillis());
		return Response.ok(measEjb.persistMeasurement(m)).build();
	}
	
}
