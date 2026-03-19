#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>

sem_t s;

void *fun()
{
    sem_wait(&s);   // enter

    printf("Inside CS\n");

    sem_post(&s);   // exit
}

int main()
{
    pthread_t t1,t2;

    sem_init(&s,0,1);

    pthread_create(&t1,NULL,fun,NULL);
    pthread_create(&t2,NULL,fun,NULL);

    pthread_join(t1,NULL);
    pthread_join(t2,NULL);

    sem_destroy(&s);

    return 0;
}
/*
> gcc semaphore.c -o output -lpthread
> ./output
Inside CS
Inside CS
*/