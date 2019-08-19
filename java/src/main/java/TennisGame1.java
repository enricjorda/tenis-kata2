
public class TennisGame1 implements TennisGame {

    private final Player player1;
    private final Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name, 0);
        this.player2 = new Player(player2Name, 0);
    }

    public void wonPoint(String playerName) {
        if (player1.isCalled(playerName)) {
            player1.addOnePoint();
        } else {
            player2.addOnePoint();
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
        return player1.getPlayerScore() >= 4 || player2.getPlayerScore() >= 4;
    }

    private boolean isScoreTied() {
        return player1.getPlayerScore() == player2.getPlayerScore();
    }

    private String getStandardScore() {
        return player1.getStringScore()+"-"+player2.getStringScore();
    }

    private String getScoreOver40() {
        if(isAdvantage())
            return (player1.getPlayerScore() > player2.getPlayerScore()) ? "Advantage player1" : "Advantage player2";
        else
            return (player1.getPlayerScore() > player2.getPlayerScore()) ? "Win for player1" : "Win for player2";
    }

    private boolean isAdvantage() {
        int scoreDifference = player1.getPlayerScore() - player2.getPlayerScore();
        return Math.abs(scoreDifference)== 1;
    }

    private String getTiedScore() {
        String[] scores = new String[]{"Love-All", "Fifteen-All", "Thirty-All"};
        if (player1.getPlayerScore() > 2 )
            return "Deuce";
        return scores[player1.getPlayerScore()];
    }
}
