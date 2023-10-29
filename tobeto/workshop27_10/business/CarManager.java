package org.example.workshop27_10.business;

import org.example.workshop27_10.core.logging.Logger;
import org.example.workshop27_10.dataAccess.CarDao;
import org.example.workshop27_10.entities.Car;

public class CarManager {
    private CarDao carDao;
    private Logger[] loggers;

    public CarManager(CarDao carDao, Logger[] loggers) {
        this.carDao = carDao;
        this.loggers = loggers;
    }
    public void add (Car car) throws Exception {
        if(car.getPrice() < 10000){
            throw new Exception("Fiyat 10000 'den küçük olamaz");
        }
        if(car.getYear() <= 2005) {
            throw new Exception("2006 model arabadan eski araç seçimi yapılamaz");
        }
        if(car.getBrand() == null && car.getModel() == null && car.getYear() == '\0') {
            throw new Exception("Bu alan boş bırakılamaz");
        }

        carDao.add(car);

        for(Logger logger : loggers){
            logger.log(car.getModel());
        }
    }
}
