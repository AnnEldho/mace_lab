//Program to create, insert, delete and traverse a binary tree
#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int data;
    struct Node *left, *right;
} node;

node* root = NULL;

// Create new node
node* createNode(int val) {
    node* newNode = (node*)malloc(sizeof(node));
    newNode->data = val;
    newNode->left = newNode->right = NULL;
    return newNode;
}

// Interactive tree creation
node* createTree() {
    int val, choice;
    printf("Enter node value: ");
    scanf("%d", &val);
    node* newNode = createNode(val);

    printf("Do %d have left node (yes-1,no-0): ", val);
    scanf("%d", &choice);
    if (choice == 1)
        newNode->left = createTree();

    printf("Do %d have right node (yes-1,no-0): ", val);
    scanf("%d", &choice);
    if (choice == 1)
        newNode->right = createTree();

    return newNode;
}

// Insert manually (always as a rightmost node for simplicity)
void insertNode(node* root, int val) {
    int choice;
    if (!root) return;

    printf("Do %d have left node (yes-1,no-0): ", root->data);
    scanf("%d", &choice);
    if (choice == 0 && !root->left) {
        root->left = createNode(val);
        return;
    } else if (choice == 1 && root->left) {
        insertNode(root->left, val);
        return;
    }

    printf("Do %d have right node (yes-1,no-0): ", root->data);
    scanf("%d", &choice);
    if (choice == 0 && !root->right) {
        root->right = createNode(val);
        return;
    } else if (choice == 1 && root->right) {
        insertNode(root->right, val);
        return;
    }
}

// Delete node by value
node* deleteNode(node* root, int val) {
    if (!root) return NULL;

    if (root->data == val) {
        // Simple delete: if leaf
        if (!root->left && !root->right) {
            free(root);
            return NULL;
        }
        // If only left child
        if (root->left && !root->right) {
            node* temp = root->left;
            free(root);
            return temp;
        }
        // If only right child
        if (!root->left && root->right) {
            node* temp = root->right;
            free(root);
            return temp;
        }
        // Two children: replace with leftmost of right subtree
        node* temp = root->right;
        while (temp->left) temp = temp->left;
        root->data = temp->data;
        root->right = deleteNode(root->right, temp->data);
        return root;
    }

    root->left = deleteNode(root->left, val);
    root->right = deleteNode(root->right, val);
    return root;
}

// Traversals
void inorder(node* root) {
    if (!root) return;
    inorder(root->left);
    printf("%d ", root->data);
    inorder(root->right);
}
void preorder(node* root) {
    if (!root) return;
    printf("%d ", root->data);
    preorder(root->left);
    preorder(root->right);
}
void postorder(node* root) {
    if (!root) return;
    postorder(root->left);
    postorder(root->right);
    printf("%d ", root->data);
}

int main() {
    int ch, val;
    while (1) {
        printf("\nMenu\n");
        printf("1.Create\n2.Insert\n3.Delete\n4.Inorder\n5.Preorder\n6.Postorder\n7.Exit\n");
        printf("Enter choice: ");
        scanf("%d", &ch);

        switch (ch) {
            case 1:
                root = createTree();
                break;
            case 2:
                printf("Enter value to insert: ");
                scanf("%d", &val);
                insertNode(root, val);
                break;
            case 3:
                printf("Enter value to delete: ");
                scanf("%d", &val);
                root = deleteNode(root, val);
                break;
            case 4:
                printf("Inorder: ");
                inorder(root);
                printf("\n");
                break;
            case 5:
                printf("Preorder: ");
                preorder(root);
                printf("\n");
                break;
            case 6:
                printf("Postorder: ");
                postorder(root);
                printf("\n");
                break;
            case 7:
                exit(0);
            default:
                printf("Invalid choice!\n");
        }
    }
    return 0;
}
