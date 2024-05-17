import java.util.ArrayList;
import java.util.List;

public class Balls {

  private List<Ball> balls;

  public Balls(List<Ball> balls) {
    this.balls = balls;
  }

  public Balls(Ball[] balls) {
    this.balls = new ArrayList<>();
    for (Ball ball : balls) this.balls.add(ball);
  }

  public int getSize() {
    return balls.size();
  }

  public Ball get(int ix) {
    return balls.get(ix);
  }

  public boolean contains(Ball ball) {
    return balls.contains(ball);
  }

public Rule check(Balls userInputNumber) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'check'");
}
}
