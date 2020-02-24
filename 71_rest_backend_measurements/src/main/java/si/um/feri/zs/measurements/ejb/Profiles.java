package si.um.feri.zs.measurements.ejb;

import javax.ejb.Local;
import si.um.feri.zs.measurements.vao.Profile;

@Local
public interface Profiles {

	Profile getProfile(String user);
	
	void persistProfile(Profile p);
	
}
