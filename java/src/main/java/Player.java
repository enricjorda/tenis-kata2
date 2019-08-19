public class Player {

    private final String playerName;
    private int playerScore;

    public Player(String playerName, int playerScore) {
        this.playerName = playerName;
        this.playerScore = playerScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void addOnePoint() {
        this.playerScore += 1;
    }

    public Boolean isCalled(String playerName) {
        return this.playerName.equals(playerName);
    }

    public String getStringScore() {
        String[] scores = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        return scores[playerScore];
    }
}