package vehicle;

public class ElectricBicycle extends LandVehicle implements Motorized{
    private int averageEngineLife;
    private int averageFuel;
    public ElectricBicycle(String modelName, int maxPassengers, int maxSpeed, String roadType,int averageEngineLife) {
        super(modelName, maxPassengers, maxSpeed, 2, roadType);
        setAverageEngineLife(averageEngineLife);
        setAverageFuel(20);

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
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (other == this) {
            return true;
        }

        if (!(other instanceof ElectricBicycle)) {
            return false;
        }

        ElectricBicycle otherBicycle = (ElectricBicycle) other;

        return getModelName().equals(otherBicycle.getModelName()) &&
                getMaxPassengers() == otherBicycle.getMaxPassengers() &&
                getMaxSpeed() == otherBicycle.getMaxSpeed() &&
                getNumOfWheels() == otherBicycle.getNumOfWheels() &&
                getRoadType().equals(otherBicycle.getRoadType()) &&
                getAverageFuel() == otherBicycle.getAverageFuel()&&
                getAverageEngineLife() == otherBicycle.getAverageEngineLife();

    }

    @Override
    public String toString() {
        return "Electric Bicycle model: " + getModelName() +
                ", max passengers: " + getMaxPassengers() +
                ", max speed: " + getMaxSpeed() +
                ", number of wheels: " + getNumOfWheels() +
                ", road type: " + getRoadType() +
                ", average fuel: " + getAverageFuel() +
                ", average engine life: " + getAverageEngineLife();
    }
}
