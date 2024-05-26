package main.ui;

import main.ball.Ball;
import main.ball.Balls;
import main.config.Config;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputView {

    private final BufferedReader br;

    public InputView() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public Balls inputNumber() throws Exception {
        Ball[] userInputNumber = new Ball[Config.BALL_NUMBER];

        System.out.print("세자리 숫자를 입력하세요: ");
        String input = br.readLine();

        for (int i = 0; i < Config.BALL_NUMBER; i++) {
            userInputNumber[i] = new Ball(input.charAt(i) - '0', i);
        }
        return new Balls(userInputNumber);
    }

    public char inputResetGame() throws Exception {
        System.out.print("다시시작 하시겠습니까? (Y/N): ");
        return br.readLine().charAt(0);
    }
}