import java.util.Scanner;

/**
 *  扫雷
 */
public class Minesweeper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = 0;
        int N;
        int M;
        while ((N = scanner.nextInt()) != 0 && (M = scanner.nextInt()) != 0) {
            x++;
            scanner.nextLine();
            char[][] map = new char[N][M];
            for (int i = 0; i < N; i++) {
                map[i] = scanner.nextLine().toCharArray();
            }
            map = setMap(map);
            System.out.println("Field #" + x  + ":");
            for (char[] ch : map) {
                for (char c : ch) {
                    System.out.print(c);
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    private static char[][] setMap(char[][] map) {
        char[][] setMap = new char[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                setMap[i][j] = '0';
            }
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == '*') {
                    setMap[i][j] = '*';
                    if (i - 1 >= 0) { // 上
                        if (j - 1 >= 0 && setMap[i - 1][j - 1] != '*') { // 左上
                            ++setMap[i - 1][j - 1];
                        }
                        if (j + 1 < map[0].length && setMap[i - 1][j + 1] != '*') { // 右上
                            ++setMap[i - 1][j + 1];
                        }
                        if (setMap[i - 1][j] != '*') { // 上
                            ++setMap[i - 1][j];
                        }
                    }
                    if (j + 1 < map[0].length) { // 右
                        if (i + 1 < map.length && setMap[i + 1][j + 1] != '*') { // 右下
                            ++setMap[i + 1][j + 1];
                        }
                        if (setMap[i][j + 1] != '*') { // 右
                            ++setMap[i][j + 1];
                        }
                    }
                    if (i + 1 < map.length) { // 下
                        if (j - 1 >= 0 && setMap[i + 1][j - 1] != '*') { // 左下
                            ++setMap[i + 1][j - 1];
                        }
                        if (setMap[i + 1][j] != '*') { // 下
                            ++setMap[i + 1][j];
                        }
                    }
                    if (j - 1 >= 0 && setMap[i][j - 1] != '*') { // 左
                        ++setMap[i][j - 1];
                    }
                }
            }
        }
        return setMap;
    }
}