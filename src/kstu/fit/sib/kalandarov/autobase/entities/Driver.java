package kstu.fit.sib.kalandarov.autobase.entities;

import kstu.fit.sib.kalandarov.autobase.entities.exceptions.RemoveCarException;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Driver implements Serializable {
    @Serial
    private static final long serialVersionUID = 23576287345L;
    private String name;
    private List<Car> assignedCars;
    private List<Trip> tripsHistory;

    public Driver(String name) {
        this.name = name;
        this.assignedCars = new ArrayList<>();
        this.tripsHistory = new ArrayList<>();
    }

    public void addAssignedCar(Car car) {
        assignedCars.add(car);
    }

    public void addAssignedCars(List <Car> cars) {
            assignedCars.addAll(cars);
    }

    public void removeAssignedCar(Car car) {
        try {
            if(!assignedCars.contains(car)) {
                throw new RemoveCarException(car + " не привязана");
            }
            assignedCars.remove(car);
        }
        catch (RemoveCarException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    public List<Car> getAssignedCars() {
        return assignedCars;
    }
    public void addTrip (Trip trip) {
        tripsHistory.add(trip);
    }
    public List<Trip> getTripsHistory() {
        return tripsHistory;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString () {
        String str = "Водитель{" +
                "имя=" + name +
                ", авто:";
        for (Car car : assignedCars)
            str += "\n\t" + car;
        for (Trip trip : tripsHistory)
            str += "\n\t" + trip;
        str += "\n}";
        return str;
    }
}
