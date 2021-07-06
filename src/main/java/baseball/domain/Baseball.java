package baseball.domain;

import java.util.List;
import java.util.Scanner;
import utils.RandomUtils;
import utils.Input;

public class Baseball {

  final Scanner scanner;

  List<Integer> player;
  List<Integer> computer;

  public Baseball(Scanner scanner) {
    this.scanner = scanner;
  }

  public void playInning() {
    computer = RandomUtils.getRandomNumber();
//    System.out.println(computer);
    while (true) {
      Call call = playRound();
      System.out.println(call);
      if (isGameOver(call)) {
        return;
      }
    }
  }

  public void playGame() {
    while (true) {
      playInning();
      endInning();
      int cmd = scanner.nextInt();
      if (cmd == 2) {
        return;
      }
    }
  }

  private void endInning() {
    System.out.println("3개의 숫자를 모두 맞히셨습니! 게임 종료");
    System.out.println("게임을 새로 시작하려면 1, 종하려면 2를 입력하세요.");
  }

  private static boolean isGameOver(Call call) {
    return call.getStrikes() == 3;
  }

  private Call playRound() {
    player = Input.getUserInput(scanner);
    return Umpire.makeCall(player, computer);
  }

}
