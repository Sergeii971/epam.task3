package com.verbovskiy.task3.validator;

import com.verbovskiy.task3.entity.Ball;
import java.util.List;

public class BallValidator {

    public boolean isBallColorNotNull(List<Ball> balls) {
        boolean result =true;

        if ((balls == null) || (balls.size() == 0)) {
            result = false;
        } else {
            for (Ball ball : balls) {
                if (ball.getBallColor() == null) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}

