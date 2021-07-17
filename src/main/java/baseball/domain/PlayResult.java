package baseball.domain;

public class PlayResult {

  private int strikes;
  private int balls;

  public PlayResult() {
    strikes = 0;
    balls = 0;
  }

  public PlayResult(int strikes, int balls) {
    this.strikes = strikes;
    this.balls = balls;
  }

  public int getStrikes() {
    return strikes;
  }

  public int getBalls() {
    return balls;
  }

  public boolean isNothing() {
    return strikes == 0 && balls == 0;
  }

  public void update(BallStatus ballStatus) {
    if (ballStatus.isStrike()) {
      strikes += 1;
    }
    if (ballStatus.isBall()) {
      balls += 1;
    }
  }

  public boolean isGameOver() {
    return strikes == 3;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PlayResult)) {
      return false;
    }
    PlayResult that = (PlayResult) o;
    return getStrikes() == that.getStrikes() && getBalls() == that.getBalls();
  }
}
