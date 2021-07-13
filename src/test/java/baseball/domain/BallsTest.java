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

  @Test
  void play_nothing() {
    Balls playerBalls = new Balls(Arrays.asList(4, 5, 6));
    PlayResult result = balls.play(playerBalls);
    assertThat(result).isEqualTo(new PlayResult(0, 0));
    assertThat(result.isNothing()).isTrue();
  }

  @Test
  void play_1strike_0balls() {
    Balls playerBalls = new Balls(Arrays.asList(1, 5, 6));
    PlayResult result = this.balls.play(playerBalls);
    assertThat(result).isEqualTo(new PlayResult(1, 0));
  }

  @Test
  void play_0strike_1ball() {
    Balls playerBalls = new Balls(Arrays.asList(4, 1, 6));
    PlayResult result = this.balls.play(playerBalls);
    assertThat(result).isEqualTo(new PlayResult(0, 1));
  }

  @Test
  void play_1strike_1ball() {
    Balls playerBalls = new Balls(Arrays.asList(1, 6, 2));
    PlayResult result = this.balls.play(playerBalls);
    assertThat(result).isEqualTo(new PlayResult(1, 1));
  }

  @Test
  void play_1strike_2balls() {
    Balls playerBalls = new Balls(Arrays.asList(1, 3, 2));
    PlayResult result = this.balls.play(playerBalls);
    assertThat(result).isEqualTo(new PlayResult(1, 2));
  }

  @Test
  void play_3strikes_0ball() {
    Balls playerBalls = new Balls(Arrays.asList(1, 2, 3));
    PlayResult result = this.balls.play(playerBalls);
    assertThat(result).isEqualTo(new PlayResult(3, 0));
    assertThat(result.isGameOver()).isTrue();
  }

}
