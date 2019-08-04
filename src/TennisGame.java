public class TennisGame {
    public static final int LOVE = 0;
    public static final int FIFTEEN = 1;
    public static final int THIRTY = 2;
    public static final int FOURTY = 3;

    public static String getScore(String player1Name, String player2Name, int m_score1, int m_score2) {
        String score = "";
        int tempScore = 0;
        boolean isScoreDuece = m_score1 == m_score2;
        if (isScoreDuece) {
            score = getScoreString(m_score1);
            score += m_score1 > FOURTY ? "" : "-All";
        } else {
            boolean isScorePlayerBiggerFourty = m_score1 > FOURTY || m_score2 > FOURTY;
            if (isScorePlayerBiggerFourty) {
                int minusResult = m_score1 - m_score2;
                boolean isAdvantagePlayer1 = minusResult == 1;
                if (isAdvantagePlayer1) score = "Advantage player1";
                else {
                    boolean isAdvantagePlayer2 = minusResult == -1;
                    if (isAdvantagePlayer2) score = "Advantage player2";
                    else {
                        boolean player1Win = minusResult >= 2;
                        if (player1Win) score = "Win for player1";
                        else score = "Win for player2";
                    }
                }
            } else {
                for (int i = 1; i < 3; i++) {
                    boolean isPlayer1 = i == 1;
                    if (isPlayer1) {
                        tempScore = m_score1;
                    }
                    else {
                        score += "-";
                        tempScore = m_score2;
                    }
                    score += getScoreString(tempScore);
                }
            }
        }
        return score;
    }

    private static String getScoreString(int score) {
        String scoreResult;
        switch (score) {
            case LOVE:
                scoreResult = "Love";
                break;
            case FIFTEEN:
                scoreResult = "Fifteen";
                break;
            case THIRTY:
                scoreResult = "Thirty";
                break;
            case FOURTY:
                scoreResult = "Forty";
                break;
            default:
                scoreResult = "Deuce";
                break;
        }
        return scoreResult;
    }
}
