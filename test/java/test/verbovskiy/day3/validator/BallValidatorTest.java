package test.verbovskiy.day3.validator;

import com.verbovskiy.task3.entity.Ball;
import com.verbovskiy.task3.entity.BallColor;
import com.verbovskiy.task3.validator.BallValidator;
import junit.framework.TestCase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class BallValidatorTest extends TestCase {
    BallValidator ballValidator;

    @BeforeClass
    public void setUp() {
    ballValidator = new BallValidator();
    }

    @Test
    public void isBallColorNotNullValidTest() {
        List<Ball> balls = new ArrayList<Ball>();

        balls.add(new Ball(2,-2, BallColor.BLUE));
        balls.add(new Ball(2.2,-3, BallColor.GREEN));
        balls.add(new Ball(1,0, BallColor.ORANGE));
        boolean actual = ballValidator.isBallColorNotNull(balls);

        assertTrue(actual);
    }

    @Test
    public void isBallColorNotNullInvalidTest() {
        List<Ball> balls = new ArrayList<Ball>();

        balls.add(new Ball(2,-2, null));
        balls.add(new Ball(2.2,-3, BallColor.GREEN));
        balls.add(new Ball(1,0, BallColor.ORANGE));
        boolean actual = ballValidator.isBallColorNotNull(balls);

        assertFalse(actual);
    }
}