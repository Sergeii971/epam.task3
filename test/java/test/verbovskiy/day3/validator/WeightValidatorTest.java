package test.verbovskiy.day3.validator;

import com.verbovskiy.task3.entity.Ball;
import com.verbovskiy.task3.entity.BallColor;
import com.verbovskiy.task3.validator.WeightValidator;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class WeightValidatorTest {
    @Test
    public void isBallWeightInBasketPositiveValidTest() {
        WeightValidator weightValidator = new WeightValidator(20);
        List<Ball> balls = new ArrayList<Ball>();

        balls.add(new Ball(2,2, BallColor.BLUE));
        balls.add(new Ball(2.2,2.3, BallColor.GREEN));
        balls.add(new Ball(1,1, BallColor.ORANGE));
        boolean actual = weightValidator.isBallWeightInBasketPositive(balls);

        assertTrue(actual);
    }

    @Test
    public void isBallWeightInBasketPositiveInvalidTest() {
        WeightValidator weightValidator = new WeightValidator(20);
        List<Ball> balls = new ArrayList<Ball>();

        balls.add(new Ball(-2,2, BallColor.BLUE));
        balls.add(new Ball(2.2,2.3, BallColor.GREEN));
        balls.add(new Ball(1,1, BallColor.ORANGE));
        boolean actual = weightValidator.isBallWeightInBasketPositive(balls);

        assertFalse(actual);
    }

    @Test
    public void validateTotalWeightValidTest() {
        WeightValidator weightValidator = new WeightValidator(20);
        boolean actual = weightValidator.validateTotalWeight(15);
        assertTrue(actual);
    }

    @Test
    public void validateTotalWeightInvalidTest() {
        WeightValidator weightValidator = new WeightValidator(20);
        boolean actual = weightValidator.validateTotalWeight(25);
        assertFalse(actual);
    }
}