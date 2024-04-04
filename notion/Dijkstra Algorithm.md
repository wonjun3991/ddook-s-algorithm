# Dijkstra Algorithm

### 다익스트라란?

- 대표적인 최단 경로 탐색 알고리즘이다.
- 하나의 정점에서 다른 모든 정점으로 가는 최단 경로를 알려준다.
- 현실 세계에서는 음의 간선이 존재하지 않기 때문에 다익스트라는 현실 세계에 사용하기 매우 적합한 알고리즘 중 하나이다.
    - GPS 소프트웨어 등에서 가장 많이 사용 됨
    - 루빅스(3x3) 큐브 또는 미로탐색 등에도 활용 될 수 있다.

### 수행시간

- (V는 정점의 개수, E는 한 정점의 주변 노드)
- 순차탐색 사용시 O(V^2)
- 우선순위 큐 사용시 O(ElogE)

### 특징

- 하나의 최단 거리를 구할 때 그 이전까지 구했던 최단 거리 정보를 그대로 사용한다.
- 음의 가중치가 없는 그래프에서만 사용 할 수 있다.
    - Bellman-Ford 알고리즘을 통해 음수 가중치가 있는 가중치 방향 그래프에서 최단 경로를 해결 가능
- 그리디 알고리즘 : 매 상황에서 방문하지 않은 가장 비용이 적은 노드를 선택해 임의의 과정을 반복
- 다익스트라 알고리즘을 수행 한 뒤에는 테이블에 각 노드까지의 최단 거리 정보가 저장된다.
- 최단 경로에 있는 노드를 구하려면 소스코드에 추가적인 기능을 더 넣어야 한다.

### 동작과정

- 출발 노드를 설정
- 최단 거리 테이블을 초기화(무한대로)
- 방문하지 않은 노드 중에 최단 거리인 노드를 선택
- 해당 노드를 거쳐 다른 노드로 가는 비용을 계산하여 최단 거리 테이블 갱신
- 위 과정에서 3번과 4번을 반복

### 문제

- [https://leetcode.com/problems/network-delay-time/](https://leetcode.com/problems/network-delay-time/)

### 출처

- [https://blog.naver.com/ndb796/221234424646](https://blog.naver.com/ndb796/221234424646)
- [https://www.youtube.com/watch?v=611B-9zk2o4](https://www.youtube.com/watch?v=611B-9zk2o4)
- [https://leetcode.com/explore/learn/card/graph/622/single-source-shortest-path-algorithm/3862/](https://leetcode.com/explore/learn/card/graph/622/single-source-shortest-path-algorithm/3862/)