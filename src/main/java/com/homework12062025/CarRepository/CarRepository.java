package com.homework12062025.CarRepository;

import com.homework12062025.CarModel.Car;

import java.util.List;

public class CarRepository {
    @Query(value = "SELECT * FROM car WHERE " +
            "(:brand IS NULL OR brand = :brand) AND " +
            "(:year IS NULL OR year = :year)",
            nativeQuery = true)
    List<Car> findCarWithFilter(String brand, Integer year);
}
