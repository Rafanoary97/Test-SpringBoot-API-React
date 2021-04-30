package com.dani.monkeyd.app.appingen.services;

import com.dani.monkeyd.app.appingen.models.Cars;
import com.dani.monkeyd.app.appingen.models.Users;
import com.dani.monkeyd.app.appingen.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarsRepository carsRepository;

    @Autowired
    public CarService(CarsRepository carsRepository){this.carsRepository=carsRepository;}
    public List<Cars> getAllCars(){
        return carsRepository.findAll();
    }

    public Cars addCar(Cars cars){
        return carsRepository.save(cars);

    }

    public void deleteCars(Long id){
        carsRepository.deleteById(id);
    }

}
