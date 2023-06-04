package vehicle;



public class Amphibious extends Vehicle implements  Motorized{
    protected LandVehicle landVehicle;
    protected MarineVehicle marineVehicle;
    protected int averageFuel;
    protected int averageEngineLife;

    public Amphibious(String modelName, int maxPassengers, int maxSpeed, int numOfWheels, boolean sailWithWind, String countryFlag,int averageFuel, int averageEngineLife) {
        super(modelName, maxPassengers, maxSpeed);
        setAverageFuel(averageFuel);
        setAverageEngineLife(averageEngineLife);
        landVehicle = new LandVehicle(modelName, maxPassengers, maxSpeed, numOfWheels, "Paved") {};
        marineVehicle=new MarineVehicle(modelName, maxPassengers, maxSpeed, sailWithWind, countryFlag) {};
    }

    public String getModelName() {
        return landVehicle.getModelName();
    }

    public int getMaxPassengers() {
        return landVehicle.getMaxPassengers();
    }

    public int getMaxSpeed() {
        return landVehicle.getMaxSpeed();
    }

    public double getKilometrage() {
        return landVehicle.getKilometrage() ;
    }

    public void move(double distance) {
        landVehicle.move(distance);
    }

    public int getNumOfWheels() {
        return landVehicle.getNumOfWheels();
    }

    public void setNumOfWheels(int numOfWheels) {
        landVehicle.setNumOfWheels(numOfWheels);
    }

    public String getRoadType() {
        return landVehicle.getRoadType();
    }

    public void setRoadType(String roadType) {
        landVehicle.setRoadType(roadType);
    }

    public boolean getSailWithWind() {
        return marineVehicle.getSailWithWind();
    }

    public void setSailWithWind(boolean sailWithWind) {
        marineVehicle.setSailWithWind(sailWithWind);
    }

    public String getCountryFlag() {
        return marineVehicle.getCountryFlag();
    }

    public void setCountryFlag(String countryFlag) {
        marineVehicle.setCountryFlag(countryFlag);
    }

    @Override
    public int getAverageFuel() {
        return averageFuel;
    }

    @Override
    public void setAverageFuel(int fuel) {
        this.averageFuel=fuel;
    }

    @Override
    public int getAverageEngineLife() {
        return averageEngineLife;
    }

    @Override
    public void setAverageEngineLife(int life) {
        this.averageEngineLife=life;

    }
    @Override
    public String toString() {
        String landVehicleDetails =
                "Model Name: " + landVehicle.getModelName() + "\n" +
                        " Max Passengers: " + landVehicle.getMaxPassengers() + "\n" +
                        " Max Speed: " + landVehicle.getMaxSpeed() + "\n" +
                        " Number of Wheels: " + landVehicle.getNumOfWheels() + "\n" +
                        " Road Type: " + landVehicle.getRoadType() + "\n" +
                        " Kilometrage: " + landVehicle.getKilometrage() + "\n";

        String marineVehicleDetails =
                " Sail With Wind: " + marineVehicle.getSailWithWind() + "\n" +
                        " Country Flag: " + marineVehicle.getCountryFlag() + "\n";

        String motorizedDetails =
                " Average Fuel: " + getAverageFuel() + "\n" +
                        " Average Engine Life: " + getAverageEngineLife() + "\n";

        return " Amphibious Vehicle Details:\n" +
                landVehicleDetails + "\n" +
                marineVehicleDetails + "\n" +
                motorizedDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Amphibious)) {
            return false;
        }
        Amphibious amphibious = (Amphibious) o;

        return amphibious.getModelName().equals(getModelName()) &&
                amphibious.getMaxPassengers() == getMaxPassengers() &&
                amphibious.getMaxSpeed() == getMaxSpeed() &&
                amphibious.getNumOfWheels() == getNumOfWheels() &&
                amphibious.getRoadType().equals(getRoadType()) &&
                amphibious.getSailWithWind() == getSailWithWind() &&
                amphibious.getCountryFlag().equals(getCountryFlag()) &&
                amphibious.getAverageFuel() == getAverageFuel() &&
                amphibious.getAverageEngineLife() == getAverageEngineLife();
    }



}