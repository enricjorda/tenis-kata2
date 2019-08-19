
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
        if (playerOneScore == playerTwoScore)
            return getTiedScore();
        else if (playerOneScore >= 4 || playerTwoScore >= 4)
            return getScoreOver40();
        else
            return getStandardScore();
    }

    private String getStandardScore() {
        String score = convertScoreToString( playerOneScore);
        score += "-";
        score += convertScoreToString( playerTwoScore);

        return score;
    }

    private String convertScoreToString(int playerScore) {
        String[] scores = new String[] {"Love", "Fifteen","Thirty","Forty"};
        return scores[playerScore];
    }

    private String getScoreOver40() {
        int scoreDifference = playerOneScore - playerTwoScore;
        if (scoreDifference == 1) {
            return "Advantage player1";
        } else if (scoreDifference == -1) {
            return "Advantage player2";
        } else if (scoreDifference >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    private String getTiedScore() {
        switch (playerOneScore) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }
}
