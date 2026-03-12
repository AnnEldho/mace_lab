//program to implement doubly linked list operations
#include<stdio.h>
#include<stdlib.h>

typedef struct node{
    int data;
    struct node *next;
    struct node *prev;
}node;

node *start=NULL;

void create(){
    int i,n;
    node *ptr,*t;
    printf("How many nodes you want to create: ");
    scanf("%d",&n);

    for(i=0;i<n;i++){
        ptr=(node*)malloc(sizeof(node));
        printf("Enter data: ");
        scanf("%d",&ptr->data);
        ptr->next=NULL;
        ptr->prev=NULL;

        if(start==NULL){       // first node
            start=ptr;
        }
        else{
            t=start;
            while(t->next!=NULL){
                t=t->next;
            }
            t->next=ptr;
            ptr->prev=t;  // link backwards
        }
    }
}

void display_forward() {
    node *t = start;
    if (t == NULL) {
        printf("List is empty\n");
        return;
    }
    printf("Forward: ");
    while (t != NULL) {
        printf("%d ", t->data);
        t = t->next;
    }
    printf("\n");
}

void display_backward(){
    if (start == NULL) {
        printf("List is empty\n");
        return;
    }
    node *t = start;
    while (t->next != NULL) {
        t = t->next;
    }
    printf("Backward: ");
    while (t != NULL) {
        printf("%d ", t->data);
        t = t->prev;
    }
    printf("\n");
}

void insert_begin(){
    node *ptr=(node*)malloc(sizeof(node));
    printf("Enter data: ");
    scanf("%d",&ptr->data);
    ptr->next=start;
    ptr->prev=NULL;
    if(start!=NULL){
        start->prev=ptr;
    }
    start=ptr;
}

void insert_end(){
    node *ptr=(node*)malloc(sizeof(node));
    node *t=start;
    printf("Enter data: ");
    scanf("%d",&ptr->data);
    ptr->next=NULL;
    ptr->prev=NULL;
    if(start==NULL){
        start=ptr;
        return;
    }
    while(t->next!=NULL){
        t=t->next;
    }
    t->next=ptr;
    ptr->prev=t;
}

void insert_pos(){
    int pos,i;
    printf("Enter position: ");
    scanf("%d",&pos);
    node *ptr=(node*)malloc(sizeof(node));
    printf("Enter data: ");
    scanf("%d",&ptr->data);
    ptr->next=NULL;
    ptr->prev=NULL;

    if(pos==1){
        insert_begin();
        free(ptr); // remove this line if you don’t want extra malloc
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
    ptr->next=t->next;
    ptr->prev=t;
    if(t->next!=NULL){
        t->next->prev=ptr;
    }
    t->next=ptr;
}

void delete_begin(){
    if(start==NULL){
        printf("List is empty\n");
        return;
    }
    node *t=start;
    start=start->next;
    if(start!=NULL){
        start->prev=NULL;
    }
    printf("Deleted %d\n",t->data);
    free(t);
}

void delete_end(){
    if(start==NULL){
        printf("List is empty\n");
        return;
    }
    node *t=start;
    if(t->next==NULL){  // only one node
        printf("Deleted %d\n",t->data);
        free(t);
        start=NULL;
        return;
    }
    while(t->next!=NULL){
        t=t->next;
    }
    t->prev->next=NULL;
    printf("Deleted %d\n",t->data);
    free(t);
}

void delete_pos(){
    int pos,i;
    printf("Enter position: ");
    scanf("%d",&pos);
    if(start==NULL){
        printf("List is empty\n");
        return;
    }
    node *t=start;
    if(pos==1){
        delete_begin();
        return;
    }
    for(i=1;i<pos && t!=NULL;i++){
        t=t->next;
    }
    if(t==NULL){
        printf("Position out of range\n");
        return;
    }
    if(t->next!=NULL){
        t->next->prev=t->prev;
    }
    if(t->prev!=NULL){
        t->prev->next=t->next;
    }
    printf("Deleted %d\n",t->data);
    free(t);
}

void count(){
    int c=0;
    node *t=start;
    while(t!=NULL){
        c++;
        t=t->next;
    }
    printf("Total nodes = %d\n",c);
}

int main(){
    int c=1,ch;
    printf("<----- Doubly Linked List --->\n");
    while(c){
        printf("\nMENU\n1.Create\n2.Display Forward\n3.Display Backward\n4.Insert at Beginning\n5.Insert at End\n6.Insert at Position\n7.Delete from Beginning\n8.Delete from End\n9.Delete from Position\n10.Count\n11.Exit\n");
        printf("Enter your choice: ");
        scanf("%d",&ch);
        switch(ch){
            case 1: create(); break;
            case 2: display_forward(); break;
            case 3: display_backward(); break;  
            case 4: insert_begin(); break;
            case 5: insert_end(); break;
            case 6: insert_pos(); break;
            case 7: delete_begin(); break;
            case 8: delete_end(); break;
            case 9: delete_pos(); break;
            case 10: count(); break;
            case 11: c=0; break;
            default: printf("Invalid choice\n");
        }
    }
    return 0;
}
