package main.game;

import main.ball.Balls;
import main.config.Config;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomNumberGeneratorTest {

    @DisplayName("랜덤 숫자 생성 위치 테스트")
    @Test
    void randomNumberPositionTest() {
        // given
        final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        // when
        final Balls randomNumber = randomNumberGenerator.getRandomNumber();

        // then
        for (int i = 0; i < Config.BALL_NUMBER; i++) {
            assertEquals(randomNumber.getBall(i).getPosition(), i);
        }
    }

    @DisplayName("랜덤 숫자 3자리 서로 다른지 테스트")
    @Test
    void randomNumberDifferenceTest() {
        // given
        final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        // when
        final Balls randomNumber = randomNumberGenerator.getRandomNumber();

        // then
        assertNotEquals(randomNumber.getBall(0).getNumber(),
                randomNumber.getBall(1).getNumber());
        assertNotEquals(randomNumber.getBall(0).getNumber(),
                randomNumber.getBall(2).getNumber());
        assertNotEquals(randomNumber.getBall(1).getNumber(),
                randomNumber.getBall(2).getNumber());
    }

    @DisplayName("랜덤 숫자 3자리 범위 테스트")
    @Test
    void randomNumberRangeTest() {
        // given
        final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        // when
        final Balls randomNumber = randomNumberGenerator.getRandomNumber();

        // then
        for (int i = 0; i < Config.BALL_NUMBER; i++) {
            assertTrue(isInRange(randomNumber.getBall(i).getNumber()));
        }
    }

    private boolean isInRange(int number) {
        return number >= 1 && number <= 9;
    }
}