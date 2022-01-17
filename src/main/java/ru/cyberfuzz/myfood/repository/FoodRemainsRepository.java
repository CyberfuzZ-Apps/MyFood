package ru.cyberfuzz.myfood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cyberfuzz.myfood.model.FoodRemains;

/**
 * Класс FoodRemainsRepository
 *
 * @author Evgeniy Zaytsev
 * @version 1.0
 */
public interface FoodRemainsRepository extends JpaRepository<FoodRemains, Integer> {
}
