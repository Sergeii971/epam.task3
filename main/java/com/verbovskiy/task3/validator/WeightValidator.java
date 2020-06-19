package com.verbovskiy.task3.validator;

import com.verbovskiy.task3.entity.Ball;
import java.util.List;

public class WeightValidator {
    private final double basketWeightLimit;

    public WeightValidator(double basketWeightLimit) {
        this.basketWeightLimit = basketWeightLimit;
    }

    public boolean isBallWeightInBasketPositive(List<Ball> balls) {
        boolean result = true;

        if ((balls == null) || (balls.size() == 0)) {
            result = false;
        } else {
            for (Ball ball : balls) {
                if ((ball.getWeightInKilogram() <= 0)) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public boolean validateTotalWeight(double sum) {
        boolean result = true;

        if ((sum < 0) || (sum > basketWeightLimit)) {
            result = false;
        }
        return result;
    }
}
