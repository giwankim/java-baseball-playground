import calculator.domain.Calculator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {

  public static void main(String[] args) {

    // Calculator
    Calculator calculator = new Calculator();

    // Get input tokens
    List<String> inputTokens = getInputTokens();

    List<Integer> numbers = new ArrayList<>();
    List<String> operators = new ArrayList<>();
    for (int i = 0; i < inputTokens.size(); i++) {
      String token = inputTokens.get(i);
      if (i % 2 == 0) {
        int number = Integer.parseInt(token);
        numbers.add(number);
      } else {
        operators.add(token);
      }
    }

    int result = numbers.get(0);
    int operatorIndex = 0;
    for (int i = 1; i < numbers.size(); i++) {
      int number = numbers.get(i);
      String operator = operators.get(operatorIndex);
      operatorIndex += 1;
      switch (operator) {
        case "+":
          result = calculator.add(result, number);
          break;
        case "-":
          result = calculator.subtract(result, number);
          break;
        case "*":
          result = calculator.multiply(result, number);
          break;
        case "/":
          result = calculator.divide(result, number);
          break;
        default:
          break;
      }
    }
    System.out.println(result);
  }

  public static List<String> getInputTokens() {
    System.out.println("계산하고 싶은 문자열을 입력해 주세요:");
    Scanner scanner = new Scanner(System.in);
    String line = scanner.nextLine();
    String[] values = line.split(" ");
    return Arrays.asList(values);
  }
}
