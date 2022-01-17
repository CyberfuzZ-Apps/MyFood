package ru.cyberfuzz.myfood.DTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Класс FoodDTO
 *
 * @author Evgeniy Zaytsev
 * @version 1.0
 */
@Component
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class FoodDTO {

    private int id;
    private String name;
    private int price;
    private int amount;
    private int sum;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FoodDTO foodDTO = (FoodDTO) o;
        return id == foodDTO.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
