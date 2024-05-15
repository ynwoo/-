public class Rule {

    public String checkCount(char[] computerNumber, char[] userInputNumber,
            StringBuilder sb) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (computerNumber[i] == userInputNumber[j] && i == j) {
                    strike += 1;
                    continue;
                }
                if (computerNumber[i] == userInputNumber[j] && i != j) {
                    ball += 1;
                }
            }
        }
        if (strike == 0 && ball == 0) {
            return Status.OUT.getValue();
        }

        sb.setLength(0);
        sb.append(strike).append("S ");
        sb.append(ball).append("B");
        return sb.toString();
    }
}
