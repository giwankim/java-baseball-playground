package baseball.domain;

import java.util.Objects;

public class Ball {

  int position;
  BallNumber ballNumber;

  public Ball(int position, int number) {
    this.position = position;
    this.ballNumber = new BallNumber(number);
  }

  public int getPosition() {
    return position;
  }

  public BallNumber getBallNumber() {
    return ballNumber;
  }

  public BallStatus play(Ball ball) {
    if (this.equals(ball)) {
      return BallStatus.STRIKE;
    }
    if (isSameBallNumber(ball)) {
      return BallStatus.BALL;
    }
    return BallStatus.NOTHING;
  }

  private boolean isSameBallNumber(Ball ball) {
    if (ball == null) {
      return false;
    }
    return ballNumber.equals(ball.getBallNumber());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Ball)) {
      return false;
    }
    Ball ball = (Ball) o;
    return getPosition() == ball.getPosition() && Objects
        .equals(getBallNumber(), ball.getBallNumber());
  }
}
