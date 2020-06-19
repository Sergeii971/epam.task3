package com.verbovskiy.task3.validator;

import com.verbovskiy.task3.entity.Ball;

import java.util.List;

public class BasketValidator {
    public boolean isBallNumberInBasketNotZero(List<Ball> balls) {
        boolean result =true;

        if ((balls == null) || (balls.size() == 0)) {
            result = false;
        }
        return result;
    }
}
