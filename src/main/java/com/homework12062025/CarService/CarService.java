package com.homework12062025.CarService;


import com.homework12062025.CarModel.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    public Car create(Car car) {

        return carRepository.save(car);
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car findById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException(id));
    }

    public Car update(Long id, Car car) {

        Car carForUpdate = carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException(id));

        carForUpdate.setBrand(car.getBrand());
        carForUpdate.setModel(car.getModel());
        carForUpdate.setYear(car.getYear());

        return carRepository.save(carForUpdate);
    }

    public Car updateColor(Long id, String color) {
        Car carForUpdate = carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException(id));

        carForUpdate.setColor(color);

        return carRepository.save(carForUpdate);
    }

    public void delete(Long id) {

        Car car = carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException(id));

        carRepository.delete(car);
    }

    public List<Car> findCarWithFilter(String brand, Integer year) {
        return carRepository.findCarWithFilter(brand, year);
    }

    public List<Car> findSortedCar() {
        return carRepository.findAll().stream()
                .sorted((y1, y2) -> Integer.compare(y2.getYear(), y1.getYear()))
                .toList();
    }
}

