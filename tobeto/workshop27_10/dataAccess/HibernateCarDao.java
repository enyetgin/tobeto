package org.example.workshop27_10.dataAccess;

import org.example.workshop27_10.entities.Car;

public class HibernateCarDao implements CarDao {


    @Override
    public void add(Car car) {
        System.out.println(car.getBrand() +' ' + car.getModel() + " hibernate ile eklendi.");
    }
}
