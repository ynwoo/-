import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberBaseballGame {

  private static final List<Integer> numbers = new ArrayList<>(
    Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)
  );
  private static final int BALL_NUMBER = 3;
  private Balls computerNumber;

  private Balls userInputNumber;

  private final InputView inputView;

  public NumberBaseballGame() {
    this.inputView = new InputView();
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

  private Balls getRandomNumber() {
    Collections.shuffle(numbers);
    Ball[] result = new Ball[BALL_NUMBER];
    for (int i = 0; i < BALL_NUMBER; i++) {
      result[i] = new Ball(numbers.get(i));
    }
    return new Balls(result);
  }

  private void input() throws Exception {
    this.userInputNumber = inputView.inputNumber();
  }

  private void gamePlay() throws Exception {
    Rule rule = computerNumber.check(userInputNumber);
    inputView.printResult(rule);

    if (rule.isGameOver()) {
      inputView.printGameOver();
      String userInputYN = inputView.inputResetGame();
      checkResetGame(userInputYN);
      resetGame();
    }
  }

  private void checkResetGame(String userInputYN) {
    if (userInputYN.equals("N")) {
      System.exit(0);
    }
  }

  private void resetGame() {
    init();
  }
}
