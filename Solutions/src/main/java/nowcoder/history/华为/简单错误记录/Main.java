package nowcoder.history.华为.简单错误记录;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static class ErrorRecord implements Comparable<ErrorRecord> {
        String fullName;
        String simpleName;
        int lineNo;
        int counter;
        int appearIndex;    // 一个比较巧妙的点是把index记录在数据本身

        public ErrorRecord(String pathName, int lineNo) {
            this.lineNo = lineNo;
            this.counter = 1;
            this.fullName = toFileName(pathName);
            this.simpleName = simplifyName(this.fullName);
        }

        private String toFileName(String pathName) {
            String[] split = pathName.split("\\\\");
            int ln = split.length;
            return split[ln - 1];
        }

        private String simplifyName(String fullName) {
            int ln = fullName.length();
            if (ln > 16) return fullName.substring(fullName.length() - 16);
            return fullName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ErrorRecord that = (ErrorRecord) o;
            return fullName.equals(that.fullName) &&
                    lineNo == that.lineNo;
        }

        @Override
        public int hashCode() {
            return Objects.hash(fullName, lineNo);
        }

        @Override
        public int compareTo(ErrorRecord o) {
            if (this.counter == o.counter) {
                return this.appearIndex - o.appearIndex;
            } else return -1 * (this.counter - o.counter);
        }

        @Override
        public String toString() {
            return simpleName + " " + lineNo + " " + counter;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<ErrorRecord, Integer> map = new HashMap<>();
        int index = 0;
        while (scanner.hasNext()) {
            String pathName = scanner.next();
            if ("exit".equals(pathName)) break;
            int lineNo = scanner.nextInt();
            ErrorRecord record = new ErrorRecord(pathName, lineNo);
            if (map.containsKey(record)) {
                map.put(record, map.get(record) + 1);
            } else {
                record.appearIndex = index++;
                map.put(record, 1);
            }
            /**
             * {@注意map的更新机制，如果key判断相等，执行更新操作，此时key是不会重新放的，而是使用旧的key}
             */
        }
        scanner.close();
        ErrorRecord[] r = new ErrorRecord[map.size()];
        for (ErrorRecord record : map.keySet()) {
            record.counter = map.get(record);
            r[record.appearIndex] = record;
        }
        Arrays.sort(r);
        for (int i = 0; i < r.length && i < 8; i++) System.out.println(r[i]);
    }
}
