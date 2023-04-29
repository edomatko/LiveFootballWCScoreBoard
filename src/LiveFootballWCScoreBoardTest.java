import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;

public class LiveFootballWCScoreBoardTest {

    private LiveFootballWCScoreBoard liveScoreBoard;

    @Before
    public void setUp() {
        liveScoreBoard = new LiveFootballWCScoreBoard();
    }

    @Test
    public void teststartNewMatch() {
        liveScoreBoard.startNewMatch("Mexico", "Canada");
        assertEquals(1, liveScoreBoard.getliveScoreBoard().size());
        assertEquals("Mexico", liveScoreBoard.getliveScoreBoard().get(0).getHomeTeam());
        assertEquals("Canada", liveScoreBoard.getliveScoreBoard().get(0).getAwayTeam());
        assertEquals(0, liveScoreBoard.getliveScoreBoard().get(0).getHomeTeamScore());
        assertEquals(0, liveScoreBoard.getliveScoreBoard().get(0).getAwayTeamScore());
    }

    @Test
    public void testUpdateScore() {
        liveScoreBoard.startNewMatch("Mexico", "Canada");
        liveScoreBoard.updateScore(liveScoreBoard.getliveScoreBoard().get(0).getId(), 0, 5);
        assertEquals(0, liveScoreBoard.getliveScoreBoard().get(0).getHomeTeamScore());
        assertEquals(5, liveScoreBoard.getliveScoreBoard().get(0).getAwayTeamScore());
    }

    @Test
    public void testFinishMatch() {
        liveScoreBoard.startNewMatch("Mexico", "Canada");
        liveScoreBoard.startNewMatch("Spain", "Brazil");
        liveScoreBoard.finishMatch(liveScoreBoard.getliveScoreBoard().get(0).getId());
        assertEquals(1, liveScoreBoard.getliveScoreBoard().size());
        liveScoreBoard.finishMatch(liveScoreBoard.getliveScoreBoard().get(0).getId());
        assertTrue(liveScoreBoard.getliveScoreBoard().isEmpty());
    }

    @Test
    public void testGetLiveScoreBoard() {
        liveScoreBoard.startNewMatch("Mexico", "Canada");
        liveScoreBoard.updateScore(liveScoreBoard.getliveScoreBoard().get(0).getId(), 0, 5);

        liveScoreBoard.startNewMatch("Spain", "Brazil");
        liveScoreBoard.updateScore(liveScoreBoard.getliveScoreBoard().get(1).getId(), 10, 2);

        liveScoreBoard.startNewMatch("Germany", "France");
        liveScoreBoard.updateScore(liveScoreBoard.getliveScoreBoard().get(2).getId(), 2, 2);

        liveScoreBoard.startNewMatch("Uruguay", "Italy");
        liveScoreBoard.updateScore(liveScoreBoard.getliveScoreBoard().get(3).getId(), 6, 6);

        liveScoreBoard.startNewMatch("Argentina", "Australia");
        liveScoreBoard.updateScore(liveScoreBoard.getliveScoreBoard().get(4).getId(), 3, 1);

        List<LiveMatch> liveScoreBoardList = liveScoreBoard.getliveScoreBoard();

        assertEquals(5, liveScoreBoardList.size());

        assertEquals("Uruguay", liveScoreBoardList.get(0).getHomeTeam());
        assertEquals("Italy", liveScoreBoardList.get(0).getAwayTeam());
        assertEquals(6, liveScoreBoardList.get(0).getHomeTeamScore());
        assertEquals(6, liveScoreBoardList.get(0).getAwayTeamScore());

        assertEquals("Spain", liveScoreBoardList.get(1).getHomeTeam());
        assertEquals("Brazil", liveScoreBoardList.get(1).getAwayTeam());
        assertEquals(10, liveScoreBoardList.get(1).getHomeTeamScore());
        assertEquals(2, liveScoreBoardList.get(1).getAwayTeamScore());

        assertEquals("Mexico", liveScoreBoardList.get(2).getHomeTeam());
        assertEquals("Canada", liveScoreBoardList.get(2).getAwayTeam());
        assertEquals(0, liveScoreBoardList.get(2).getHomeTeamScore());
        assertEquals(5, liveScoreBoardList.get(2).getAwayTeamScore());

        assertEquals("Argentina", liveScoreBoardList.get(3).getHomeTeam());
        assertEquals("Australia", liveScoreBoardList.get(3).getAwayTeam());
        assertEquals(3, liveScoreBoardList.get(3).getHomeTeamScore());
        assertEquals(1, liveScoreBoardList.get(3).getAwayTeamScore());

        assertEquals("Germany", liveScoreBoardList.get(4).getHomeTeam());
        assertEquals("France", liveScoreBoardList.get(4).getAwayTeam());
        assertEquals(2, liveScoreBoardList.get(4).getHomeTeamScore());
        assertEquals(2, liveScoreBoardList.get(4).getAwayTeamScore());
    }
}
