package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.ServiceImpl;

import static web.service.ServiceImpl.listCar;

@Controller
public class CarController {
    private final ServiceImpl service;

    public CarController(ServiceImpl service) {
        this.service = service;
    }

    @GetMapping(value = "/cars")
    public String printCar(@RequestParam(value = "count", defaultValue = "5") int count, Model model) {
        model.addAttribute("cars", service.selectCar(listCar, count));
        return "cars";
    }
}
