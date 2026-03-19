#include <stdio.h>
#include <pthread.h>

int flag[2] = {0,0};
int turn;

void *p0()
{
    flag[0] = 1;
    turn = 1;
    while(flag[1] && turn == 1);

    printf("Process 0 in CS\n");

    flag[0] = 0;
}

void *p1()
{
    flag[1] = 1;
    turn = 0;
    while(flag[0] && turn == 0);

    printf("Process 1 in CS\n");

    flag[1] = 0;
}

int main()
{
    pthread_t t1, t2;

    pthread_create(&t1,NULL,p0,NULL);
    pthread_create(&t2,NULL,p1,NULL);

    pthread_join(t1,NULL);
    pthread_join(t2,NULL);

    return 0;
}
/*
> gcc peterson.c -o output -lpthread
> ./output
Process 0 in CS
Process 1 in CS
*/