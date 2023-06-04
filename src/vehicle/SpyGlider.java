package vehicle;

public class SpyGlider extends AirVehicle implements NonMotorized 
{
	private char energyScore;
	private String powerSourceInformatin;
	
	public SpyGlider(String powerSourceInformatin ) {
		super("Privileged", 1, 50, "Army");
		setPowerSourceInformation(powerSourceInformatin);
		setEnergyScore('C');
	
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
		+ "Max passangers " + getMaxPassengers() + " persons, "
		+ "Use purpose " + getUsePurpose() 
		+ " Power source information " + getPowerSourceInformation()
		+ ",Energy score is " + getEnergyScore()
				 +"\n";
	}
	
	


	@Override
	public boolean equals(Object s)
	{
		if (this==s) return true;
		boolean ans = false;
		if(s instanceof SpyGlider)
		{
			ans = this.powerSourceInformatin == getPowerSourceInformation()
					&& this.getKilometrage() == ((SpyGlider) s).getKilometrage();
		}
		return ans;
			
	}
}
