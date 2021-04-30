package com.dani.monkeyd.app.appingen.controllers;
import com.dani.monkeyd.app.appingen.models.Cars;
import com.dani.monkeyd.app.appingen.services.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/cars")
public class CarsControllers {

    private final CarService carService;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public CarsControllers(CarService carService) {
        this.carService = carService;
    }


    @PostMapping("/add")
    public ResponseEntity<Cars> addUsers(@RequestBody Cars cars){
        Cars cars1=carService.addCar(cars);
        return new ResponseEntity<>(cars1, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Cars>> getAllCars(){
        List<Cars> cars=carService.getAllCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable("id") Long id){
        carService.deleteCars(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
