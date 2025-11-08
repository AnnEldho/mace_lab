#include <stdio.h>

struct Edge {
    int u, v, cost;
};

struct Edge heap[50];
int parent[20];
int n, m, heapSize;

// Find parent function
int find(int i) {
    while (parent[i] != i)
        i = parent[i];
    return i;
}

// Union function
void union_set(int i, int j) {
    int a = find(i);
    int b = find(j);
    parent[a] = b;
}
      
// Insert edge into heap
void insertHeap(struct Edge e) {
    heapSize++;
    int i = heapSize;
    heap[i] = e;

    // Heapify bottom-up
    while(i > 1 && heap[i].cost < heap[i/2].cost) {
        struct Edge temp = heap[i];
        heap[i] = heap[i/2];
        heap[i/2] = temp;
        i = i / 2;
    }
}

// Delete minimum cost edge from heap
struct Edge deleteMin() {
    struct Edge min = heap[1];
    heap[1] = heap[heapSize];
    heapSize--;

    int i = 1;
    while(1) {
        int smallest = i;
        int left = 2 * i;
        int right = 2 * i + 1;

        if(left <= heapSize && heap[left].cost < heap[smallest].cost)
            smallest = left;
        if(right <= heapSize && heap[right].cost < heap[smallest].cost)
            smallest = right;

        if(smallest != i) {
            struct Edge temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;
            i = smallest;
        } else {
            break;
        }
    }
    return min;
}

int main() {
    int i, u, v, cost;
    int mincost = 0, edges = 0;

    printf("Enter number of vertices: ");
    scanf("%d", &n);

    printf("Enter number of edges: ");
    scanf("%d", &m);

    printf("Enter edges u v cost:\n");
    heapSize = 0;

    for(i = 0; i < m; i++) {
        scanf("%d %d %d", &u, &v, &cost);
        struct Edge e;
        e.u = u;
        e.v = v;
        e.cost = cost; 
        insertHeap(e);
    }

    // Initialize parent array
    for(i = 1; i <= n; i++)
        parent[i] = i;

    printf("\nEdges in Minimum Spanning Tree:\n");

    while(edges < n - 1 && heapSize > 0) {
        struct Edge e = deleteMin();
        int a = find(e.u);
        int b = find(e.v);

        if(a != b) {
            printf("%d --> %d  Cost = %d\n", e.u, e.v, e.cost);
            mincost += e.cost;
            union_set(a, b);
            edges++;
        }
    }

    printf("\nMinimum Cost = %d\n", mincost);

    return 0;
}
