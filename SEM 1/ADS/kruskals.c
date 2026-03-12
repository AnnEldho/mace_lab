#include <stdio.h>

int parent[20];

int find(int i) {               //Check which group (set) the vertex belongs to.
    while (parent[i] != i)
        i = parent[i];
    return i;
}

int main() {

    int n, m;
    int u[20], v[20], cost[20];
    int i, j, mincost = 0, count = 0;

    printf("Enter number of vertices: ");
    scanf("%d", &n);

    printf("Enter number of edges: ");
    scanf("%d", &m);

    printf("Enter edges (u v cost):\n");
    for (i = 0; i < m; i++)
        scanf("%d %d %d", &u[i], &v[i], &cost[i]);

    for (i = 1; i <= n; i++)
        parent[i] = i;

    // Simple bubble sort
    for (i = 0; i < m - 1; i++) {               //Sort edges by cost
        for (j = 0; j < m - i - 1; j++) {
            if (cost[j] > cost[j + 1]) {

                int temp = cost[j];
                cost[j] = cost[j + 1];
                cost[j + 1] = temp;

                temp = u[j];
                u[j] = u[j + 1];
                u[j + 1] = temp;

                temp = v[j];
                v[j] = v[j + 1];
                v[j + 1] = temp;
            }
        }
    }

    printf("\nEdges in Minimum Spanning Tree:\n");
    //Select edges for MST
    for (i = 0; i < m && count < n - 1; i++) {
        int a = find(u[i]);
        int b = find(v[i]);

        if (a != b) {   //They are from different groups, no cycle created
            printf("%d -- %d  cost = %d\n", u[i], v[i], cost[i]);
            mincost += cost[i];
            parent[a] = b;  // Union
            count++;
        }
    }

    printf("\nMinimum Cost = %d\n", mincost);

    return 0;
}
