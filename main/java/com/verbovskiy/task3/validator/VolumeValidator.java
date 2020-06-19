package com.verbovskiy.task3.validator;

import com.verbovskiy.task3.entity.Ball;

import java.util.List;

public class VolumeValidator {
    public final double basketVolume;

    public VolumeValidator(double basketVolume) {
        this.basketVolume = basketVolume;
    }

    public boolean isBallVolumeInBasketPositive(List<Ball> balls) {
        boolean result = true;

        if ((balls == null) || (balls.size() == 0)) {
            result = false;
        } else {
        for (Ball ball : balls) {
            if ((ball.getVolume() <= 0)) {
                result = false;
                break;
            }
        }
        }
        return result;
    }

    public boolean validateTotalBallVolumeInBasket(double totalVolume) {
        return ((totalVolume >= 0) && (totalVolume <= basketVolume));
    }
}
