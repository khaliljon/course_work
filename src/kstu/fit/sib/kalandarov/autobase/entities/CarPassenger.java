package kstu.fit.sib.kalandarov.autobase.entities;

import java.io.Serial;

public class CarPassenger extends Car {
    @Serial
    private static final long serialVersionUID = 92432455788L;
    private int seats;

    public CarPassenger() {
        super();
    }
    public CarPassenger(String model, String licensePlate, Boolean isFunctional, int seats) {
        super(model, licensePlate, isFunctional);
        this.seats = seats;
    }

    @Override
    public int getSeats() {
        return seats;
    }

    @Override
    public Boolean isPassenger() {
        return true;
    }

    @Override
    public String toString() {
        return "Авто{" +
            "марка=" + getModel() +
            ", номер=" + getLicensePlate() +
            ", работоспособность=" + isFunctional() +
            ", тип=Легковой(Мест: " + getSeats() + ")" +
            '}';
    }

    @Override
    public double getLiftingCapacity() {
        return -1;
    }
}