import java.util.*;

    class Solution {
        public int solution(int n, int s, int a, int b, int[][] fares) {
            int answer = 0;

            //  1. 거대한 숲(그래프) 만들기 (객체 다이어트: int[] 배열 사용)
            List<int[]>[] graph = new ArrayList[n+1];
            for (int i=0; i<=n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int[] fare : fares) {
                int u = fare[0];
                int v = fare[1];
                int cost = fare[2];
                // 양방향 통행이므로 양쪽 모두 연결해 줍니다.
                graph[u].add(new int[]{v, cost});
                graph[v].add(new int[]{u, cost});
            }

            //  2. 다익스트라 3번 발싸! (각각 S, A, B에서 출발하는 모든 최단 거리 지도)
            int[] distS = dijkstra(n, s, graph);
            int[] distA = dijkstra(n, a, graph);
            int[] distB = dijkstra(n, b, graph);

            //  최적의 합승 지점(X) 찾기
            answer = Integer.MAX_VALUE;
            for (int i=1; i<=n; i++) {
                //  경로가 끊겨있지 않은 경우에만 계산
                if (distS[i] != Integer.MAX_VALUE && distA[i] != Integer.MAX_VALUE && distB[i] != Integer.MAX_VALUE) {
                    answer = Math.min(answer, distS[i] + distA[i] + distB[i]);
                }
            }

            return answer;
        }

        //  다익스트라의 심장: 출발점에서 다른 모든 지점깢의 최단 거리를 구한 함수
        public int[] dijkstra(int n, int start, List<int[]>[] graph) {
            int[] dist = new int[n+1];
            Arrays.fill(dist, Integer.MAX_VALUE);   // 처음엔 전부 무한대(접근 불가)로 세팅
            dist[start] = 0;    // 내 위치는 비용 0

            //  우선순위 큐: {현재 노드, 현재까지 누적된 최소비용}
            //  비용이 '가장 싼' 경로를 먼저 뽑아내기 위한 정렬 기준!
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o->o[1]));
            pq.add(new int[]{start, 0});

            while (!pq.isEmpty()) {
                int[] current = pq.poll();
                int curNode = current[0];
                int curCost = current[1];

                //  [핵심] 큐에서 꺼낸 비용이, 이미 기록된 최단 거리보다 비싸다면? -> 쓸모없는 정보이므로 스킵!
                if (curCost > dist[curNode]) continue;

                //  현재 노드와 연결된 이웃들을 모두 살펴봅니다.
                for (int[] edge : graph[curNode]) {
                    int nextNode = edge[0];
                    int nextCost = edge[1];

                    //  (내가 여기까지 온 비용 + 이웃으로 가는 비용)이 (기존에 알려진 이웃의 최단 거리)보다 싸다면?
                    if (dist[nextNode] > curCost + nextCost) {
                        dist[nextNode] = curCost + nextCost;
                        pq.add(new int[] {nextNode, dist[nextNode]});
                    }
                }
            }

            return dist;
        }

    }