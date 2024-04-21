package kstu.fit.sib.kalandarov.autobase.utilities;

import java.util.Comparator;

import kstu.fit.sib.kalandarov.autobase.entities.Car;
import kstu.fit.sib.kalandarov.autobase.entities.CarPassenger;
import kstu.fit.sib.kalandarov.autobase.entities.CarTruck;

public class CarComparator implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        if (car1.getClass() == CarTruck.class && car2.getClass() == CarTruck.class) {
            return Double.compare(((CarTruck) car2).getLiftingCapacity(), ((CarTruck) car1).getLiftingCapacity());
        } else if (car1.getClass() == CarPassenger.class && car2.getClass() == CarPassenger.class) {
            return Integer.compare(((CarPassenger) car2).getSeats(), ((CarPassenger) car1).getSeats());
        } else if (car1.getClass() == CarTruck.class && car2.getClass() == CarPassenger.class) {
            return -1;
        } else if (car1.getClass() == CarPassenger.class && car2.getClass() == CarTruck.class) {
            return 1;
        } else {
            return 0;
        }
    }
}
