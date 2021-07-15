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

  public BallStatus play(Ball opponentBall) {
    return balls.stream()
        .map(ball -> ball.play(opponentBall))
        .filter(BallStatus::isNotNothing)
        .findFirst()
        .orElse(BallStatus.NOTHING);
  }

  public PlayResult play(Balls opponentBalls) {
    PlayResult playResult = new PlayResult();
    for (Ball ball : balls) {
      BallStatus ballStatus = opponentBalls.play(ball);
      playResult.update(ballStatus);
    }
    return playResult;
  }

  @Override
  public String toString() {
    String result = "Balls{balls=";
    for (Ball ball : balls) {
      result += ball.getBallNumber().getNumber() + ", ";
    }
    result += '}';
    return result;
  }
}
