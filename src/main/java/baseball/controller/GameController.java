package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.PlayResult;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import utils.RandomUtils;

public class GameController {

  public static final int MIN_NUMBER = 1;
  public static final int MAX_NUMBER = 9;
  public static final int NUMBER_OF_BALLS = 3;

  private final Scanner scanner;

  public GameController(final Scanner scanner) {
    this.scanner = scanner;
  }

  public void start() {
    boolean isGameOver = false;
    while (!isGameOver) {
      playRound();
      OutputView.printRoundEnded();
      isGameOver = InputView.askIfGameOver();
    }
  }

  private void playRound() {
    Balls computerBalls = generateComputerBalls();
    PlayResult playResult;
    do {
      Balls playerBalls = getPlayerBalls();
      playResult = computerBalls.play(playerBalls);
      OutputView.printPlayResult(playResult);
    } while (!playResult.isGameOver());
  }

  private Balls getPlayerBalls() {
    String inputText = InputView.askForNumbers();
    List<Integer> playerNumbers = mapToIntegers(inputText);
    return new Balls(playerNumbers);
  }

  private List<Integer> mapToIntegers(String text) {
    List<String> digits = Arrays.asList(text.split(""));
    return digits.stream()
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }

  private Balls generateComputerBalls() {
    List<Integer> randomNumbers = getRandomNumbers();
    return new Balls(randomNumbers);
  }

  private List<Integer> getRandomNumbers() {
    List<Integer> numbers = new ArrayList<>();
    while (numbers.size() < NUMBER_OF_BALLS) {
      int number = RandomUtils.nextInt(MIN_NUMBER, MAX_NUMBER);
      if (!numbers.contains(number)) {
        numbers.add(number);
      }
    }
    return numbers;
  }
}
