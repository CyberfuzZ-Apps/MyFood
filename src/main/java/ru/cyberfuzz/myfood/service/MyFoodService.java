package ru.cyberfuzz.myfood.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.cyberfuzz.myfood.model.Food;
import ru.cyberfuzz.myfood.model.FoodRemains;
import ru.cyberfuzz.myfood.repository.FoodRemainsRepository;
import ru.cyberfuzz.myfood.repository.FoodRepository;

import java.util.List;

/**
 * Класс MyFoodService
 *
 * @author Evgeniy Zaytsev
 * @version 1.0
 */
@Service
public class MyFoodService {

    private final FoodRepository foodRepository;
    private final FoodRemainsRepository foodRemainsRepository;

    public MyFoodService(FoodRepository foodRepository,
                         FoodRemainsRepository foodRemainsRepository) {
        this.foodRepository = foodRepository;
        this.foodRemainsRepository = foodRemainsRepository;
    }

    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    public Food findByName(String name) {
        Food food = foodRepository.findByName(name);
        if (food == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Продукт не найден!");
        }
        return food;
    }

    /* for Admins Only  */
    public Food save(Food food, Integer remains) {
        Food savedFood = foodRepository.save(food);
        FoodRemains foodRemains = FoodRemains.of(savedFood.getId(), remains);
        foodRemainsRepository.save(foodRemains);
        return savedFood;
    }
}
