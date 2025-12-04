#include <stdio.h>

#define MAX 100

int parent[MAX];

// Create n sets
void makeSet(int n) {
    for (int i = 0; i < n; i++) {
        parent[i] = i;
    }
}

// Find root
int find(int x){
    if(parent[x] != x){
        parent[x] = find(parent[x]); // path compression
    }
    return parent[x];
}


// Union operation
void unionSet(int x, int y) {
    int rx = find(x);
    int ry = find(y);

    if (rx == ry)
        printf("Already in same set!\n");
    else {
        parent[ry] = rx;
        printf("Union done!\n");
    }
}

// Display sets like {0,2,5}
void displaySets(int n) {
    printf("\nDisjoint Sets:\n");
    for (int i = 0; i < n; i++) {
        if (parent[i] == i) {  // if i is a representative
            printf("{");
            for (int j = 0; j < n; j++) {
                if (find(j) == i) {
                    printf("%d ", j);
                }
            }
            printf("}\n");
        }
    }
}


int main() {
    int n, choice, x, y;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    makeSet(n);

    while (1) {
        printf("\n--- MENU ---\n");
        printf("1. Find\n");
        printf("2. Union\n");
        printf("3. Display Sets\n");
        printf("4. Exit\n");
        printf("Enter choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter element: ");
                scanf("%d", &x);
                printf("Representative = %d\n", find(x));
                break;

            case 2:
                printf("Enter two elements: ");
                scanf("%d %d", &x, &y);
                unionSet(x, y);
                break;

            case 3:
                displaySets(n);
                break;

            case 4:
                return 0;

            default:
                printf("Invalid choice!\n");
        }
    }
}
