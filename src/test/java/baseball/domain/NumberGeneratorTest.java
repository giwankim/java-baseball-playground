package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.HashSet;
import java.util.List;

import java.util.Set;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

  List<Integer> numbers;

  @BeforeEach
  void setUp() {
    numbers = NumberGenerator.getRandomNumber();
  }

  @Test
  void three_numbers_are_generated() {
    assertThat(numbers.size()).isEqualTo(3);
  }

  @Test
  void numbers_are_between_one_and_ten() {
    for (Integer number : numbers) {
      assertThat(number).isBetween(1, 9);
    }
  }

  @Test
  void numbers_are_distinct() {
    Set<Integer> set = new HashSet<>(numbers);
    assertThat(set.size()).isEqualTo(3);
  }
}