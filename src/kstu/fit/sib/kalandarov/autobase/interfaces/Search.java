package kstu.fit.sib.kalandarov.autobase.interfaces;

import kstu.fit.sib.kalandarov.autobase.entities.Car;
import kstu.fit.sib.kalandarov.autobase.entities.Driver;
import kstu.fit.sib.kalandarov.autobase.entities.Request;

import java.util.List;

public interface Search {
    Car findSuitableCar(Request request, List<Car> availableCars);
    Driver findSuitableDriver(Request request, List<Driver> drivers);
    Car findCarByLicensePlate(String plate, List<Car> cars);
}
