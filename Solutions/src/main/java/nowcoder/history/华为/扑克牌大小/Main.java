package nowcoder.history.华为.扑克牌大小;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String r;
        while (scanner.hasNext()) {
            String[] pokers = scanner.nextLine().split("-");
            String[] f = pokers[0].split(" ");
            String[] s = pokers[1].split(" ");
            if (pokers[0].contains("joker JOKER") || pokers[1].contains("joker JOKER")) r = "joker JOKER";
            else if (f.length == 4 && s.length != 4) r = pokers[0];
            else if (f.length != 4 && s.length == 4) r = pokers[1];
            else if (f.length == s.length) {
                if (indexOf(f[0]) > indexOf(s[0])) r = pokers[0];
                else r = pokers[1];
            } else {
                r = "ERROR";
            }
            System.out.println(r);
        }
    }

    private static int indexOf(String c) {
        return "345678910JQKA2".indexOf(c);
    }
}
