
public class TennisGame1 implements TennisGame {

    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) {
            playerOneScore += 1;
        } else {
            playerTwoScore += 1;
        }
    }

    public String getScore() {
        if (isScoreTied())
            return getTiedScore();
        else if (isPlayerScoreOverForty())
            return getScoreOver40();
        else
            return getStandardScore();
    }

    private boolean isPlayerScoreOverForty() {
        return playerOneScore >= 4 || playerTwoScore >= 4;
    }

    private boolean isScoreTied() {
        return playerOneScore == playerTwoScore;
    }

    private String getStandardScore() {
        String score = convertScoreToString(playerOneScore);
        score += "-";
        score += convertScoreToString(playerTwoScore);

        return score;
    }

    private String convertScoreToString(int playerScore) {
        String[] scores = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        return scores[playerScore];
    }

    private String getScoreOver40() {
        if (hasPlayerOneAdvantage()) {
            return "Advantage player1";
        } else if (hasPlayerTwoAdvantage()) {
            return "Advantage player2";
        } else if (isPlayerOneWinning()) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    private boolean isPlayerOneWinning() {
        int scoreDifference = playerOneScore - playerTwoScore;
        return scoreDifference >= 2;
    }

    private boolean hasPlayerOneAdvantage() {
        int scoreDifference = playerOneScore - playerTwoScore;
        return scoreDifference == 1;
    }

    private boolean hasPlayerTwoAdvantage() {
        int scoreDifference = playerOneScore - playerTwoScore;
        return scoreDifference == -1;
    }

    private String getTiedScore() {
        String[] scores = new String[]{"Love-All", "Fifteen-All", "Thirty-All"};
        if (playerOneScore > 2 )
            return "Deuce";
        return scores[playerOneScore];
    }
}
