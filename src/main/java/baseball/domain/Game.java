package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import utils.RandomUtils;

public class Game {

  public static final int MIN_NUMBER = 1;
  public static final int MAX_NUMBER = 9;
  public static final int NUMBER_OF_BALLS = 3;

  private Balls computerBalls;
  private Balls playerBalls;
  private boolean isGameOver;
  private final Scanner scanner;

  public Game(final Scanner scanner) {
    this.scanner = scanner;
    isGameOver = false;
  }

  public void play() {
    while (!isGameOver) {
      playRound();
      askIfGameOver();
    }
  }

  private void askIfGameOver() {
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    int input = scanner.nextInt();
    if (input == 2) {
      isGameOver = true;
    }
  }

  private void playRound() {
    computerBalls = getRandomBalls();
//    System.out.println("컴퓨터: " + computerBalls);
    PlayResult playResult = new PlayResult();
    while (!playResult.isGameOver()) {
      Balls player = getBallsFromUserInput();
      playResult = player.play(computerBalls);
      System.out.println(playResult);
    }
    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
  }

  private Balls getRandomBalls() {
    List<Integer> numbers = new ArrayList<>();
    while (numbers.size() < NUMBER_OF_BALLS) {
      int number = RandomUtils.nextInt(MIN_NUMBER, MAX_NUMBER);
      if (!numbers.contains(number)) {
        numbers.add(number);
      }
    }
    return new Balls(numbers);
  }

  private List<Integer> mapToIntegers(String text) {
    List<String> digits = Arrays.asList(text.split(""));
    return digits.stream()
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }

  private Balls getBallsFromUserInput() {
    System.out.print("숫자를 입력해 주세요 : ");
    String text = scanner.next();
    List<Integer> integers = mapToIntegers(text);
    return new Balls(integers);
  }
}
