package vehicle;

public abstract class AirVehicle extends Vehicle 
{
	protected String usePurpose;
	
	public AirVehicle(String modelName, int maxPassengers, int maxSpeed, String usePurpose) {
		super(modelName, maxPassengers, maxSpeed);
		this.usePurpose=usePurpose;
	}
	
	public String getUsePurpose()
	{
		return usePurpose;
	}
	
	public void setUsePurpose(String usePurpose)
	{
		this.usePurpose=usePurpose;
	}
	
}
