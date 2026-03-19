#include <stdio.h>
#include <pthread.h>
#include <unistd.h>

int flag[2] = {0,0};
int turn;
int count = 0;

void *process0()
{
    flag[0] = 1;      // interested
    turn = 1;

    while(flag[1] && turn == 1);   // wait

    // CRITICAL SECTION
    printf("Process 0 entered CS\n");

    int temp = count;
    sleep(1);
    temp++;
    count = temp;

    printf("Process 0 updated count = %d\n", count);

    flag[0] = 0;      // exit

    return NULL;
}

void *process1()
{
    flag[1] = 1;
    turn = 0;

    while(flag[0] && turn == 0);

    // CRITICAL SECTION
    printf("Process 1 entered CS\n");

    int temp = count;
    sleep(1);
    temp++;
    count = temp;

    printf("Process 1 updated count = %d \n", count);

    flag[1] = 0;

    return NULL;
}

int main()
{
    pthread_t t1, t2;

    pthread_create(&t1,NULL,process0,NULL);
    pthread_create(&t2,NULL,process1,NULL);

    pthread_join(t1,NULL);
    pthread_join(t2,NULL);

    printf("Final count = %d\n", count);

    return 0;
}
/*
Process 0 entered CS
Process 0 updated count = 1
Process 1 entered CS
Process 1 updated count = 2
Final count = 2
*/