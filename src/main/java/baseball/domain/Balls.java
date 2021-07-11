package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Balls {

  final List<Ball> balls;

  public Balls(List<Integer> numbers) {
    validate(numbers);
    this.balls = mapToBalls(numbers);
  }

  private static List<Ball> mapToBalls(List<Integer> numbers) {
    List<Ball> balls = new ArrayList<>();
    for (int i = 0; i < numbers.size(); i++) {
      Ball ball = new Ball(i, numbers.get(i));
      balls.add(ball);
    }
    return balls;
  }

  private void validate(List<Integer> numbers) {
    HashSet<Integer> integers = new HashSet<>(numbers);
    if (integers.size() != 3) {
      throw new IllegalArgumentException("서로 다른 3자리 숫자를 입력해주세요!");
    }
  }

  public BallStatus play(Ball playerBall) {
    return balls.stream()
        .map(ball -> ball.play(playerBall))
        .filter(BallStatus::isNotNothing)
        .findFirst()
        .orElse(BallStatus.NOTHING);
  }
}
