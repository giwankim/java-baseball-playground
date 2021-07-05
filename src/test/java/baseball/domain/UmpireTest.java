package baseball.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UmpireTest {

  private Umpire umpire;
  private int[] player;

  @BeforeEach
  void setUp() {
    List<Integer> computer = Arrays.asList(7, 1, 3);
    umpire = new Umpire(computer);
  }

  @Test
  void call_zero_strikes() {
    player = new int[]{1, 4, 5};
    assertThat(umpire.callStrikes(player)).isEqualTo(0);
  }

  @Test
  void call_one_strike() {
    player = new int[]{1, 2, 3};
    assertThat(umpire.callStrikes(player)).isEqualTo(1);
  }

  @Test
  void call_two_strikes() {
    player = new int[]{7, 2, 3};
    assertThat(umpire.callStrikes(player)).isEqualTo(2);
  }

  @Test
  void call_three_strikes() {
    player = new int[]{7, 1, 3};
    assertThat(umpire.callStrikes(player)).isEqualTo(3);
  }

  @Test
  void call_three_balls() {
    player = new int[]{3, 7, 1};
    assertThat(umpire.callBalls(player)).isEqualTo(3);
  }

  @Test
  void call_two_balls() {
    player = new int[]{6, 7, 1};
    assertThat(umpire.callBalls(player)).isEqualTo(2);
  }

  @Test
  void call_one_ball() {
    player = new int[]{1, 4, 5};
    assertThat(umpire.callBalls(player)).isEqualTo(1);
  }

}