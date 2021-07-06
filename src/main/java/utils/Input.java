package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

  public static List<Integer> getInput(final Scanner scanner) {
    System.out.print("숫자를 입력해 주세요 : ");
    String input = scanner.next();
    return parse(input);
  }

  public static List<Integer> parse(String input) {
    List<Integer> numbers = new ArrayList<>();
    for (int i = 0; i < input.length(); i++) {
      int number = input.charAt(i) - '0';
      numbers.add(number);
    }
    return numbers;
  }

  public static void main(String[] args) {
    final Scanner scanner = new Scanner(System.in);
    List<Integer> player = getInput(scanner);
    System.out.println("사용자 입력 : " + player);
    System.out.println("Length = " + player.size());
  }
}
