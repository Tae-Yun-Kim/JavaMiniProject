package minix6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

class RandomTeamFormationStrategy implements TeamFormationStrategy {
    @Override
    public List<List<Player>> formTeams(List<Player> players, int teamSize) {
        // 점수를 기준으로 플레이어 정렬 (내림차순)
        players.sort(Comparator.comparingInt(Player::getScore).reversed());

        // 그룹화: teamSize에 맞춰 상위 순위부터 그룹을 나누기
        List<List<Player>> rankGroups = new ArrayList<>();
        int numGroups = (int) Math.ceil((double) players.size() / teamSize);
        
        for (int i = 0; i < numGroups; i++) {
            int startIdx = i * teamSize;
            int endIdx = Math.min(startIdx + teamSize, players.size());
            rankGroups.add(new ArrayList<>(players.subList(startIdx, endIdx)));
        }

        // 팀 구성
        List<List<Player>> teams = new ArrayList<>();
        Random random = new Random();

        // 그룹이 남아있는 동안 팀 구성
        while (!rankGroups.isEmpty()) {
            List<Player> team = new ArrayList<>();

            for (int i = 0; i < rankGroups.size(); i++) {
                List<Player> group = rankGroups.get(i);

                if (!group.isEmpty()) {
                    // 무작위로 한 명 선택하여 팀에 추가
                    int randomIndex = random.nextInt(group.size());
                    team.add(group.remove(randomIndex));
                }

                // 그룹이 비어 있으면 제거
                if (group.isEmpty()) {
                    rankGroups.remove(i);
                    i--; // 인덱스 조정
                }
            }

            if (!team.isEmpty()) {
                teams.add(team);
            }
        }

        return teams;
    }
}


