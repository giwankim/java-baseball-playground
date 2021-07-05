package calculator.domain;

import java.util.Scanner;

public class Input {

  public static String getText() {
    System.out.println("문자열을 입력하세요:");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }
}
