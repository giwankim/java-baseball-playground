package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UmpireTest {

  List<Integer> computer;

  @BeforeEach
  void setUp() {
    computer = Arrays.asList(7, 1, 3);
  }

  @Test
  void one_ball_one_strike() {
    List<Integer> player = Arrays.asList(1, 2, 3);
    Call actualCall = Umpire.makeCall(player, computer);
    Call expectedCall = new Call(1, 1);
    assertThat(actualCall).isEqualTo(expectedCall);
  }


  @Test
  void one_ball() {
    List<Integer> player = Arrays.asList(1, 4, 5);
    Call actualCall = Umpire.makeCall(player, computer);
    Call expectedCall = new Call(1, 0);
    assertThat(actualCall).isEqualTo(expectedCall);
  }

  @Test
  void two_balls() {
    List<Integer> player = Arrays.asList(6, 7, 1);
    Call actualCall = Umpire.makeCall(player, computer);
    Call expectedCall = new Call(2, 0);
    assertThat(actualCall).isEqualTo(expectedCall);
  }

  @Test
  void one_strike() {
    List<Integer> player = Arrays.asList(2, 1, 6);
    Call actualCall = Umpire.makeCall(player, computer);
    Call expectedCall = new Call(0, 1);
    assertThat(actualCall).isEqualTo(expectedCall);
  }

  @Test
  void three_strikes() {
    List<Integer> player = Arrays.asList(7, 1, 3);
    Call actualCall = Umpire.makeCall(player, computer);
    Call expectedCall = new Call(0, 3);
    assertThat(actualCall).isEqualTo(expectedCall);
  }

}