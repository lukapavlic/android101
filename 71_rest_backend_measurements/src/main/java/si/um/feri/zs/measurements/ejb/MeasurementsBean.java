package si.um.feri.zs.measurements.ejb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import si.um.feri.zs.measurements.vao.Measurement;

@Stateless
public class MeasurementsBean implements Measurements {
	
	Logger log=LoggerFactory.getLogger(MeasurementsBean.class);
	
//	@PersistenceContext
//	EntityManager em;
	private static Map<String, List<Measurement>> dataByUser=Collections.synchronizedMap(new HashMap<String, List<Measurement>>());
	private static Map<String, Measurement> data=Collections.synchronizedMap(new HashMap<String, Measurement>());
	
	@Override
	public Measurement persistMeasurement(Measurement m) {
		log.info("persistMeasurement: "+m);
		//if (getMeasurement(m.getId())==null) em.persist(m);
		//else em.merge(m);
		m.setId(System.currentTimeMillis());
		data.put(m.getId()+"",m);
		if (dataByUser.get(m.getUserEmail())==null)
			dataByUser.put(m.getUserEmail(),new ArrayList<Measurement>());
		dataByUser.get(m.getUserEmail()).add(m);
		return m;
	}
	
	@Override
	public Measurement getMeasurement(long id) {
		log.info("getMeasurement: "+id);
		//return em.find(Measurement.class, id);
		return data.get(id+"");
	}
	
	@Override
	public List<Measurement> getAllMeasurements(String user) {
		log.info("getAllMeasurements: "+user);
		//Query q=null;
		//q=em.createQuery("select m from Measurement m where m.userEmail = :user order by m.timeStamp");
		//q.setParameter("user", user);
		//return q.getResultList();
		return dataByUser.get(user);
	}
	
	@Override
	public void deleteMeasurement(long id) {
		log.info("deleteMeasurement: "+id);
		Measurement m=getMeasurement(id);
		//if (m!=null) em.remove(m);
		if (m!=null) {
			data.remove(m.getId()+"");
			List<Measurement> listM=dataByUser.get(m.getUserEmail());
			for (Iterator<Measurement> iter = listM.iterator(); iter.hasNext();) {
				if (iter.next().getId()==id) {
					iter.remove();
					break;
				}
			}
		}
	}

}
