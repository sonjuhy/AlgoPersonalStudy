package programmers;

public class PG_92344 {
    public static void main(String[] args) {
        int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        int[][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
        System.out.println(solution(board, skill));
    }
    public static int solution(int[][] board, int[][] skill){
        int aliveBuilding = board.length * board[0].length;

        for (int[] ints : skill) {
            int type = ints[0];
            int r1 = ints[1];
            int c1 = ints[2];
            int r2 = ints[3];
            int c2 = ints[4];
            int degree = ints[5];

            if (type == 1) { // attack
                degree *= -1;
            }
            for (int r = r1; r <= r2; r++) { // y
                for (int c = c1; c <= c2; c++) {
                    int tmp = board[r][c] + degree;
                    if(board[r][c] > 0 && tmp <= 0){
                        aliveBuilding--;
                    }
                    else if(board[r][c] <=0 && tmp > 0){
                        aliveBuilding++;
                    }
                    board[r][c] += degree;
                }
            }
        }
        return aliveBuilding;
    }
}
