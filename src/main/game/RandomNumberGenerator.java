package main.game;

import main.ball.Ball;
import main.ball.Balls;
import main.config.Config;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator {

    private final List<Integer> numbers;

    public RandomNumberGenerator() {
        this.numbers = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    public Balls getRandomNumber() {
        Collections.shuffle(numbers);

        Ball[] balls = new Ball[Config.BALL_NUMBER];
        for (int i = 0; i < Config.BALL_NUMBER; i++) {
            balls[i] = new Ball(numbers.get(i), i);
        }

        return new Balls(balls);
    }
}
