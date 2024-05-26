package main.ball;

import java.util.Arrays;
import java.util.List;

public class Balls {

    private final List<Ball> balls;

    public Balls(Ball[] balls) {
        this.balls = Arrays.asList(balls);
    }

    public Ball getBall(Integer i) {
        return balls.get(i);
    }

    public boolean contains(Ball userBall) {
        return balls.contains(userBall);
    }
}
