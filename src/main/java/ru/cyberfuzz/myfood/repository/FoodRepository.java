package ru.cyberfuzz.myfood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cyberfuzz.myfood.model.Food;

import java.util.List;

/**
 * Класс FoodRepository
 *
 * @author Evgeniy Zaytsev
 * @version 1.0
 */
public interface FoodRepository extends JpaRepository<Food, Integer> {

    Food findByName(String name);

}
