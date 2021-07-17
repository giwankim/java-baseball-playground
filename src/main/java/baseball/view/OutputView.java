package baseball.view;

import baseball.domain.PlayResult;

public class OutputView {

  public static final String END_OF_ROUND_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
  public static final String NOTHING = "낫싱";
  public static final String BALL = "볼 ";
  public static final String STRIKE = "스트라이크";

  public static void printPlayResult(PlayResult playResult) {
    if (playResult.isNothing()) {
      System.out.println(NOTHING);
      return;
    }
    StringBuilder stringBuilder = new StringBuilder();
    int strikes = playResult.getStrikes();
    int balls = playResult.getBalls();
    if (balls > 0) {
      stringBuilder.append(balls);
      stringBuilder.append(BALL);
    }
    if (strikes > 0) {
      stringBuilder.append(strikes);
      stringBuilder.append(STRIKE);
    }
    System.out.println(stringBuilder);
  }

  public static void printRoundEnded() {
    System.out.println(END_OF_ROUND_MESSAGE);
  }
}
