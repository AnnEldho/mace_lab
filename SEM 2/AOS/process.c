#include <stdio.h>
#include <unistd.h>
#include <pthread.h>

// Thread function
void *thread_fun()
{
    printf("Thread created successfully\n");
    return NULL;
}

int main()
{
    pid_t pid;

    pid = fork();   // create process

    if (pid == 0)
    {
        // Child process
        printf("Child Process (PID = %d)\n", getpid());

        pthread_t t;
        pthread_create(&t, NULL, thread_fun, NULL); // create thread
        pthread_join(t, NULL);
    }
    else if (pid > 0)
    {
        // Parent process
        printf("Parent Process (PID = %d)\n", getpid());
    }
    else
    {
        printf("Process creation failed\n");
    }

    return 0;
}
/*
gcc process.c -o process -lpthread
./process

Parent Process (PID = 10338)
Child Process (PID = 10339)
Thread created successfully
*/