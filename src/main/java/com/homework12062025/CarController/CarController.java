package com.homework12062025.CarController;


import com.homework12062025.CarModel.Car;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarController {
    private final CarService carService;

    @PostMapping
    public ResponseEntity<Car> create(@RequestBody Car car) {
        return ResponseEntity.ok(carService.create(car));
    }

    @GetMapping
    public ResponseEntity<List<Car>> findAll() {
        return ResponseEntity.ok(carService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Car> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(carService.findById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Car> update(@PathVariable("id") Long id, @RequestBody Car car) {
        return ResponseEntity.ok(carService.update(id, car));
    }

    @PatchMapping("{id}")
    public ResponseEntity<Car> updateColor(@PathVariable("id") Long id, @RequestParam String color) {
        return ResponseEntity.ok(carService.updateColor(id, color));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        carService.delete(id);
        return ResponseEntity.ok("Машина с id : " + id + " удалена");
    }


    @GetMapping(path = "filter")
    public ResponseEntity<List<Car>> findCarWithFilter(
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) Integer year
    ) {
        return ResponseEntity.ok(carService.findCarWithFilter(brand, year));
    }

    @GetMapping(path = "sort")
    public ResponseEntity<List<Car>> findSortedCar() {
        return ResponseEntity.ok(carService.findSortedCar());
    }
}
