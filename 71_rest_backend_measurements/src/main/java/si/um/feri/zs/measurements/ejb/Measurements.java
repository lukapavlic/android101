package si.um.feri.zs.measurements.ejb;

import java.util.List;
import javax.ejb.Local;
import si.um.feri.zs.measurements.vao.Measurement;

@Local
public interface Measurements {

	Measurement persistMeasurement(Measurement m);
	
	void deleteMeasurement(long id);
	
	List<Measurement> getAllMeasurements(String user);
	
	Measurement getMeasurement(long id);
	
}
