package otherclassic.Astar寻路算法;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * {@题：从一个点到另一个点，中途有障碍物}
 * 1. 地图：用矩阵表示
 * 1. A星寻路的思路：启发式搜索 f = g + h
 * f：起点到终点的代价
 * g：起点到当前点的代价
 * h：当前点到终点的预估代价——忽略障碍并且只算直线距离（Astar算法可以走斜线，这里的预估就是不考虑斜线只考虑直线）
 * <p>
 * {@关键：根据上述思路，用bfs，向外扩散一圈（走一步）后，不是对每个点都进行扩散，而是找到这一圈中最小的f，从该点再进行扩散（第一步中扩散的其他点不动），然后依次类推，对于一个可以到达的、且已经在priorityQueue中的点，如果从当前点到达的g更小，则要更新该点的g}
 *
 * @unchckedr
 */
public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("E:\\Everett\\OneDrive - std.uestc.edu.cn\\Data\\leecode\\LeecodeSolutions\\src\\main\\java\\otherclassic.Astar寻路算法\\input.txt"));
        String matrixInput = scanner.nextLine();
        String[] line = matrixInput.split(";");
        int row = line.length, col = line[0].split(",").length;
        int[][] matrix = new int[row][col];
        for (int i = 0; i < line.length; i++) {
            String[] split = line[i].split(",");
            for (int j = 0; j < split.length; j++) {
                matrix[i][j] = Integer.parseInt(split[j]);
            }
        }
        if (matrix[0][0] == 0 || matrix[row - 1][col - 1] == 0) {
            System.out.println(0);
            return;
        }
        /*******以上处理完输入*********/
        System.out.println(new Solution().bfs(matrix, 0, 0, row - 1, col - 1));
    }

    private int bfs(int[][] map, int sx, int sy, int ex, int ey) {
        Point start = new Point(sx, sy, ex, ey);
        Point end = new Point(ex, ey, ex, ey);
        start.past = 1;
        start.total = start.past + start.future;

        SortedQueue<Point> priorityQueue = new SortedQueue<>((x, y) -> x.future - y.future);
        HashSet<Point> visited = new HashSet<>();
        priorityQueue.add(start);
        int[][] adjacent = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!priorityQueue.isEmpty()) {
            Point currentPoint = priorityQueue.poll();   // 每次只取到终点的预估值最小的
            visited.add(currentPoint);
            if (currentPoint.equals(end)) return currentPoint.total;
            for (int i = 0; i < adjacent.length; i++) { // 从该点进行扩散
                int x = adjacent[i][0] + currentPoint.x;
                int y = adjacent[i][1] + currentPoint.y;
                Point tryNext = new Point(x, y, ex, ey);
                tryNext.parent = currentPoint;
                tryNext.past = currentPoint.past + 1;
                tryNext.total = tryNext.past + tryNext.future;
                if (isArrivable(tryNext, map, visited)) {
                    if (tryNext.equals(end)) return tryNext.total;  // 这里提高效率
                    // 这里需要考虑past是因为并没有一层一层往外面扩散，所以如果是单纯的bfs，就不需要考虑这个问题
                    if (priorityQueue.contains(tryNext) && priorityQueue.get(tryNext).past > tryNext.past) {    // 判断是否需要更新父节点，即：从当前节点到next是否更近
                        priorityQueue.remove(tryNext);  // 删除旧的，因为equal只用到了x,y，所以可以用此法
                        priorityQueue.add(tryNext);
                    } else priorityQueue.add(tryNext);
                }
            }
        }
        return 0;
    }

    private boolean isArrivable(Point point, int[][] map, HashSet<Point> visited) {
        int x = point.x;
        int y = point.y;
        return x >= 0 && y >= 0 && x < map.length && y < map[x].length && !visited.contains(point) && map[x][y] == 1;
    }
}

class Point {
    int x, y;   // 横纵坐标
    Point parent;   // 记录从哪个点过来的，用以追溯路径
    int total, past, future;    // 经过当前点，起点到终点的代价；起点到当前点的代价；当前点到终点的预估直线代价

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, int endx, int endy) {
        this(x, y);
        this.future = Math.abs(endx - x) + Math.abs(endy - y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class SortedQueue<T> {
    private TreeSet<T> q;
    private HashMap<T, T> map;

    public SortedQueue(Comparator<T> comparator) {
        q = new TreeSet<>(comparator);
        map = new HashMap<>();
    }

    public T get(T p) {
        return map.get(p);
    }

    public void add(T p) {
        q.add(p);
        map.put(p, p);
    }

    public T first() {
        if (q.isEmpty() || map.isEmpty()) return null;
        T first = q.first();
        return first;
    }

    public T last() {
        return q.last();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public T poll() {
        T r = this.remove(q.first());
        return r;
    }

    public boolean contains(T o) {
        return map.containsKey(o);
    }

    public T remove(T p) {
        if (!map.containsKey(p)) return null;
        T remove = map.remove(p);
        q.remove(p);
        return remove;
    }
}