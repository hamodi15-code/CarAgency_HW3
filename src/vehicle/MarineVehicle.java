package vehicle;

public abstract class MarineVehicle extends Vehicle 
{
	protected boolean sailWithWind;
	protected String countryFlag;
	
	public MarineVehicle(String modelName, int maxPassengers, int maxSpeed, boolean sailWithWind, String countryFlag) {
		super(modelName, maxPassengers, maxSpeed);
		this.sailWithWind=sailWithWind;
		this.countryFlag=countryFlag;
	}
	
	public boolean getSailWithWind() {
		return sailWithWind;
	}
	
	public void setSailWithWind(boolean sailWithWind)
	{
		this.sailWithWind=sailWithWind;
	}
	
	public String getCountryFlag()
	{
		return countryFlag;
	}
	
	public void setCountryFlag(String countryFlag)
	{
		this.countryFlag=countryFlag;
	}

	
}
