package utils;

public class Output {

  public static void printResult(int ball, int strike) {
    String result = "";
    if (ball == 0 && strike == 0) {
      result += "낫싱";
    }
    if (ball > 0) {
      result += ball + "볼";
      if (strike > 0) {
        result += " ";
      }
    }
    if (strike > 0) {
      result += strike + "스트라이크";
    }

    System.out.println(result);
  }

  public static void main(String[] args) {
    printResult(1, 1);
    printResult(1, 0);
    printResult(2, 0);
    printResult(0, 1);
    printResult(0, 3);
    printResult(0, 0);
  }
}
