package baseball;

import baseball.domain.Baseball;
import java.util.Scanner;

public class Application {

  public static void main(String[] args) {
    final Scanner scanner = new Scanner(System.in);
    Baseball baseball = new Baseball(scanner);
    baseball.playGame();
  }
}
