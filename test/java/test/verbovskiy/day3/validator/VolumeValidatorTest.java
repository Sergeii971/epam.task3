package test.verbovskiy.day3.validator;

import com.verbovskiy.task3.entity.Ball;
import com.verbovskiy.task3.entity.BallColor;
import com.verbovskiy.task3.validator.VolumeValidator;
import junit.framework.TestCase;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class VolumeValidatorTest extends TestCase {
    @Test
    public void isBallVolumeInBasketPositiveValidTest() {
        List<Ball> balls = new ArrayList<Ball>();
        VolumeValidator volumeValidator = new VolumeValidator(20);

        balls.add(new Ball(2,2, BallColor.BLUE));
        balls.add(new Ball(2.2,2.3, BallColor.GREEN));
        balls.add(new Ball(1,1, BallColor.ORANGE));
        boolean actual = volumeValidator.isBallVolumeInBasketPositive(balls);
        assertTrue(actual);
    }

    @Test
    public void isBallVolumeInBasketPositiveInvalidTest() {
        List<Ball> balls = new ArrayList<Ball>();
        VolumeValidator volumeValidator = new VolumeValidator(20);

        balls.add(new Ball(2,-2, BallColor.BLUE));
        balls.add(new Ball(2.2,-3, BallColor.GREEN));
        balls.add(new Ball(1,0, BallColor.ORANGE));
        boolean actual = volumeValidator.isBallVolumeInBasketPositive(balls);
        assertFalse(actual);
    }

    @Test
    public void validateTotalBallVolumeInBasketValidTest() {
        VolumeValidator volumeValidator = new VolumeValidator(20);
        boolean actual = volumeValidator.validateTotalBallVolumeInBasket(10);

        assertTrue(actual);
    }

    @Test
    public void validateTotalBallVolumeInBasketInValidTest() {
        VolumeValidator volumeValidator = new VolumeValidator(20);
        boolean actual = volumeValidator.validateTotalBallVolumeInBasket(30);

        assertFalse(actual);
    }
}