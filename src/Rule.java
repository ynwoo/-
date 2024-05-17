public class Rule {

  private int strike;
  private int ball;

  public Rule() {
    strike = 0;
    ball = 0;
  }

  public void checkCount(Balls computerNumber, Balls userInputNumber) {
    int size = computerNumber.getSize();

    for (int i = 0; i < size; i++) {
      process(computerNumber, userInputNumber, i);
    }
  }

  private void process(Balls computerNumber, Balls userInputNumber, int i) {
    Ball inputBall = userInputNumber.get(i);
    if (isStrike(computerNumber, userInputNumber, i)) return;
    isBall(computerNumber, inputBall);
  }

  private boolean isStrike(Balls computerNumber, Balls userInputNumber, int i) {
    if (computerNumber.get(i) == userInputNumber.get(i)) {
      strike++;
      return true;
    }
    return false;
  }

  private void isBall(Balls computerNumber, Ball inputBall) {
    if (computerNumber.contains(inputBall)) ball++;
  }

  public boolean isGameOver() {
    return strike == Config.LENGTH;
  }

  @Override
  public String toString() {
    return strike + "strike " + ball + "ball";
  }
}
