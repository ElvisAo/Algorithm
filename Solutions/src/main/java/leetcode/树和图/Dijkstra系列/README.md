# 关于dijkstra的总结

- 使用场景：dijkstra主要用于求图中某个点到其他点的最值问题，包括但不限于有向图的最短路径。

    - 只要加入新的边使原来从起点到新点的某种值增加，就可以使用dijkstra求最小值（如网络延迟时间和最小体力消耗路径）

    - 只要加入新的边使原来从起点到新点的某种值减小，就可以使用dijkstra求最大值（如概率最大的路径）

- 步骤：

    - 根据边权信息构建邻接表：即List<int[]>[] graph = new LinkedList\[n\]; 这里的n是顶点个数，数组int[]是二维数组{toVex, weight}，表示某个顶点到其他顶点的花费

    - 使用dijkstra算法求最值：

        - 定义状态类

            ```java
            import lombok.*;
            
            @AllArgsConstructor
            class State{
                int nodeId;     // 如果是在矩阵中，就写为int x, y;
                int costFromStart;
            } 
            ```

        - 创建起点到其他点的花费数组并根据情况初始化（这里以求单源最短路径为例）
          ```java
          int[] costTo = new int[n];   //这里n为顶点个数
          Arrays.fill(costTo, Integer.MAX_VALUE);   //因为是求最小值，所以初始化为最大值
          costTo[start] = 0;    // 对出发点根据具体情况进行处理
          ```
          
        - 使用优先队列来使用贪心算法
            ```java
            PriorityQueue<State> pq = new PriorityQueue<>();
            ```
          
        - 然后使用bfs
            ```java
            pq.offer(new State(start, 0));
            while(!pq.isEmpty()){
                State cur = pq.poll();
                int curId = cur.id;
                int curCostFromStart = cur.costFromStart;
                // 判断是否到达终点
                if(curId == end) return curCostFromStart;
                // 如果已经求出了更小的值，放弃本次修改。具体根据求的是最小值还是最大值对条件的判断可能有所不同
                if(curCostFromStart > costTo[curId]) continue;
                // bfs遍历相邻节点
                for(int[] next:graph[curId]){
                    int nextId = next[0];
                    int weight = curCostFromStart + next[1];
                    if(weight < costTo[nextId]){
                        costTo[nextId] = weight;
                        pq.offer(new State(nextId, weight));
                    }
                } 
            }
           return -1;   // 根据具体情况返回某个表示“不可能”的值
            ```