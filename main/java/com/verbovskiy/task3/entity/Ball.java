package com.verbovskiy.task3.entity;

public class Ball {
    private double weightInKilogram;
    private double volume;
    private BallColor ballColor;

    public Ball(double weightInKilogram, double volume, BallColor ballColor) {
        this.weightInKilogram = weightInKilogram;
        this.volume = volume;
        this.ballColor = ballColor;
    }

    public void setWeightInKilogram(double weightInKilogram) {
        this.weightInKilogram = weightInKilogram;
    }

    public void setBallColor(BallColor ballColor) {
        this.ballColor = ballColor;
    }

    public double getWeightInKilogram() {
        return weightInKilogram;
    }

    public BallColor getBallColor() {
        return ballColor;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Ball ball = (Ball) o;
        if (weightInKilogram != ball.weightInKilogram) {
            return false;
        }
        if (volume != ball.volume) {
            return false;
        }
        if (ballColor == null) {
            if (ball.ballColor != null) {
                return false;
            }
        } else {
            if (!ballColor.equals(ball.ballColor)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        long longBits = Double.doubleToLongBits(weightInKilogram);
        long longBits2 = Double.doubleToLongBits(volume);

        result = 31 * result + (ballColor == null ? 0 : ballColor.hashCode());
        result = 31 * result + (int)(longBits - (longBits >>> 32));
        result = 31 * result + (int)(longBits2 - (longBits2 >>> 32));

        return result;
    }

    @Override
    public String toString() {
        return String.format("%s %f %f", this.ballColor.toString(), this.weightInKilogram, this.volume);
    }
}
