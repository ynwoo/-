package game;

import ball.Balls;
import config.Config;
import ui.InputView;
import ui.ResultView;

public class NumberBaseballGame {

    private final RandomNumberGenerator randomNumberGenerator;
    private Balls computerNumber;
    private Balls userInputNumber;
    private final InputView inputView;
    private final ResultView resultView;
    private final Rule rule;

    public NumberBaseballGame() {
        this.randomNumberGenerator = new RandomNumberGenerator();
        this.inputView = new InputView();
        this.resultView = new ResultView();
        this.rule = new Rule();
    }

    public void start() throws Exception {
        init();

        while (true) {
            input();
            gamePlay();
        }
    }

    private void init() {
        computerNumber = randomNumberGenerator.getRandomNumber();
    }

    private void input() throws Exception {
        this.userInputNumber = inputView.inputNumber();
    }

    private void gamePlay() throws Exception {
        Rule countCheckResult = rule.checkCount(computerNumber, userInputNumber);

        if (countCheckResult.isOut()) {
            resultView.printResult(Config.OUT);
            return;
        }
        resultView.printResult(countCheckResult.getStringResult());

        if (!countCheckResult.isGameOver()) {
            return;
        }

        resultView.printGameOver();
        char userInputYN = inputView.inputResetGame();
        if (userInputYN == Config.END_GAME) {
            System.exit(0);
        }
        resetGame();
    }

    private void resetGame() {
        init();
    }
}
