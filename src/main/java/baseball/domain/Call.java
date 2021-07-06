package baseball.domain;

public class Call {

  final int balls;
  final int strikes;

  public Call(int balls, int strikes) {
    this.balls = balls;
    this.strikes = strikes;
  }

  public int getBalls() {
    return balls;
  }

  public int getStrikes() {
    return strikes;
  }

  @Override
  public String toString() {
    return "Call{" +
        "balls=" + balls +
        ", strikes=" + strikes +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Call)) {
      return false;
    }
    Call call = (Call) o;
    return getBalls() == call.getBalls() && getStrikes() == call.getStrikes();
  }
}
