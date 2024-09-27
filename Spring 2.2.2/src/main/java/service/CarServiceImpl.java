package service;

import model.Car;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CarServiceImpl extends Car {
    private List<Car> cars = Arrays.asList(
            new Car("Jiga", "Grey", 1975),
            new Car("Kia", "Red", 2015),
            new Car("Haval", "Pink", 2024),
            new Car("BMW", "Yellow", 2023),
            new Car("Pobeda", "Blue", 1990)
    );

    public List<Car> getCars(int count) {
        if (count > cars.size()) {
            return cars;
        }
        return cars.subList(0, count);
    }
}

