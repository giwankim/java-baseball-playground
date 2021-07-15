package utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RandomUtilsTest {

  @Test
  void nextInt() {
    assertThat(RandomUtils.nextInt(1, 9)).isBetween(1, 9);
  }
}
