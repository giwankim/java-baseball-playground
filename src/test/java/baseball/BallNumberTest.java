package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BallNumberTest {

  int min_number;
  int max_number;

  @BeforeEach
  void setUp() {
    min_number = BallNumber.MIN_NUMBER;
    max_number = BallNumber.MAX_NUMBER;
  }

  @Test
  void number_between_1_to_9() {
    BallNumber ballNumberMin = new BallNumber(min_number);
    assertThat(ballNumberMin.getNumber())
        .isBetween(min_number, max_number);
    BallNumber ballNumberMax = new BallNumber(max_number);
    assertThat(ballNumberMax.getNumber()).isBetween(min_number, max_number);
  }

  @Test
  void number_not_between_1_to_9() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> new BallNumber(min_number - 1))
        .withMessage("Ball number should be between %d and %d", min_number, max_number);
  }
}
