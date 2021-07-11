package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallTest {

  Ball computerBall;

  @BeforeEach
  void setUp() {
    computerBall = new Ball(0, 1);
  }

  @Test
  @DisplayName("낫싱")
  void nothing() {
    Ball playerBall = new Ball(1, 2);
    assertThat(computerBall.play(playerBall)).isEqualTo(BallStatus.NOTHING);

    Ball differentNumberBall = new Ball(0, 2);
    assertThat(computerBall.play(differentNumberBall)).isEqualTo(BallStatus.NOTHING);
  }

  @Test
  @DisplayName("볼")
  void ball() {
    Ball playerBall = new Ball(1, 1);
    assertThat(computerBall.play(playerBall)).isEqualTo(BallStatus.BALL);
  }

  @Test
  @DisplayName("스트라이크")
  void strike() {
    Ball playerBall = new Ball(0, 1);
    assertThat(computerBall.play(playerBall)).isEqualTo(BallStatus.STRIKE);
  }
}
