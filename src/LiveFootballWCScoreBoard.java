import java.util.*;

public class LiveFootballWCScoreBoard {
    private Map<Integer, LiveMatch> liveMatches;
    private List<LiveMatch> liveScoreBoard;

    public LiveFootballWCScoreBoard() {
        liveMatches = new HashMap<>();
        liveScoreBoard = new ArrayList<>();
    }

    public void startNewMatch(String homeTeam, String awayTeam) {
        LiveMatch match = new LiveMatch(homeTeam, awayTeam);
        liveMatches.put(match.getId(), match);
        liveScoreBoard.add(match);
        Collections.sort(liveScoreBoard);
    }

    public void updateScore(int matchId, int homeScore, int awayScore) {
        LiveMatch match = liveMatches.get(matchId);
        match.updateScore(homeScore, awayScore);
        Collections.sort(liveScoreBoard);
    }

    public void finishMatch(int matchId) {
        LiveMatch match = liveMatches.remove(matchId);
        liveScoreBoard.remove(match);
    }

    public List<LiveMatch> getliveScoreBoard() {
        return liveScoreBoard;
    }

    public static void main(String[] args) {
        LiveFootballWCScoreBoard scoreboard = new LiveFootballWCScoreBoard();
        Scanner getInput = new Scanner(System.in);

        while (true) {
            System.out.println("Enter option number:");
            System.out.println("1. Start a new match");
            System.out.println("2. Update score");
            System.out.println("3. Finish a match");
            System.out.println("4. Get live score board of matches in progress");
            System.out.println("5. Exit");

            int option = getInput.nextInt();
            getInput.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Enter home team name:");
                    String homeTeam = getInput.nextLine();
                    System.out.println("Enter away team name:");
                    String awayTeam = getInput.nextLine();
                    scoreboard.startNewMatch(homeTeam, awayTeam);
                    break;

                case 2:
                    System.out.println("Enter match ID:");
                    int matchId = getInput.nextInt();
                    System.out.println("Enter home team score:");
                    int homeScore = getInput.nextInt();
                    System.out.println("Enter away team score:");
                    int awayScore = getInput.nextInt();
                    getInput.nextLine();
                    scoreboard.updateScore(matchId, homeScore, awayScore);
                    break;

                case 3:
                    System.out.println("Enter match ID:");
                    matchId = getInput.nextInt();
                    scoreboard.finishMatch(matchId);
                    break;

                case 4:
                    List<LiveMatch> liveScoreBoard = scoreboard.getliveScoreBoard();
                    System.out.println("Matches in progress:");
                    for (LiveMatch match : liveScoreBoard) {
                        System.out.println(match);
                    }
                    break;
                case 5:
                    getInput.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}

class LiveMatch implements Comparable<LiveMatch> {
    private static int nextId = 1;

    private int id;
    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;

    public LiveMatch(String homeTeam, String awayTeam) {
        this.id = nextId++;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = 0;
        this.awayScore = 0;
    }

    public int getId() {
        return id;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getHomeTeamScore() {
        return homeScore;
    }

    public int getAwayTeamScore() {
        return awayScore;
    }

    public void updateScore(int homeScore, int awayScore) {
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    public int getTotalScore() {
        return homeScore + awayScore;
    }

    public int compareTo(LiveMatch other) {
        int result = Integer.compare(other.getTotalScore(), this.getTotalScore());
        if (result == 0) {
            result = Integer.compare(other.id, this.id);
        }
        return result;
    }

    @Override
    public String toString() {
        return "Match " + id + ": " + homeTeam + " vs " + awayTeam + ", Score: " + homeScore + " - " + awayScore;
    }
}
