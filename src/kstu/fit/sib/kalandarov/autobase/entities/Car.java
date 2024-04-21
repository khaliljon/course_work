package kstu.fit.sib.kalandarov.autobase.entities;

import java.io.Serializable;
import java.util.Objects;

public abstract class Car implements Comparable<Car>, Cloneable, Serializable {
    private String model;
    private String licensePlate;
    private transient Boolean isFunctional;

    public Car() {
    }
    public Car(String model, String licensePlate, Boolean isFunctional) {
        this.model = model; // Марка авто
        this.licensePlate = licensePlate; // Номер авто
        this.isFunctional = isFunctional; // Исправность
    }

    public Boolean isFunctional() {
        return isFunctional;
    }

    public abstract int getSeats();
    public abstract double getLiftingCapacity();

    public abstract Boolean isPassenger();

    public String getModel() {
        return model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void updateFunctionalStatus(boolean newStatus) {
        this.isFunctional = newStatus;
    }

    public boolean checkCarSpecifications(Request request) {
        boolean modelMatch = this.getModel() == request.getDesiredCarModel();
        if(request.getSeats()!=0) {
            boolean seatsEnough = this.getSeats() >= request.getSeats();
            return modelMatch && seatsEnough;
        }
        else {
            boolean capacityEnough = this.getLiftingCapacity() >= request.getLiftingCapacity();
            return modelMatch && capacityEnough;
        }
    }

    /////////////
    // OVERRIDES
    /////////////

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new CarPassenger(model, licensePlate, isFunctional, getSeats());
    }

    @Override
    public int compareTo(Car otherCar) {
        return model.compareTo(otherCar.getModel());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(getModel(), ((Car) obj).getModel()) &&
               Objects.equals(getLicensePlate(), ((Car) obj).getLicensePlate()) &&
               Objects.equals(isFunctional(), ((Car) obj).isFunctional());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getModel(), getLicensePlate(), isFunctional());
    }
}
