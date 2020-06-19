package test.verbovskiy.day3.validator;

import com.verbovskiy.task3.entity.Ball;
import com.verbovskiy.task3.entity.BallColor;
import com.verbovskiy.task3.validator.BasketValidator;
import junit.framework.TestCase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class BasketValidatorTest extends TestCase {
    BasketValidator basketValidator;
    @BeforeClass
    public void setUp() {
        basketValidator = new BasketValidator();
    }

    @Test
    public void isBallNumberInBasketNotZeroValidTest() {
        List<Ball> balls = new ArrayList<Ball>();

        balls.add(new Ball(2,2, BallColor.BLUE));
        balls.add(new Ball(2.2,2.3, BallColor.GREEN));
        balls.add(new Ball(1,1, BallColor.ORANGE));
        boolean actual = basketValidator.isBallNumberInBasketNotZero(balls);

        assertTrue(actual);
    }

    @Test
    public void isBallNumberInBasketNotZeroInvalidTest() {
        List<Ball> balls = new ArrayList<Ball>();
        boolean actual = basketValidator.isBallNumberInBasketNotZero(balls);

        assertFalse(actual);
    }
}