package baseball;

import baseball.controller.GameController;

import java.util.Scanner;

public class Application {

  public static void main(String[] args) {
    final Scanner scanner = new Scanner(System.in);
    GameController gameController = new GameController(scanner);
    gameController.start();
  }
}
