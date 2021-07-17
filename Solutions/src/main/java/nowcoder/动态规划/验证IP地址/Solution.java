package nowcoder.动态规划.验证IP地址;

public class Solution {
    public static void main(String[] args) {
        String IP = "192.168.0.1.";
        System.out.println(new Solution().solution_1(IP));
    }

    public String solution_1(String IP) {
        String r = "Neither";
        char cs = IP.charAt(0), ce = IP.charAt(IP.length() - 1);
        if (cs == '.' || cs == ':' || ce == '.' || ce == ':') return r;
        if (IP.contains(".")) {
            String[] split = IP.split("\\.");
            if (split.length != 4) return r;
            for (int i = 0; i < 4; i++) {
                if (split[i].length() > 3 || (split[i].length() > 1 && split[i].charAt(0) == '0')) return r;
                try {
                    int seg = Integer.parseInt(split[i]);
                    if (seg <= 255 && seg >= 0) continue;
                    else return r;
                } catch (Exception e) {
                    return r;
                }
            }
            r = "IPv4";
        } else if (IP.contains(":")) {
            String[] split = IP.split("\\:");
            if (split.length != 8) return r;
            for (int i = 0; i < 8; i++) {
                if (split[i].length() > 4 || split[i].length() == 0) return r;
                try {
                    int seg = Integer.parseInt(split[i], 16);
                } catch (Exception e) {
                    return r;
                }
            }
            r = "IPv6";
        }
        return r;
    }
}
