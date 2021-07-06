package baseball.domain;

import java.util.List;

public class Umpire {

  public static Call makeCall(List<Integer> player, List<Integer> computer) {
    int balls = callBalls(player, computer);
    int strikes = callStrikes(player, computer);
    return new Call(balls, strikes);
  }

  private static int callStrikes(List<Integer> player, List<Integer> computer) {
    int strikes = 0;
    for (int i = 0; i < player.size(); i++) {
      strikes = updateStrikes(player.get(i), computer.get(i), strikes);
    }
    return strikes;
  }

  private static int updateStrikes(int playerNumber, int computerNumber, int strikes) {
    if (playerNumber == computerNumber) {
      strikes += 1;
    }
    return strikes;
  }

  private static int callBalls(List<Integer> player, List<Integer> computer) {
    int correct = getCorrect(player, computer);
    int strikes = callStrikes(player, computer);
    return correct - strikes;
  }

  private static int getCorrect(List<Integer> player, List<Integer> computer) {
    int correct = 0;
    for (int number : player) {
      correct = updateCorrect(correct, number, computer);
    }
    return correct;
  }

  private static int updateCorrect(int correct, int number, List<Integer> computer) {
    if (!computer.isEmpty() && computer.contains(number)) {
      correct += 1;
    }
    return correct;
  }
}
