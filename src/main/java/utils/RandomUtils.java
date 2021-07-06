package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomUtils {

  private static final Random RANDOM = new Random();
  private static final int START_INCLUSIVE = 1;
  private static final int END_INCLUSIVE = 9;

  public static int nextInt(final int startInclusive, final int endInclusive) {
    int bound = endInclusive - startInclusive + 1;
    return RANDOM.nextInt(bound) + startInclusive;
  }

  public static List<Integer> getRandomNumber() {
    List<Integer> numbers = new ArrayList<>();
    while (numbers.size() < 3) {
      int number = nextInt(START_INCLUSIVE, END_INCLUSIVE);
      if (!numbers.contains(number)) {
        numbers.add(number);
      }
    }
    return numbers;
  }
}
