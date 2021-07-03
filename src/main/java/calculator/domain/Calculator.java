package calculator.domain;

import java.util.Scanner;

public class Calculator {

  private static String getInput() {
    System.out.println("문자열:");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }

  public int calculate(String text) {
    if (isBlank(text)) {
      return 0;
    }
    String[] tokens = text.split(" ");
    int result = Integer.parseInt(tokens[0]);
    for (int i = 1; i < tokens.length; i += 2) {
      String operator = tokens[i];
      int number = Integer.parseInt(tokens[i + 1]);
      result = getResult(result, operator, number);
    }
    return result;
  }

  private int getResult(int result, String operator, int number) {
    switch (operator) {
      case "+":
        result += number;
        break;
      case "-":
        result -= number;
        break;
      case "*":
        result *= number;
        break;
      case "/":
        result /= number;
        break;
      default:
        break;
    }
    return result;
  }

  private boolean isBlank(String text) {
    return text == null || text.isEmpty();
  }

  public static void main(String[] args) {
    Calculator calculator = new Calculator();
    String text = getInput();
    int result = calculator.calculate(text);
    System.out.println(result);
  }
}
