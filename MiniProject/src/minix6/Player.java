package minix6;

class Player {
    private String name; // 이름 필드
    private int score;   // 점수 필드

    public Player(String name, int score) {
        this.name = name;  // 이름 초기화
        this.score = score; // 점수 초기화
    }

    // 이름을 반환하는 getter
    public String getName() {
        return name;
    }

    // 점수를 반환하는 getter
    public int getScore() {
        return score;
    }
}