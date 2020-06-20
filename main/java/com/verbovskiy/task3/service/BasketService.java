package com.verbovskiy.task3.service;

import com.verbovskiy.task3.entity.Ball;
import com.verbovskiy.task3.entity.BallColor;
import com.verbovskiy.task3.entity.Basket;
import com.verbovskiy.task3.exception.TaskException;
import com.verbovskiy.task3.validator.BallValidator;
import com.verbovskiy.task3.validator.BasketValidator;
import com.verbovskiy.task3.validator.VolumeValidator;
import com.verbovskiy.task3.validator.WeightValidator;

import java.util.List;

public class BasketService {
    public boolean addBallToBasket(Basket basket, Ball ball) throws TaskException {
        boolean result = true;

        if ((basket == null) || (ball == null) || (ball.getWeightInKilogram() <= 0)
                || (ball.getVolume() <= 0)) {
            throw new TaskException("incorrect data");
        }
        WeightValidator weightValidator = new WeightValidator(basket.getWeightLimitInKilograms());
        BasketValidator basketValidator = new BasketValidator();
        VolumeValidator volumeValidator = new VolumeValidator(basket.getVolumeInCubicMeters());
        double totalBallWeight;
        double totalBallVolume;

        if ((basketValidator.isBallNumberInBasketNotZero(basket.getBalls()))) {
            totalBallWeight = calculateTotalBallWeightInBasket(basket);
            totalBallWeight += ball.getWeightInKilogram();
            totalBallVolume = calculateTotalBallVolumeInBasket(basket);
            totalBallVolume += ball.getVolume();
        } else {
            totalBallWeight = ball.getWeightInKilogram();
            totalBallVolume = ball.getVolume();
        }
        if ((weightValidator.validateTotalWeight(totalBallWeight))
                && (volumeValidator.validateTotalBallVolumeInBasket(totalBallVolume))) {
            basket.add(ball);
        } else {
           result = false;
        }
        return result;
    }

    public boolean removeBallFromBasket(Basket basket, int ballIndex) throws TaskException {
        BasketValidator basketValidator = new BasketValidator();
        boolean result = true;

        if ((basket == null) || (!basketValidator.isBallNumberInBasketNotZero(basket.getBalls()))) {
            throw new TaskException("incorrect data");
        }
        int ballNumber = basket.getBalls().size();
        if ((ballNumber - 1 < ballIndex) || ballIndex < 0) {
            result = false;
        } else {
            basket.remove(ballIndex);
        }
        return result;
    }

    public  double calculateTotalBallVolumeInBasket(Basket basket) throws TaskException {
        if (basket == null) {
            throw new TaskException("incorrect data");
        }
        BasketValidator basketValidator = new BasketValidator();
        VolumeValidator volumeValidator = new VolumeValidator(basket.getVolumeInCubicMeters());
        double totalVolume = 0;
        List<Ball> ballInBasket = basket.getBalls();

        if (!basketValidator.isBallNumberInBasketNotZero(ballInBasket)) {
            return 0;
        }
        if ((volumeValidator.isBallVolumeInBasketPositive(ballInBasket))) {
            for (Ball ball : ballInBasket) {
                if (volumeValidator.validateTotalBallVolumeInBasket(totalVolume)) {
                    totalVolume += ball.getVolume();
                } else {
                    throw new TaskException("incorrect data");
                }
            }
        } else {
            throw new TaskException("incorrect data");
        }
        return totalVolume;
    }

    public double calculateTotalBallWeightInBasket(Basket basket) throws TaskException {
        if (basket == null) {
            throw new TaskException("incorrect data");
        }
        WeightValidator weightValidator = new WeightValidator(basket.getWeightLimitInKilograms());
        BasketValidator basketValidator = new BasketValidator();
        double totalWeight = 0;
        List<Ball> ballInBasket = basket.getBalls();

        if (!basketValidator.isBallNumberInBasketNotZero(ballInBasket)) {
            return 0;
        }
        if ((weightValidator.isBallWeightInBasketPositive(ballInBasket))) {
            for (Ball ball : ballInBasket) {
                if (weightValidator.validateTotalWeight(totalWeight)) {
                    totalWeight += ball.getWeightInKilogram();
                } else {
                    throw new TaskException("incorrect data");
                }
            }
        } else {
            throw new TaskException("incorrect data");
        }
        return totalWeight;
    }

    public int calculateCertainColorBallNumberInBasket(Basket basket, BallColor ballColor) throws TaskException {
        int certainColorBallNumber = 0;
        BasketValidator basketValidator = new BasketValidator();
        BallValidator ballValidator = new BallValidator();

        if ((basket != null) && (basketValidator.isBallNumberInBasketNotZero(basket.getBalls()))
                && (ballValidator.isBallColorNotNull(basket.getBalls()))) {
            List<Ball> ballInBasket = basket.getBalls();

            for (Ball ball : ballInBasket) {
                if (ball.getBallColor().equals(ballColor)) {
                    certainColorBallNumber++;
                }
            }
        } else {
            throw new TaskException("incorrect data");
        }
        return certainColorBallNumber;
    }
}
