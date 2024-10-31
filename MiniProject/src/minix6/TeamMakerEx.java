package minix6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeamMakerEx {
    private final TeamFormationStrategy strategy;

    public TeamMakerEx(TeamFormationStrategy strategy) {
        this.strategy = strategy;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        List<Player> players = new ArrayList<>();

        // 총 인원 수 입력
        System.out.print("총 인원 수를 입력하세요: ");
        int totalPlayers = scanner.nextInt();
        scanner.nextLine();

        // 플레이어 이름과 점수 입력
        for (int i = 0; i < totalPlayers; i++) {
            System.out.print("플레이어 " + (i + 1) + "의 이름을 입력하세요: ");
            String name = scanner.nextLine();
            System.out.print("플레이어 " + (i + 1) + "의 점수를 입력하세요: ");
            int score = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 처리
            players.add(new Player(name, score)); // 플레이어 객체 생성
        }

        // 팀당 인원 수 입력
        System.out.print("몇팀으로 나눌지 입력하세요: ");
        int teamSize = scanner.nextInt();
        scanner.nextLine();

        // 전략에 따라 팀 구성
        List<List<Player>> teams = strategy.formTeams(players, teamSize);

        // 결과 출력
        System.out.println("\n구성된 팀:");
        for (int i = 0; i < teams.size(); i++) {
            System.out.println("팀 " + (i + 1) + ":");
            for (Player player : teams.get(i)) {
                System.out.println("  이름: " + player.getName() + ", 점수: " + player.getScore());
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        // RandomTeamFormationStrategy 사용
        TeamFormationStrategy strategy = new RandomTeamFormationStrategy();
        TeamMakerEx teamMaker = new TeamMakerEx(strategy);
        teamMaker.start();
    }
}