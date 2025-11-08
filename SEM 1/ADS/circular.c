// Program to implement Circular Queue using Array
#include <stdio.h>
#define MAX 5 // size of circular queue

int queue[MAX];
int front = -1, rear = -1;

// Insert element
void enqueue()
{
    int value;
    if ((front == 0 && rear == MAX - 1) || (rear + 1) % MAX == front)
    {
        printf("Queue is FULL!\n");
        return;
    }
    if (front == -1) // first element
        front = 0;

    printf("Enter value: ");
    scanf("%d", &value);
    rear = (rear + 1) % MAX;
    queue[rear] = value;
    printf("Inserted %d\n", value);
}

// Delete element
void dequeue()
{
    if (front == -1)
    {
        printf("Queue is EMPTY!\n");
        return;
    }
    printf("Deleted %d\n", queue[front]);

    if (front == rear) // only one element
        front = rear = -1;
    else
        front = (front + 1) % MAX;
}

// Display elements
void display()
{
    if (front == -1)
    {
        printf("Queue is EMPTY!\n");
        return;
    }

    printf("Queue: ");
    int i = front;
    while (1)
    {
        printf("%d ", queue[i]);
        if (i == rear)
            break;
        i = (i + 1) % MAX;
    }
    printf("\n");
}

// Count elements
int count()
{
    if (front == -1)
        return 0;
    if (rear >= front)
        return rear - front + 1;
    return MAX - front + rear + 1;
}

// Main function
int main()
{
    int choice, value, c = 1;

    while (c)
    {
        printf("\n--- Circular Queue ---\n");
        printf("1. Insert\n2. Delete\n3. Display\n4. Count\n5. Exit\n");
        printf("Enter choice: ");
        scanf("%d", &choice);

        switch (choice)
        {
        case 1:
            enqueue();
            break;
        case 2:
            dequeue();
            break;
        case 3:
            display();
            break;
        case 4:
            printf("Total elements = %d\n", count());
            break;
        case 5:
            c = 0;
            return 0;
        default:
            printf("Invalid choice!\n");
        }
    }
}
