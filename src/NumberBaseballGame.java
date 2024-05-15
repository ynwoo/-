import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class NumberBaseballGame {

    private char[] computerNumber;

    private char[] userInputNumber;

    private final StringBuilder sb;

    private final InputView inputView;
    private final ResultView resultView;

    private final Rule rule;

    public NumberBaseballGame() {
        this.computerNumber = new char[3];
        this.userInputNumber = new char[3];
        this.sb = new StringBuilder();
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
        computerNumber = getRandomNumber();
    }

    private char[] getRandomNumber() {
        List<Character> numbers = new ArrayList<>(
                Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));

        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int randomIndex = random.nextInt(9 - i);
            computerNumber[i] = numbers.get(randomIndex);
            numbers.remove(randomIndex);
        }

        return computerNumber;
    }

    private void input() throws Exception {
        this.userInputNumber = inputView.inputNumber(userInputNumber);
    }

    private void gamePlay() throws Exception {
        String checkCount = rule.checkCount(computerNumber, userInputNumber, sb);
        resultView.printResult(checkCount);

        if (checkCount.equals(Status.GAME_OVER.getValue())) {
            resultView.printGameOver();
            char userInputYN = inputView.inputResetGame();
            if (userInputYN == 'N') {
                System.exit(0);
            }
            resetGame();
        }
    }

    private void resetGame() {
        init();
    }
}
