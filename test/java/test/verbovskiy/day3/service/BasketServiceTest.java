package test.verbovskiy.day3.service;

import com.verbovskiy.task3.entity.Ball;
import com.verbovskiy.task3.entity.BallColor;
import com.verbovskiy.task3.entity.Basket;
import com.verbovskiy.task3.exception.TaskException;
import com.verbovskiy.task3.service.BasketService;
import junit.framework.TestCase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertNotEquals;

public class BasketServiceTest extends TestCase {
    BasketService basketService;

    @BeforeClass
    public void setUp() {
        basketService = new BasketService();
    }

    @Test
    public void addBallToBasketValidTest() {
        try {
            Ball ball = new Ball(2,2, BallColor.BLUE);
            boolean actual = basketService.addBallToBasket(new Basket(new ArrayList<Ball>(),
                            15,15),ball);

            assertTrue(actual);
        } catch (TaskException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void addBallToBasketInvalidTest() {
        try {
            Ball ball = new Ball(11,11, BallColor.BLUE);
            boolean actual = basketService.addBallToBasket(new Basket(new ArrayList<Ball>(),
                    9,10),ball);

            assertFalse(actual);
        } catch (TaskException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = TaskException.class)
    public void addBallToBasketExceptionTest() throws TaskException {
            basketService.addBallToBasket(null,null);
    }

    @Test
    public void removeBallFromBasketValidTest() {
        try {
            Ball ball1 = new Ball(2,2, BallColor.BLUE);
            Ball ball2 = new Ball(2.2,2.3, BallColor.GREEN);
            Ball ball3 =new Ball(1,1, BallColor.ORANGE);
            List<Ball> ballsToRemove = new ArrayList<Ball>();

            ballsToRemove.add(ball1);
            ballsToRemove.add(ball2);
            ballsToRemove.add(ball3);
            boolean actual = basketService.removeBallFromBasket(new Basket(ballsToRemove,
                    10,10),2);

                assertTrue(actual);
        } catch (TaskException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void removeBallFromBasketInvalidTest() {
        try {
            Ball ball1 = new Ball(2,2, BallColor.BLUE);
            Ball ball2 = new Ball(2.2,2.3, BallColor.GREEN);
            Ball ball3 =new Ball(1,1, BallColor.ORANGE);
            List<Ball> ballsToRemove = new ArrayList<Ball>();

            ballsToRemove.add(ball1);
            ballsToRemove.add(ball2);
            ballsToRemove.add(ball3);
            boolean actual = basketService.removeBallFromBasket(new Basket(ballsToRemove,
                    10,10),5);

            assertFalse(actual);
        } catch (TaskException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = TaskException.class)
    public void removeBallFromBasketExceptionTest() throws TaskException {
        basketService.removeBallFromBasket(null,2);
    }

    @Test
    public void calculateTotalBallVolumeInBasketValidTest() {
        try {
            Ball ball1 = new Ball(2,2, BallColor.BLUE);
            Ball ball2 = new Ball(2.2,2.3, BallColor.GREEN);
            Ball ball3 =new Ball(1,1, BallColor.ORANGE);
            List<Ball> balls = new ArrayList<Ball>();

            balls.add(ball1);
            balls.add(ball2);
            balls.add(ball3);
            double expected = 5.3;
            double actual = basketService.calculateTotalBallVolumeInBasket(new Basket(balls,
                    10,10));

            assertEquals(actual,expected, 0.001);
        } catch (TaskException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void calculateTotalBallVolumeInBasketInvalidTest() {
        try {
            Ball ball1 = new Ball(2,2, BallColor.BLUE);
            Ball ball2 = new Ball(2.2,2.3, BallColor.GREEN);
            Ball ball3 =new Ball(1,1, BallColor.ORANGE);
            List<Ball> balls = new ArrayList<Ball>();

            balls.add(ball1);
            balls.add(ball2);
            balls.add(ball3);
            double expected = 6;
            double actual = basketService.calculateTotalBallVolumeInBasket(new Basket(balls,
                    10,10));

            assertNotEquals(actual,expected, 0.001);
        } catch (TaskException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = TaskException.class)
    public void calculateTotalBallVolumeInBasketExceptionTest() throws TaskException {
        basketService.calculateTotalBallVolumeInBasket(null);
    }

    @Test
    public void calculateTotalBallWeightInBasketValidTest() {
        try {
            Ball ball1 = new Ball(2,2, BallColor.BLUE);
            Ball ball2 = new Ball(2.2,2.3, BallColor.GREEN);
            Ball ball3 =new Ball(1,1, BallColor.ORANGE);
            List<Ball> balls = new ArrayList<Ball>();
            balls.add(ball1);
            balls.add(ball2);
            balls.add(ball3);
            double expected = 5.2;
            double actual = basketService.calculateTotalBallWeightInBasket(new Basket(balls,
                    10,10));

            assertEquals(actual,expected, 0.001);
        } catch (TaskException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void calculateTotalBallWeightInBasketInvalidTest() {
        try {
            Ball ball1 = new Ball(2,2, BallColor.BLUE);
            Ball ball2 = new Ball(2.2,2.3, BallColor.GREEN);
            Ball ball3 =new Ball(1,1, BallColor.ORANGE);
            List<Ball> balls = new ArrayList<Ball>();
            balls.add(ball1);
            balls.add(ball2);
            balls.add(ball3);
            double expected = 6;
            double actual = basketService.calculateTotalBallWeightInBasket(new Basket(balls,
                    10,10));

            assertNotEquals(actual,expected, 0.001);
        } catch (TaskException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = TaskException.class)
    public void calculateTotalBallWeightInBasketExceptionTest() throws TaskException {
        basketService.calculateTotalBallWeightInBasket(null);
    }

    @Test
    public void calculateCertainColorBallNumberInBasketValidTest() {
        try {
            Ball ball1 = new Ball(2,2, BallColor.BLUE);
            Ball ball2 = new Ball(2.2,2.3, BallColor.GREEN);
            Ball ball3 =new Ball(1,1, BallColor.ORANGE);
            List<Ball> balls = new ArrayList<Ball>();
            balls.add(ball1);
            balls.add(ball2);
            balls.add(ball3);
            int expected = 1;
            int actual = basketService.calculateCertainColorBallNumberInBasket(new Basket(balls,
                    10,10), BallColor.ORANGE);

            assertEquals(actual,expected);
        } catch (TaskException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void calculateCertainColorBallNumberInBasketInvalidTest() {
        try {
            Ball ball1 = new Ball(2,2, BallColor.BLUE);
            Ball ball2 = new Ball(2.2,2.3, BallColor.GREEN);
            Ball ball3 =new Ball(1,1, BallColor.ORANGE);
            List<Ball> balls = new ArrayList<Ball>();
            balls.add(ball1);
            balls.add(ball2);
            balls.add(ball3);
            int expected = 2;
            int actual = basketService.calculateCertainColorBallNumberInBasket(new Basket(balls,
                    10,10), BallColor.ORANGE);

            assertNotEquals(actual,expected);
        } catch (TaskException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = TaskException.class)
    public void calculateCertainColorBallNumberInBasketExceptionTest() throws TaskException {
        basketService.calculateCertainColorBallNumberInBasket(null,null);
    }
}