package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGenerator {

  private static Random random = new Random();

  public static List<Integer> getRandomNumber() {
    List<Integer> numbers = new ArrayList<>();
    while (numbers.size() < 3) {
      int number = 1 + random.nextInt(9);
      if (!numbers.contains(number)) {
        numbers.add(number);
      }
    }
    return numbers;
  }
}
