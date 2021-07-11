package baseball.domain;

public class BallNumber {

  public static final int MIN_NUMBER = 1;
  public static final int MAX_NUMBER = 9;
  int number;

  public BallNumber(int number) {
    if (number < MIN_NUMBER || number > MAX_NUMBER) {
      String exceptionMessage = String
          .format("Ball number should be between %d and %d", MIN_NUMBER, MAX_NUMBER);
      throw new IllegalArgumentException(exceptionMessage);
    }
    this.number = number;
  }

  public int getNumber() {
    return number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BallNumber)) {
      return false;
    }
    BallNumber that = (BallNumber) o;
    return getNumber() == that.getNumber();
  }
}
