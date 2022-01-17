package ru.cyberfuzz.myfood.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Класс FoodRemains
 *
 * @author Evgeniy Zaytsev
 * @version 1.0
 */
@Entity
@Table(name = "food_remains")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class FoodRemains {

    @Id
    @Column(name = "food_id")
    private int foodId;
    private int remains;

    public static FoodRemains of(int foodId, int remains) {
        FoodRemains foodRemains = new FoodRemains();
        foodRemains.foodId = foodId;
        foodRemains.remains = remains;
        return foodRemains;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FoodRemains that = (FoodRemains) o;
        return foodId == that.foodId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(foodId);
    }
}
