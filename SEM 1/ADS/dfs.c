#include <stdio.h>

#define MAX 20

int adj[MAX][MAX];
int visited[MAX];
int n;

void dfs(int vertex) {
    visited[vertex] = 1;
    printf("%d ", vertex);

    for (int i = 1; i <= n; i++) {
        if (adj[vertex][i] == 1 && visited[i] == 0) {
            dfs(i);
        }
    }
}

int main() {
    int start;

    printf("Enter number of vertices: ");
    scanf("%d", &n);

    printf("Enter adjacency matrix of the graph (%d x %d):\n", n, n);
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            scanf("%d", &adj[i][j]);
        }
    }

    // Initialize all vertices as unvisited
    for (int i = 1; i <= n; i++) {
        visited[i] = 0;
    }

    printf("Enter the starting vertex (1 to %d): ", n);
    scanf("%d", &start);

    printf("DFS Traversal starting from vertex %d: ", start);
    dfs(start);

    return 0;
}