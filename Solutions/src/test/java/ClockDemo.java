public class ClockDemo {
    public static void main(String[] args) {
        System.out.println(Clock.Angle(14, 1));
    }
}

class Clock {
    private static float hhAngle = 360 / 12; // 时针1h走的度数
    private static float hmAngle = hhAngle / 60; // 时针1m走的度数
    private static float mmAngle = 360 / 60; // 分针1m走的度数

    public static float Angle(float h, float m) {
        return Math.abs(mmAngle * m % 360 - (h * hhAngle + m * hmAngle) % 360);
    }
}
