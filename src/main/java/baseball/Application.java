package baseball;

import baseball.domain.Game;

import java.util.Scanner;

public class Application {

  public static void main(String[] args) {
    final Scanner scanner = new Scanner(System.in);
    Game game = new Game(scanner);
    game.play();
  }
}
