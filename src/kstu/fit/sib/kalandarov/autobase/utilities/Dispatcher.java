package kstu.fit.sib.kalandarov.autobase.utilities;

import kstu.fit.sib.kalandarov.autobase.entities.Car;
import kstu.fit.sib.kalandarov.autobase.entities.Driver;
import kstu.fit.sib.kalandarov.autobase.entities.Request;
import kstu.fit.sib.kalandarov.autobase.entities.Trip;
import kstu.fit.sib.kalandarov.autobase.interfaces.Search;

import java.util.List;

public final class Dispatcher implements Search {

    public void dispatchRequests(List<Request> requests, List<Driver> drivers, List<Trip> completedTrips) {
        for (Request request : requests) {
            Driver assignedDriver = findSuitableDriver(request, drivers);
            if (assignedDriver != null) {
                List<Car> availableCars = assignedDriver.getAssignedCars();
                Car assignedCar = findSuitableCar(request, availableCars);

                if (assignedCar != null) {
                    Trip trip = new Trip(request, assignedDriver, assignedCar);
                    trip.completeTrip();
                    completedTrips.add(trip);
                    assignedDriver.addTrip(trip);
                }
            }
        }
    }

    @Override
    public Car findSuitableCar(Request request, List<Car> availableCars) {
        for (Car car : availableCars) {
            if (car.checkCarSpecifications(request)) {
                return car;
            }
        }
        return null;
    }

    @Override
    public Driver findSuitableDriver(Request request, List<Driver> drivers) { // Поиск водителя
        for (Driver driver : drivers) {
            List<Car> availableCars = driver.getAssignedCars();
            for (Car car : availableCars) {
                if (car.isFunctional() && car.checkCarSpecifications(request)
                        && ((car.isPassenger() && request.isPassenger() && car.getSeats() >= request.getSeats()) ||
                        (!car.isPassenger() && !request.isPassenger() && car.getLiftingCapacity() >= request.getLiftingCapacity()))) {
                    return driver;
                }
            }
        }
        return null;
    }

    @Override
    public Car findCarByLicensePlate(String plate, List<Car> cars) {
        for(Car car : cars)
           if(car.getLicensePlate().equals(plate))
               return car;
        return null;
    }
}
