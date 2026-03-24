#include <pthread.h>
#include <semaphore.h>
#include <stdio.h>
#include <unistd.h>

sem_t rw_mutex;    // Controls access to the shared resource
sem_t mutex;       // Controls access to the read_count variable
int read_count = 0;
int shared_data = 0;

void* writer(void* arg) {
    int f = *((int*)arg);
    
    sem_wait(&rw_mutex); // Lock the resource for writing
    
    // --- CRITICAL SECTION (Writing) ---
    shared_data += 10;
    printf("Writer %d modified shared_data to %d\n", f, shared_data);
    sleep(1); 
    // ----------------------------------
    
    sem_post(&rw_mutex); // Release the resource
    return NULL;
}

void* reader(void* arg) {
    int f = *((int*)arg);

    // Entry Section for Reader
    sem_wait(&mutex);
    read_count++;
    if (read_count == 1) {
        sem_wait(&rw_mutex); // First reader locks the resource from writers
    }
    sem_post(&mutex);

    // --- READING SECTION ---
    printf("Reader %d: read shared_data as %d (Active Readers: %d)\n", f, shared_data, read_count);
    sleep(1);
    // -----------------------

    // Exit Section for Reader
    sem_wait(&mutex);
    read_count--;
    if (read_count == 0) {
        sem_post(&rw_mutex); // Last reader unlocks the resource for writers
    }
    sem_post(&mutex);
    
    return NULL;
}

int main() {
    pthread_t r[5], w[2];
    sem_init(&mutex, 0, 1);
    sem_init(&rw_mutex, 0, 1);

    int ids[5] = {1, 2, 3, 4, 5};

    // Creating 5 Readers and 2 Writers
    for(int i = 0; i < 3; i++) pthread_create(&r[i], NULL, reader, &ids[i]);
    for(int i = 0; i < 2; i++) pthread_create(&w[i], NULL, writer, &ids[i]);
    for(int i = 3; i < 5; i++) pthread_create(&r[i], NULL, reader, &ids[i]);

    for(int i = 0; i < 5; i++) pthread_join(r[i], NULL);
    for(int i = 0; i < 2; i++) pthread_join(w[i], NULL);

    sem_destroy(&mutex);
    sem_destroy(&rw_mutex);

    return 0;
}