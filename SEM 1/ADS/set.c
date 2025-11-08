#include <stdio.h>

#define SIZE 8   // Size of universal set (you can change this)
#define MAX 20 // Maximum size of the set

// Function to display a bit string as a set
void displaySet(int set[]) {
    printf("{ ");
    for (int i = 0; i < SIZE; i++) {
        if (set[i] == 1) {
            printf("%d ", i); // here we assume universal set = {0,1,2,...,SIZE-1}
        }
    }
    printf("}\n");
}

// Function to perform Union
void setUnion(int A[], int B[], int result[]) {
    for (int i = 0; i < SIZE; i++) {
        result[i] = A[i] | B[i];   // bitwise OR
    }
}

// Function to perform Intersection
void setIntersection(int A[], int B[], int result[]) {
    for (int i = 0; i < SIZE; i++) {
        result[i] = A[i] & B[i];   // bitwise AND
    }
}

// Function to perform Difference (A - B)
void setDifference(int A[], int B[], int result[]) {
    for (int i = 0; i < SIZE; i++) {
        result[i] = A[i] & (!B[i]); // A[i]=1 and B[i]=0
    }
}

int main() {
    int U[MAX],A[SIZE], B[SIZE], result[SIZE];
    int n, x;

    // Initialize sets with 0
    for (int i = 0; i < SIZE; i++) {
        A[i] = 0;
        B[i] = 0;
    }

    printf("Enter number of elements in Universal Set: ");
    scanf("%d", &n);
    printf("Enter elements of Universal Set(0-%d): ", n - 1);
    for (int i = 0; i < n; i++) {
        scanf("%d", &x);
        if (x >= 0 && x < MAX) U[x] = 1;
    }


    // Input Set A
    printf("Enter number of elements in Set A: ");
    scanf("%d", &n);
    printf("Enter elements of Set A (0-%d): ", n - 1);
    for (int i = 0; i < n; i++) {
        scanf("%d", &x);
        if (x >= 0 && x < SIZE) A[x] = 1;
    }

    // Input Set B
    printf("Enter number of elements in Set B: ");
    scanf("%d", &n);
    printf("Enter elements of Set B (0-%d): ", SIZE - 1);
    for (int i = 0; i < n; i++) {
        scanf("%d", &x);
        if (x >= 0 && x < SIZE) B[x] = 1;
    }

    printf("\nSet A = ");
    displaySet(A);
    printf("Set B = ");
    displaySet(B);

    // Union
    setUnion(A, B, result);
    printf("\nA ∪ B = ");
    displaySet(result);

    // Intersection
    setIntersection(A, B, result);
    printf("A ∩ B = ");
    displaySet(result);

    // Difference
    setDifference(A, B, result);
    printf("A - B = ");
    displaySet(result);

    return 0;
}
