#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <semaphore.h>
#include <unistd.h>

#define BUFFER_SIZE 5 // Total capacity of the buffer

int buffer[BUFFER_SIZE];
int in = 0;  // Index for producer
int out = 0; // Index for consumer

sem_t empty;
sem_t full;
sem_t mutex;

void* producer(void* arg) {
    for(int i = 0; i < 10; i++) { // Produce 10 items
        int item = rand() % 100; // Generate a random item

        sem_wait(&empty); // Wait for an empty slot
        sem_wait(&mutex); // Enter critical section

        // --- CRITICAL SECTION START ---
        buffer[in] = item;
        printf("Producer: Inserted item %d at index %d\n", item, in);
        in = (in + 1) % BUFFER_SIZE;
        // --- CRITICAL SECTION END ---

        sem_post(&mutex); // Leave critical section
        sem_post(&full);  // Signal that a slot is full

        sleep(1); // Simulate time taken to produce
    }
    return NULL;
}

void* consumer(void* arg) {
    for(int i = 0; i < 10; i++) { // Consume 10 items
        sem_wait(&full);  // Wait for a full slot
        sem_wait(&mutex); // Enter critical section

        // --- CRITICAL SECTION START ---
        int item = buffer[out];
        printf("Consumer: Removed item %d from index %d\n", item, out);
        out = (out + 1) % BUFFER_SIZE;
        // --- CRITICAL SECTION END ---

        sem_post(&mutex); // Leave critical section
        sem_post(&empty); // Signal that a slot is empty

        sleep(2); // Simulate time taken to consume
    }
    return NULL;
}

int main() {
    pthread_t prod_thread, cons_thread;

    // Initialize semaphores
    sem_init(&empty, 0, BUFFER_SIZE); // Initially, all slots are empty
    sem_init(&full, 0, 0);           // Initially, no slots are full
    sem_init(&mutex, 0, 1);          // Binary semaphore for mutual exclusion

    pthread_create(&prod_thread, NULL, producer, NULL);
    pthread_create(&cons_thread, NULL, consumer, NULL);

    pthread_join(prod_thread, NULL);
    pthread_join(cons_thread, NULL);

    // Cleanup
    sem_destroy(&empty);
    sem_destroy(&full);
    sem_destroy(&mutex);

    return 0;
}