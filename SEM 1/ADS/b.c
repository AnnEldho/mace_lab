#include <stdio.h>
#define MAX 100

int queue[MAX], front = -1, rear = -1;

int isEmpty(){
    return (front == -1 || front > rear);
}

void enqueue(int vertex){
    if(rear == MAX - 1)
        printf("Queue Overflow\n");
    else{
        if(front == -1)
            front = 0;
        queue[++rear] = vertex;
    }
}

int dequeue(){
    if(front == -1 || front > rear)
        return -1;
    else
        return queue[front++];
}

void BFS(int adj[MAX][MAX], int n, int start)
{
    int visited[MAX];
    int i, vertex;

    // Correct initialization
    for(i = 0; i < n; i++)
        visited[i] = 0;

    enqueue(start);
    visited[start] = 1;

    while(!isEmpty())
    {
        vertex = dequeue();
        printf("%d ", vertex);

        for(i = 0; i < n; i++)
        {
            if(adj[vertex][i] == 1 && visited[i] == 0)
            {
                enqueue(i);
                visited[i] = 1;
            }
        }
    }
}

int main()
{
    int n;
    printf("enter number of vertices: ");
    scanf("%d", &n);

    int adj[MAX][MAX];
    printf("enter adjacency matrix:\n");
    for(int i = 0; i < n; i++)
        for(int j = 0; j < n; j++)
            scanf("%d", &adj[i][j]);

    int start;
    printf("enter starting vertex: ");
    scanf("%d", &start);

    printf("BFS traversal from %d: ", start);
    BFS(adj, n, start);

    return 0;
}
