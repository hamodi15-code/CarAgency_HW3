package vehicle;

public class ToyGlider extends AirVehicle implements NonMotorized 
{
	private char energyScore;
	private String powerSourceInformatin;
	public ToyGlider() {
		super("Toy", 0, 10, "Civilian");
		setPowerSourceInformation("Manual");
		setEnergyScore('A');
	}
	
	public void setPowerSourceInformation(String powerSourceInformatin)
	{
		this.powerSourceInformatin=powerSourceInformatin;
	}
	public void setEnergyScore(char energyScore)
	{
		this.energyScore=energyScore;
	}
	public String getPowerSourceInformation()
	{
		return powerSourceInformatin;
	}
	
	public char getEnergyScore()
	{
		return energyScore;
	}
	
	@Override
	public String toString()
	{
		return "Model is "  + getModelName()+ " , Traveled " + getKilometrage() 
		+ "km, Max speed of "+ getMaxSpeed() + "km/h, "
		+ "Max passangers " + getMaxPassengers() + "persons, " 
		+ "Use purpose " + getUsePurpose() 
		+ "Power source informatin " + getPowerSourceInformation()
		+ "Energy score is " + getEnergyScore()
				 +"\n";
	}
	
	


	@Override
	public boolean equals(Object t)
	{
		if (this==t) return true;
		boolean ans = false;
		if(t instanceof ToyGlider)
		{
			ans =  this.getKilometrage() == ((ToyGlider) t).getKilometrage();
		}
		return ans;
			
	}
}
