package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

  public static List<Integer> getUserInput(final Scanner scanner) {
    System.out.print("숫자를 입력해 주세요 : ");
    String userInput = scanner.next();
    return parseUserInput(userInput);
  }

  public static List<Integer> parseUserInput(String input) {
    List<Integer> numbers = new ArrayList<>();
    for (int i = 0; i < input.length(); i++) {
      int number = input.charAt(i) - '0';
      numbers.add(number);
    }
    return numbers;
  }

}
