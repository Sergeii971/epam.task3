package com.verbovskiy.task3.entity;

import java.util.Collections;
import java.util.List;

public class Basket {
    private List<Ball> balls;
    private double volumeInCubicMeters;
    private final double weightLimitInKilograms;

    public Basket(List<Ball> balls, double volumeInCubicMeters, double weightLimitInKilograms) {
        this.balls = balls;
        this.volumeInCubicMeters = volumeInCubicMeters;
        this.weightLimitInKilograms = weightLimitInKilograms;
    }

    public void setBalls(List<Ball> balls) {
        this.balls = balls;
    }

    public List<Ball> getBalls() {
        return Collections.unmodifiableList(balls);
    }

    public double getWeightLimitInKilograms() {
        return weightLimitInKilograms;
    }

    public void setVolumeInCubicMeters(double volumeInCubicMeters) {
        this.volumeInCubicMeters = volumeInCubicMeters;
    }

    public double getVolumeInCubicMeters() {
        return volumeInCubicMeters;
    }

    public void add(Ball ball) {
        balls.add(ball);
    }

    public void remove(int index) {
        balls.remove(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Basket basket = (Basket) o;
        if (volumeInCubicMeters != basket.volumeInCubicMeters) {
            return false;
        }
        if (weightLimitInKilograms != basket.weightLimitInKilograms) {
            return false;
        }
        if (balls == null) {
            if (basket.balls != null) {
                return false;
            }
        } else {
            if (!balls.equals(basket.balls)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        long longBits = Double.doubleToLongBits(volumeInCubicMeters);
        long longBits2 = Double.doubleToLongBits(weightLimitInKilograms);

        result = 31 * result + (balls == null ? 0 : balls.hashCode());
        result = 31 * result + (int)(longBits - (longBits >>> 32));
        result = 31 * result + (int)(longBits2 - (longBits2 >>> 32));

        return result;
    }

    @Override
    public String toString() {
        return String.format("%f %f %s",this.volumeInCubicMeters, this.weightLimitInKilograms, this.balls.toString());
    }
}
