import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputView {

    private final BufferedReader br;

    public InputView() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public char[] inputNumber(char[] userInputNumber) throws Exception {
        System.out.print("세자리 숫자를 입력하세요: ");
        String input = br.readLine();

        for (int i = 0; i < 3; i++) {
            userInputNumber[i] = input.charAt(i);
        }
        return userInputNumber;
    }

    public char inputResetGame() throws Exception {
        System.out.print("다시 시작 하시겠습니까?(Y/N): ");
        return br.readLine().charAt(0);
    }
}