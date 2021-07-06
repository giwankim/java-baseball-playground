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
    if (balls == 0 && strikes == 0) {
      return "낫싱";
    }
    StringBuilder stringBuilder = new StringBuilder();
    if (balls > 0) {
      stringBuilder.append(balls);
      stringBuilder.append("볼");
      if (strikes > 0) {
        stringBuilder.append(" ");
      }
    }
    if (strikes > 0) {
      stringBuilder.append(strikes);
      stringBuilder.append("스트라이크");
    }
    return stringBuilder.toString();
  }

}
