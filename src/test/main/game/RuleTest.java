package main.game;

import static org.junit.jupiter.api.Assertions.*;

import main.ball.Ball;
import main.ball.Balls;
import main.config.Config;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RuleTest {

    @DisplayName("규칙 테스트 - 3S 0B")
    @Test
    void threeStrikeTest() {
        // given
        final Rule rule = new Rule();

        final Ball[] firstBalls = new Ball[3];
        for (int i = 0; i < Config.BALL_NUMBER; i++) {
            firstBalls[i] = new Ball(i + 1, i);
        }
        final Balls computerBalls = new Balls(firstBalls);

        final Ball[] secondBalls = new Ball[3];
        for (int i = 0; i < Config.BALL_NUMBER; i++) {
            secondBalls[i] = new Ball(i + 1, i);
        }
        final Balls userBalls = new Balls(secondBalls);

        // when
        Rule result = rule.checkCount(computerBalls, userBalls);

        // then
        assertTrue(result.isGameOver());
        assertEquals(result.getStringResult(), "3S 0B");
    }

    @DisplayName("규칙 테스트 - 0S 0B")
    @Test
    void outTest() {
        // given
        final Rule rule = new Rule();

        final Ball[] firstBalls = new Ball[3];
        for (int i = 0; i < Config.BALL_NUMBER; i++) {
            firstBalls[i] = new Ball(i + 1, i);
        }
        final Balls computerBalls = new Balls(firstBalls);

        final Ball[] secondBalls = new Ball[3];
        for (int i = 0; i < Config.BALL_NUMBER; i++) {
            secondBalls[i] = new Ball(i + 4, i);
        }
        final Balls userBalls = new Balls(secondBalls);

        // when
        Rule result = rule.checkCount(computerBalls, userBalls);

        // then
        assertTrue(result.isOut());
    }

    @DisplayName("규칙 테스트 - 0S 3B")
    @Test
    void threeBallTest() {
        // given
        final Rule rule = new Rule();

        final Ball[] firstBalls = new Ball[3];
        for (int i = 0; i < Config.BALL_NUMBER; i++) {
            firstBalls[i] = new Ball(i + 1, i);
        }
        final Balls computerBalls = new Balls(firstBalls);

        final Ball[] secondBalls = new Ball[3];
        for (int i = 0; i < Config.BALL_NUMBER; i++) {
            secondBalls[i] = new Ball(i + 2, i);
        }
        secondBalls[2] = new Ball(1, 0);
        final Balls userBalls = new Balls(secondBalls);

        // when
        Rule result = rule.checkCount(computerBalls, userBalls);

        // then
        assertEquals(result.getStringResult(), "0S 3B");
    }
}