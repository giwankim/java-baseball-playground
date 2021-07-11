package baseball.domain;

public enum BallStatus {
  STRIKE, BALL, NOTHING;

  public static boolean isNotNothing(BallStatus status) {
    return status != NOTHING;
  }
}
