package main.game;

import main.ball.Ball;
import main.ball.Balls;
import main.config.Config;

public class Rule {

    private Integer strikeCount;
    private Integer ballCount;

    public Rule checkCount(Balls computerNumber, Balls userInputNumber) {
        initCount();
        for (int i = 0; i < Config.BALL_NUMBER; i++) {
            checkOneBall(computerNumber, userInputNumber, i);
        }

        return this;
    }

    private void checkOneBall(Balls computerNumber, Balls userInputNumber, int i) {
        Ball userBall = userInputNumber.getBall(i);
        if (isStrike(computerNumber.getBall(i), userBall)) {
            return;
        }
        isBall(computerNumber, userBall);
    }

    private boolean isStrike(Ball computerBall, Ball userBall) {
        if (computerBall.getNumber() == userBall.getNumber()
                && computerBall.getPosition() == userBall.getPosition()) {
            strikeCount++;
            return true;
        }
        return false;
    }

    private void isBall(Balls computerNumber, Ball userBall) {
        if (computerNumber.contains(userBall)) {
            ballCount++;
        }
    }

    public boolean isOut() {
        return (strikeCount == 0 && ballCount == 0);
    }

    private void initCount() {
        strikeCount = 0;
        ballCount = 0;
    }

    public String getStringResult() {
        return new StringBuilder()
                .append(strikeCount).append(Config.STRIKE_DISPLAY)
                .append(" ")
                .append(ballCount).append(Config.BALL_DISPLAY)
                .toString();
    }

    public boolean isGameOver() {
        return strikeCount == Config.BALL_NUMBER;
    }
}
