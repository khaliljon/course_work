package kstu.fit.sib.kalandarov.autobase.entities;

import java.io.Serial;
import java.io.Serializable;

public class Request implements Serializable {
    @Serial
    private static final long serialVersionUID = 4574552803L;
    private String desiredCarModel;
    private String description;
    private int seats;
    private double liftingCapacity;
    private boolean isPassenger;
    
    public Request(String desiredCarModel, String description, int seats) {
        this.desiredCarModel = desiredCarModel;
        this.description = description;
        this.seats = seats;
        this.isPassenger = true;
    }

    public Request(String desiredCarModel, String description, double liftingCapacity) {
        this.desiredCarModel = desiredCarModel;
        this.description = description;
        this.liftingCapacity = liftingCapacity;
        this.isPassenger = false;
    }

    public boolean isPassenger() {
        return isPassenger;
    }
    
    public int getSeats() {
        return seats;
    }

    public double getLiftingCapacity() {
        return (double) liftingCapacity;
    }
    public String getDesiredCarModel() {
        return desiredCarModel;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "{" +
            "\n\t\t\tОжидаемая марка=" + desiredCarModel +
            ",\n\t\t\tОписание=" + description +
            ",\n\t\t\tТип=" + (seats != 0 ? "Легковой (Мест: " + seats + ")" : "Грузовой (Грузоподъёмность: " + liftingCapacity + ")") +
            "\n\t\t}";
    }
}
