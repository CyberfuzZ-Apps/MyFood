package ru.cyberfuzz.myfood.controller;

import org.springframework.web.bind.annotation.*;
import ru.cyberfuzz.myfood.DTO.FoodDTO;
import ru.cyberfuzz.myfood.model.Food;
import ru.cyberfuzz.myfood.service.MyFoodService;

import java.util.List;


/**
 * Класс MyFoodController
 *
 * @author Evgeniy Zaytsev
 * @version 1.0
 */
@RestController
@RequestMapping("/api/food")
public class MyFoodController {

    private final MyFoodService myFoodService;

    public MyFoodController(MyFoodService myFoodService) {
        this.myFoodService = myFoodService;
    }

    @GetMapping("/")
    public List<Food> findAll() {
        return myFoodService.findAll();
    }

    @GetMapping("/find")
    public FoodDTO findFood(@RequestParam String foodName,
                            @RequestParam Integer amount) {
        return myFoodService.findByName(foodName, amount);
    }
}
