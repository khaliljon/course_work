package kstu.fit.sib.kalandarov.autobase.utilities;

import kstu.fit.sib.kalandarov.autobase.entities.Car;
import kstu.fit.sib.kalandarov.autobase.entities.Driver;
import kstu.fit.sib.kalandarov.autobase.entities.Request;
import kstu.fit.sib.kalandarov.autobase.entities.Trip;

import java.util.List;

public final class Reporter {

    public static void tripReport(List<Trip> completedTrips) {
        System.out.println("Сформирован отчет по выполненным поездкам:");
        for (Trip trip : completedTrips) {
            System.out.println("Водитель: " + trip.getDriver().getName());
            System.out.println("Автомобиль: " + trip.getCar().getModel());
            if(trip.getCar().isPassenger()) {
            System.out.println("Ожидаемое количество мест: " + trip.getRequest().getSeats());
            System.out.println("Реальное количество мест: " + trip.getCar().getSeats());
            }
            if(!trip.getCar().isPassenger()) {
            System.out.println("Ожидаемая грузоподъёмность: " + trip.getRequest().getLiftingCapacity());
            System.out.println("Реальная грузоподъёмность: " + trip.getCar().getLiftingCapacity());
            }
            System.out.println("Заявка: " + trip.getRequest().getDesiredCarModel());
            System.out.println("Время начала поездки: " + trip.getStartTime());
            System.out.println("Время завершения поездки: " + trip.getEndTime());
            System.out.println("Статус: " + (trip.isSuccessful() ? "Успешно" : "Неуспешно"));
            System.out.println("------------------------------------");

        }

    }
    public static void print(Driver driver)
    {
        System.out.println(driver);
    }

    public static void print(Request request)
    {
        System.out.println(request);
    }

    public static void print(List<?> list) {
        for (Object element : list)
            System.out.println(element);
    }
    public static void print(Car car) {
        System.out.println(car);
    }
}
