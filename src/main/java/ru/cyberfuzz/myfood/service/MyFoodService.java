package ru.cyberfuzz.myfood.service;

import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import ru.cyberfuzz.myfood.DTO.FoodDTO;
import ru.cyberfuzz.myfood.model.Food;
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
    private final ApplicationContext applicationContext;

    public MyFoodService(FoodRepository foodRepository,
                         ApplicationContext applicationContext) {
        this.foodRepository = foodRepository;
        this.applicationContext = applicationContext;
    }

    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    @Transactional
    public FoodDTO findByName(String name, int amount) {
        Food food = foodRepository.findByName(name);
        if (food == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Продукт не найден!");
        }
        if (food.getAmount() < amount) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Количество продуктов в базе меньше чем в запросе!");
        }
        food.setAmount(food.getAmount() - amount);
        FoodDTO foodDTO = applicationContext.getBean(FoodDTO.class);
        int price = food.getPrice();
        foodDTO.setId(food.getId());
        foodDTO.setName(food.getName());
        foodDTO.setPrice(price);
        foodDTO.setAmount(amount);
        foodDTO.setSum(amount * price);
        return foodDTO;
    }
}
