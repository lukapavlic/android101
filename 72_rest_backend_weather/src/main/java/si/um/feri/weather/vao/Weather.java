package si.um.feri.weather.vao;

public class Weather {
	
	String locationName;
	double lat, lon;
	boolean forecast, actual;
	double timeStamp; //date
	
	double sunrise, sunset; //local timestamp
	
	double clouds, humidity; //0-1
	double tempFrom, tempTo;
	int pressure;
	
	public Weather() {
	}
	
	public Weather(String locationName, double lat, double lon, boolean forecast, boolean actual, double timeStamp,
			double sunrise, double sunset, double clouds, double humidity, double tempFrom, double tempTo,int pressure) {
		super();
		this.locationName = locationName;
		this.lat = lat;
		this.lon = lon;
		this.forecast = forecast;
		this.actual = actual;
		this.timeStamp = timeStamp;
		this.sunrise = sunrise;
		this.sunset = sunset;
		this.clouds = clouds;
		this.humidity = humidity;
		this.tempFrom = tempFrom;
		this.tempTo = tempTo;
		this.pressure = pressure;
	}



	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public boolean isForecast() {
		return forecast;
	}
	public void setForecast(boolean forecast) {
		this.forecast = forecast;
	}
	public boolean isActual() {
		return actual;
	}
	public void setActual(boolean actual) {
		this.actual = actual;
	}
	public double getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(double timeStamp) {
		this.timeStamp = timeStamp;
	}
	public double getSunrise() {
		return sunrise;
	}
	public void setSunrise(double sunrise) {
		this.sunrise = sunrise;
	}
	public double getSunset() {
		return sunset;
	}
	public void setSunset(double sunset) {
		this.sunset = sunset;
	}
	public double getClouds() {
		return clouds;
	}
	public void setClouds(double clouds) {
		this.clouds = clouds;
	}
	public double getHumidity() {
		return humidity;
	}
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
	public double getTempFrom() {
		return tempFrom;
	}
	public void setTempFrom(double tempFrom) {
		this.tempFrom = tempFrom;
	}
	public double getTempTo() {
		return tempTo;
	}
	public void setTempTo(double tempTo) {
		this.tempTo = tempTo;
	}
	public int getPressure() {
		return pressure;
	}
	public void setPressure(int pressure) {
		this.pressure = pressure;
	}
	
}
