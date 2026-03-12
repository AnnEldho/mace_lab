//program to implement singly linked list operations
#include<stdio.h>
#include<stdlib.h>
typedef struct node{
    int data;
    struct node *next;
}
node;
node *start=NULL; 

void create(){
    int i,n;
    node *ptr,*t;
    printf("How many nodes you want to create: ");
    scanf("%d",&n);

    //start=NULL;

    for(i=0;i<n;i++){
        ptr=(node* )malloc(sizeof(node));
        printf("Enter data: ");
        scanf("%d",&ptr->data);
        ptr->next=NULL;
        if(start==NULL){
            start=ptr;
        }
        else{
            t=start;
            while(t->next!=NULL){
                t=t->next;
            }
            t->next=ptr;
        }
    }
}

void display(){
    node *ptr=start;
    if(start==NULL){
        printf("List is empty\n");
        return;
    }
    while(ptr!=NULL){
        printf("%d -> ",ptr->data);
        ptr=ptr->next;
    }
    printf("NULL\n");
}

void insert_begin(){
    node *ptr=(node* )malloc(sizeof(node));
    printf("Enter data: ");
    scanf("%d",&ptr->data);
    ptr->next=start;
    start=ptr;
}

void insert_end(){
    node *ptr=(node* )malloc(sizeof(node)),*t;
    printf("Enter data: ");
    scanf("%d",&ptr->data);
    ptr->next=NULL;
    if(start==NULL){
            start=ptr;
        }
        else{
            t=start;
            while(t->next!=NULL){
                t=t->next;
            }
            t->next=ptr;
        }
    
}
void insert_position(){
    int pos,i;
    node *ptr=(node* )malloc(sizeof(node));
    printf("Enter position: ");
    scanf("%d",&pos);
    printf("Enter data: ");
    scanf("%d",&ptr->data);

    ptr->next=NULL;
     if (pos <= 0) {
        printf("Invalid position!\n");
        free(ptr);
        return;
    }
    if(pos==1){
         ptr->next = start;
        start = ptr;
        return;
    }

    node *t=start;
    for(i=1;i<pos-1 && t!=NULL;i++){
        t=t->next;
    }
    if(t==NULL){
        printf("Position out of range\n");
        free(ptr);
        return;
    }
    else{
        ptr->next=t->next;
        t->next=ptr;
    }
}

void delete_begin(){
    if(start==NULL){
        printf("List is empty\n");
        return;
    }
    node *ptr=start;
    start=start->next;
    free(ptr);
}

void delete_end(){
    if(start==NULL){
        printf("List is empty\n");
        return;
    }
    node *ptr=start;
    if(ptr->next==NULL){
        start=NULL;
        free(ptr);
        return;
    }
    while(ptr->next->next!=NULL){
        ptr=ptr->next;
    }
    free(ptr->next);
    ptr->next=NULL;
}

void delete_position(){
    int pos,i;
    printf("Enter position: ");
    scanf("%d",&pos);
    if(start==NULL){
        printf("List is empty\n");
        return;
    }
    if(pos<=0){
        printf("Invalid position\n");
        return;
    }
    node *t=start;
    if(pos==1){
        start=start->next;
        free(t);
        return;
    }
    for(i=1;i<pos-1 && t!=NULL;i++){
        t=t->next;
    }
    if(t==NULL||t->next==NULL){
        printf("Position out of range\n");
        return;
    }
    node *temp=t->next;
    t->next=temp->next;
    free(temp);

}

void count(){
    int cnt=0;
    node *ptr=start;
    while(ptr!=NULL){
        cnt++;
        ptr=ptr->next;
    }
    printf("Count: %d\n",cnt);
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
                insert_position();
                break;
            case 6:
                delete_begin();
                break;
            case 7:
                delete_end();
                break;
            case 8:
                delete_position();
                break;
            case 9:
                count();
                break;
            case 10:
                c=0;
                break;
            default:
                printf("Invalid Input\n");
        }

    }
    
}