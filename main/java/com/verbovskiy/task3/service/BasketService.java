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
    public Basket addBallToBasket(Basket basket, Ball ball) throws TaskException {
        if ((basket == null) || (ball == null)) {
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
        if ((ball.getWeightInKilogram() > 0) && (weightValidator.validateTotalWeight(totalBallWeight))
        && (ball.getVolume() > 0) && (volumeValidator.validateTotalBallVolumeInBasket(totalBallVolume))) {
            basket.getBalls().add(ball);
        } else {
            throw new TaskException("incorrect input");
        }
        return basket;
    }

    public Basket removeBallFromBasket(Basket basket, int ballIndex) throws TaskException {
        BasketValidator basketValidator = new BasketValidator();

        if ((basket == null) || (!basketValidator.isBallNumberInBasketNotZero(basket.getBalls()))) {
            throw new TaskException("incorrect input");
        }
        int ballNumber = basket.getBalls().size();

        if ((ballNumber < ballIndex) || ballIndex < 0) {
            throw new TaskException("incorrect index");
        }
        basket.getBalls().remove(ballIndex);
        return basket;
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
                    throw new TaskException("incorrect input");
                }
            }
        } else {
            throw new TaskException("incorrect input");
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
                    throw new TaskException("incorrect input");
                }
            }
        } else {
            throw new TaskException("incorrect input");
        }
        return totalWeight;
    }

    public int calculateCertainColorBallNumberInBasket(Basket basket, BallColor ballColor) throws TaskException {
        int count = 0;
        BasketValidator basketValidator = new BasketValidator();
        BallValidator ballValidator = new BallValidator();

        if ((basket != null) && (basketValidator.isBallNumberInBasketNotZero(basket.getBalls()))
                && (ballValidator.isBallColorNotNull(basket.getBalls()))) {
            List<Ball> ballInBasket = basket.getBalls();

            for (Ball ball : ballInBasket) {
                if (ball.getBallColor().equals(ballColor)) {
                    count++;
                }
            }
        } else {
            throw new TaskException("incorrect input");
        }
        return count;
    }
}
