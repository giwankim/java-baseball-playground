package utils;

import java.util.Random;

public class RandomUtils {

  private static Random RANDOM = new Random();

  public static int nextInt(final int startInclusive, final int endInclusive) {
    if (startInclusive > endInclusive) {
      throw new IllegalArgumentException();
    }
    if (startInclusive < 0) {
      throw new IllegalArgumentException();
    }
    return startInclusive + RANDOM.nextInt(endInclusive - startInclusive + 1);
  }
}
