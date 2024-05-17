import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputView {

  private static final int BALL_NUMBER = 3;
  private static final BufferedReader br = new BufferedReader(
    new InputStreamReader(System.in)
  );

  public Balls inputNumber() throws Exception {
    System.out.print("세자리 숫자를 입력하세요: ");
    String input = br.readLine();
    Ball[] userInputNumber = new Ball[BALL_NUMBER];

    for (int i = 0; i < BALL_NUMBER; i++) {
      userInputNumber[i] = new Ball(input.charAt(i));
    }
    return new Balls(userInputNumber);
  }

  public String inputResetGame() throws Exception {
    System.out.print("다시 시작 하시겠습니까?(Y/N): ");

    // validation Y/N
    return br.readLine();
  }

  public void printResult(Rule result) {
    System.out.println(result);
  }

  public void printGameOver() {
    System.out.println("게임 종료.");
  }
}
