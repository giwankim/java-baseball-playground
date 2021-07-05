package baseball.domain;

import java.util.List;

public class Umpire {

  List<Integer> computer;

  public Umpire(List<Integer> _computer) {
    this.computer = _computer;
  }

  public int callStrikes(int[] player) {
    int strikes = 0;
    for (int i = 0; i < player.length; i++) {
      strikes = callStrike(player[i], computer.get(i), strikes);
    }
    return strikes;
  }

  private int callStrike(int playerNumber, int computerNumber, int strikes) {
    if (playerNumber == computerNumber) {
      strikes += 1;
    }
    return strikes;
  }

  public int callBalls(int[] player) {
    int numberOfCorrect = getNumberOfCorrect(player);
    int strikes = callStrikes(player);
    return numberOfCorrect - strikes;
  }

  private int getNumberOfCorrect(int[] player) {
    int correct = 0;
    for (int number : player) {
      if (computer.contains(number)) {
        correct += 1;
      }
    }
    return correct;
  }
}
