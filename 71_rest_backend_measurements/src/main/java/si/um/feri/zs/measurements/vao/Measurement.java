package si.um.feri.zs.measurements.vao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Measurement {

	public static final String TYPE_BODY_WEIGTH="BODY_WEIGTH";
	
	private long id;
	
	private String userEmail;
	
	private long timeStamp;
	
	private String measurementType;
	
	private double value;
	
	private String label;
	
	private String unit;
	
	private String geo;
	
	private String comment;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMeasurementType() {
		return measurementType;
	}

	public void setMeasurementType(String measurementType) {
		this.measurementType = measurementType;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getGeo() {
		return geo;
	}

	public void setGeo(String geo) {
		this.geo = geo;
	}

	@Override
	public String toString() {
		return "Measurement [id=" + id + ", userEmail=" + userEmail + ", timeStamp=" + timeStamp + ", measurementType="
				+ measurementType + ", value=" + value + ", label=" + label + ", unit=" + unit + ", geo=" + geo
				+ ", comment=" + comment + "] - "+super.toString();
	}
	
	
	
}
