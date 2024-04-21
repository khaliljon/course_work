package kstu.fit.sib.kalandarov.autobase.entities;

import java.io.Serial;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Trip implements Serializable {
    @Serial
    private static final long serialVersionUID = 57461499855L;
    private Request request;
    private Driver driver;
    private Car car;
    private Date startTime;
    private Date endTime;
    private boolean successful;

    public Trip() {
        this.request = null;
        this.driver = null;
        this.car = null;
        this.startTime = new Date();
        this.successful = false;
    }
    public Trip(Request request, Driver driver, Car car) {
        this.request = request;
        this.driver = driver;
        this.car = car;
        this.startTime = new Date();
        this.successful = false;  // Инициализация успешности поездки
    }

    public void completeTrip() {
        this.endTime = new Date();
        this.successful = true;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public Request getRequest() {
        return request;
    }
    public Driver getDriver() {
        return driver;
    }
    public Car getCar() {
        return car;
    }

    public Date getStartTime() {
        return startTime;
    }
    public Date getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            return "Поездка{" +
                    "\n\t\tЗаявка" + request +
                    ",\n\t\tВодитель=" + driver.getName() +
                    ",\n\t\tАвто=" + car +
                    ",\n\t\tДата отправления= " + dateFormat.format(startTime) +
                    ",\n\t\tДата прибытия= " + dateFormat.format(endTime) +
                    ",\n\t\tСтатус=" + successful +
                    "\n\t}";
    }
}
