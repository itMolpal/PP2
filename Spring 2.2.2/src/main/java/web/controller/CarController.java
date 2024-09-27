package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CarServiceImpl;

@Controller
public class CarController {

CarServiceImpl carService = new CarServiceImpl();
    @GetMapping("/cars")
    public String getCars(@RequestParam(value = "count", required = false) Integer count, Model model) {
        if (count == null) {
            count = carService.getCars(Integer.MAX_VALUE).size();
        }
        model.addAttribute("cars", carService.getCars(count));
        return "cars";
    }
}