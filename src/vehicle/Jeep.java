package vehicle;

public class Jeep extends LandVehicle implements Motorized, Commercial
{	
	private int averageFuel;
	private int averageEngineLife;
	public Jeep(String modelName, int maxSpeed, int averageFuel, int engineLife) {
		super(modelName, 5, maxSpeed, 4, "Dirt");
		setAverageFuel(averageFuel);
		setAverageEngineLife(engineLife);
	}

	
	@Override
	public String getLicenseType() {
		return "MINI";
	}
	

	@Override
	public int getAverageFuel() {
		return averageFuel;
	}

	
	public void setAverageFuel(int fuel) {
		this.averageFuel=fuel;
	}

	@Override
	public int getAverageEngineLife() {
		return averageEngineLife;
	}
	
	public void setAverageEngineLife(int life) {
		this.averageEngineLife=life;
		
	}
	
	
	
	/*
	 * @Override public String getType() { return "Jeep"; }
	 */
	
	@Override
	public String toString()
	{
		return "Model is "  + getModelName()+ " , Traveled " + getKilometrage() + "km, Max speed of "+ getMaxSpeed() + "km/h, "
		+ "Max passangers " + getMaxPassengers() + " persons, " + "Average engine life is " + getAverageEngineLife() + " years, "
		+ "Number of wheels is " + getNumOfWheels() + ", Average fuel " + getAverageFuel() + ", Road type is " + getRoadType()+"\n";
	}
@Override
	public boolean equals(Object j)
	{
		boolean ans = false;
		if(j instanceof Jeep)
		{
			ans = !(this.getModelName()==((Jeep) j).getModelName())&&
					this.getAverageEngineLife()== ((Jeep) j).getAverageEngineLife()&&
					this.getAverageFuel()==((Jeep) j).getAverageFuel()
					&& this.getKilometrage() == ((Jeep) j).getKilometrage() && 
					this.getMaxSpeed()==((Jeep) j).getMaxSpeed();
		}
		return ans;
		
		
	}
}
