package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CalculatorTest {

  @Test
  void null_or_empty_input() {
    assertThat(Calculator.calculate(null)).isEqualTo(0);
    assertThat(Calculator.calculate("")).isEqualTo(0);
  }

  @Test
  void single_number() {
    assertThat(Calculator.calculate("1")).isEqualTo(1);
  }

  @Test
  void add_two_numbers() {
    assertThat(Calculator.calculate("1 + 2")).isEqualTo(3);
  }

  @Test
  void subtract_two_numbers() {
    assertThat(Calculator.calculate("3 - 4")).isEqualTo(-1);
  }

  @Test
  void multiply_two_numbers() {
    assertThat(Calculator.calculate("2 * 3")).isEqualTo(6);
  }

  @Test
  void divide_two_numbers() {
    assertThat(Calculator.calculate("14 / 2")).isEqualTo(7);
  }

  @Test
  void mixed_operations() {
    assertThat(Calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
  }
}