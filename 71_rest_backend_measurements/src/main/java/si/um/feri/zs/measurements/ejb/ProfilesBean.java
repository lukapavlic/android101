package si.um.feri.zs.measurements.ejb;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import si.um.feri.zs.measurements.vao.Profile;

@Stateless
public class ProfilesBean implements Profiles {
	
	Logger log=LoggerFactory.getLogger(ProfilesBean.class);
	
//	@PersistenceContext
//	EntityManager em;
	private static Map<String, Profile> data=Collections.synchronizedMap(new HashMap<String, Profile>());
	
	@Override
	public Profile getProfile(String user) {
		log.info("getProfile: "+user);
		//return em.find(Profile.class, user);
		return data.get(user);
	}

	@Override
	public void persistProfile(Profile p) {
		log.info("persistProfile: "+p);
		//if (getProfile(p.getEmail())==null) em.persist(p);
		//else em.merge(p);
		if (p!=null) data.put(p.getEmail(), p);
	}
	
}
