#include <stdio.h>
#include <stdlib.h>
typedef struct node
{
    int data;
    struct node *next;
} node;
node *start = NULL;
void create()
{
    int i, n;
    node *ptr, *t;
    start = NULL;
    printf("No. of nodes? ");
    scanf("%d", &n);
    for (i = 0; i < n; i++)
    {
        ptr = (node *)malloc(sizeof(node));
        printf("Data?");
        scanf("%d", &ptr->data);
        ptr->next = NULL;
        if (start == NULL)
        {
            start = ptr;
        }
        else
        {
            t = start;
            while (t->next != NULL)
            {
                t = t->next;
                t->next = ptr;
            }
        }
    }
}

void display()
{
    node *ptr = start;
    if (start == NULL)
    {
        printf("List empty");
        return;
    }
    else
    {
        while (ptr != NULL)
        {
            printf("%d ", ptr->data);
            ptr = ptr->next;
        }
    }
}

void insert_begin()
{
    node *ptr = (node *)malloc(sizeof(node));
    printf("Data?");
    scanf("%d", &ptr->data);
    ptr->next = start;
    start = ptr;
}

void insert_end()
{
    node *t, *ptr = (node *)malloc(sizeof(node));
    printf("Data?");
    scanf("%d", &ptr->data);
    ptr->next = NULL;
    if (start == NULL)
    {
        start = ptr;
    }
    else
    {
        t = start;
        while (t->next != NULL)
        {
            t = t->next;
            t->next = ptr;
        }
    }
}

void insert_pos(){
    int pos,i;
    node *ptr=(node* )malloc(sizeof(node));
    printf("Enter position: ");
    scanf("%d",&pos);
    printf("Enter data: ");
    scanf("%d",&ptr->data);
    ptr->next=NULL;
    if(pos<=0){
        printf("Invalid position\n");
        free(ptr);
        return;
    }
    else if(pos==1){
        insert_begin();
        return;
    } 
    else{
        node *t=start;
        for(i=1;i<pos-1 && t!=NULL;i++){
            t=t->next;
        }
        if(t==NULL){
            printf("position out of range");
            free(ptr);
            return;
        }    
        else{
            ptr->next=t->next;
            t->next=ptr;
        }
    }   
}

int main(){
    int c=1,ch;
    printf("<----- Singly Linked List --->\n");
    while(c){
        printf("MENU\n1.create\n2.Display\n3.Insert at Beginning\n4.Insert at End\n5.Insert at Position\n6.Delete from Beginning\n7.Delete from End\n8.Delete from Position\n9.Count\n10.Exit\n");
        printf("Enter your choice: ");
        scanf("%d",&ch);
        switch(ch){
            case 1:
                create();
                break;
            case 2:
                display();
                break;
            case 3:
                insert_begin();
                break;
            case 4:
                insert_end();
                break;
            case 5:
                insert_pos();
                break;
            
            case 6:
                c=0;
                break;
            default:
                printf("Invalid Input\n");
        }

    }
    
}