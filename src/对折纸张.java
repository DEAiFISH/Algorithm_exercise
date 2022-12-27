import java.util.Scanner;

public class 对折纸张 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        String s = scan.nextLine();
        switch (s) {
            case "A0":
                System.out.println("1189\n841");
                break;
            case "A1":
                System.out.println("841\n594");
                break;
            case "A2":
                System.out.println("594\n420");
                break;
            case "A3":
                System.out.println("420\n297");
                break;
            case "A4":
                System.out.println("297\n210");
                break;
            case "A5":
                System.out.println("210\n148");
                break;
            case "A6":
                System.out.println("148\n105");
                break;
            case "A7":
                System.out.println("105\n74");
                break;
            case "A8":
                System.out.println("74\n52");
                break;
            case "A9":
                System.out.println("52\n37");
                break;
            default:
        }
        scan.close();
    }
}
