package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BallsTest {

  Balls balls;

  @BeforeEach
  void setUp() {
    balls = new Balls(Arrays.asList(1, 2, 3));
  }

  @Test
  void nothing() {
    Ball ball = new Ball(0, 4);
    BallStatus actual = balls.play(ball);
    assertThat(actual).isEqualTo(BallStatus.NOTHING);
  }

  @Test
  void ball() {
    BallStatus actual = balls.play(new Ball(0, 2));
    assertThat(actual).isEqualTo(BallStatus.BALL);
  }

  @Test
  void strike() {
    BallStatus actual = balls.play(new Ball(0, 1));
    assertThat(actual).isEqualTo(BallStatus.STRIKE);
  }
}
