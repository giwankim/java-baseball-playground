package calculator.domain;

import java.util.Scanner;

public class Calculator {

  private static String getText() {
    System.out.println("문자열을 입력하세요:");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }

  public static int calculate(String text) {
    if (isBlank(text)) {
      return 0;
    }
    String[] tokens = text.split(" ");
    int result = Integer.parseInt(tokens[0]);
    for (int i = 1; i < tokens.length; i += 2) {
      String operator = tokens[i];
      int number = Integer.parseInt(tokens[i + 1]);
      result = getNextResult(result, operator, number);
    }
    return result;
  }

  private static int getNextResult(int result, String operator, int number) {
    int nextResult = result;
    switch (operator) {
      case "+":
        nextResult += number;
        break;
      case "-":
        nextResult -= number;
        break;
      case "*":
        nextResult *= number;
        break;
      case "/":
        nextResult /= number;
        break;
      default:
        break;
    }
    return nextResult;
  }

  private static boolean isBlank(String text) {
    return text == null || text.isEmpty();
  }

  public static void main(String[] args) {
    String text = getText();
    int result = calculate(text);
    System.out.println("결과값: " + result);
  }
}
