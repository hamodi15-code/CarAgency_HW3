package vehicle;

public abstract class LandVehicle extends Vehicle 
{
	protected int numOfWheels;
	protected String roadType;

	public LandVehicle(String modelName, int maxPassengers, int maxSpeed,int numOfWheels, String roadType) {
		super(modelName, maxPassengers, maxSpeed);
		this.numOfWheels=numOfWheels;
		this.roadType=roadType;
	}
	
	public int getNumOfWheels()
	{
		return numOfWheels;
	}
	
	public void setNumOfWheels(int numOfWheels) 
	{
		this.numOfWheels=numOfWheels;
	}
	
	public String getRoadType()
	{
		return roadType;
	}
	
	public void setRoadType(String roadType) 
	{
		this.roadType=roadType;
	}
}
