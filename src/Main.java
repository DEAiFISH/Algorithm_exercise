import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String S = scanner.next();
        String T = scanner.next();

        for (int j = 0; j < n; j++) {
            int max = 0;
            for (int i = 0; i < n; i++) {
                if(Math.abs(S.charAt((i + j) % n) - T.charAt(i)) == 32){
                    max++;
                }else{
                    break;
                }
            }
            if(max == n){
                System.out.println("Yes");
                System.out.println(Math.min(j,max - j));
                return;
            }
        }
        System.out.println("No");
    }
}