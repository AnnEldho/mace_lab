#include <stdio.h>

#define INF 9999
#define MAX 10

int main() {
    int cost[MAX][MAX], near[MAX], t[2][MAX];
    int n, e, i, j, u, v, w, k, l, min, mincost = 0;

    // Input number of vertices and edges
    printf("Enter number of vertices: ");
    scanf("%d", &n);

    printf("Enter number of edges: ");
    scanf("%d", &e);

    // Initialize cost matrix
    for (i = 1; i <= n; i++) {
        for (j = 1; j <= n; j++) {
            cost[i][j] = INF;
        }
    }

    // Input each edge
    printf("\nEnter each edge as: source destination cost\n");
    for (i = 1; i <= e; i++) {
        printf("Edge %d: ", i);
        scanf("%d %d %d", &u, &v, &w);
        cost[u][v] = w;
        cost[v][u] = w; // Undirected graph
    }

    // Step 1: Find edge (k, l) with minimum cost
    min = INF;
    for (i = 1; i <= n; i++) {
        for (j = 1; j <= n; j++) {
            if (cost[i][j] < min) {
                min = cost[i][j];
                k = i;
                l = j;
            }
        }
    }

    t[0][1] = k;
    t[1][1] = l;
    mincost = cost[k][l];

    // Step 2: Initialize near[]
    for (i = 1; i <= n; i++) {
        if (cost[i][l] < cost[i][k])
            near[i] = l;
        else
            near[i] = k;
    }
    near[k] = 0;
    near[l] = 0;

    // Step 3: Find remaining n-2 edges
    for (i = 2; i <= n - 1; i++) {
        min = INF;
        int j_min = -1;

        // Find minimum edge
        for (j = 1; j <= n; j++) {
            if (near[j] != 0 && cost[j][near[j]] < min) {
                min = cost[j][near[j]];
                j_min = j;
            }
        }

        t[0][i] = j_min;
        t[1][i] = near[j_min];
        mincost += cost[j_min][near[j_min]];
        near[j_min] = 0;

        // Update near[]
        for (k = 1; k <= n; k++) {
            if (near[k] != 0 && cost[k][near[k]] > cost[k][j_min])
                near[k] = j_min;
        }
    }

    // Step 4: Display result
    printf("\nThe edges of the Minimum Cost Spanning Tree are:\n");
    for (i = 1; i <= n - 1; i++) {
        printf("Edge %d: (%d -> %d)\n", i, t[0][i], t[1][i]);
    }

    printf("\nMinimum cost = %d\n", mincost);
    return 0;
}
