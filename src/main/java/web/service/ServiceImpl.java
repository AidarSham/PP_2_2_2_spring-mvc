package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ServiceImpl implements Service {
    public static List<Car> listCar;

    @Override
    public List<Car> buildCar() {

        listCar = new ArrayList<>();

        listCar.add(new Car(1, "Ford", "White"));
        listCar.add(new Car(2, "Hammer", "Green"));
        listCar.add(new Car(3, "Lincoln", "Blue"));
        listCar.add(new Car(4, "Chevrolet", "Yellow"));
        listCar.add(new Car(5, "GM", "Black"));

        return listCar;
    }

    public List<Car> selectCar(List<Car> catalog, int count) {
        buildCar();
        if (count == 0 || count > 5) return catalog;
        return catalog.stream().limit(count).collect(Collectors.toList());
    }
}


