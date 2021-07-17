package baseball.view;

import java.util.Scanner;

public class InputView {

  private final static Scanner scanner = new Scanner(System.in);
  public static final String PROMPT_FOR_NUMBERS = "숫자를 입력해 주세요 : ";
  public static final String PROMPT_WHETHER_TO_END_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

  public static String askForNumbers() {
    System.out.print(PROMPT_FOR_NUMBERS);
    return scanner.next();
  }

  public static boolean askIfGameOver() {
    System.out.println(PROMPT_WHETHER_TO_END_GAME);
    return scanner.nextInt() == 2;
  }
}
