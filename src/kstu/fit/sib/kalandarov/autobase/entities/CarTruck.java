package kstu.fit.sib.kalandarov.autobase.entities;

import java.io.Serial;

public class CarTruck extends Car {
    @Serial
    private static final long serialVersionUID = 34957349579324L;
    private double liftingCapacity;
    public CarTruck() {
        super();
    }
    public CarTruck(String model, String licensePlate, boolean isFunctional, double liftingCapacity) {
        super(model, licensePlate, isFunctional);
        this.liftingCapacity = liftingCapacity;
    }

    @Override
    public double getLiftingCapacity() {
        return liftingCapacity;
    }

    @Override
    public Boolean isPassenger() {
        return false;
    }

    @Override
    public String toString() {
        return "Авто{" +
            "марка=" + getModel() +
            ", номер=" + getLicensePlate() +
            ", работоспособность=" + isFunctional() +
            ", тип = Грузовой(Грузоподъёмность: " + getLiftingCapacity() + ")" +
            '}';
    }

    @Override
    public int getSeats() {
        return -1;
    }
}
