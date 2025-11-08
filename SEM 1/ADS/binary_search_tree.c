#include <stdio.h>
#include <stdlib.h>

// Structure of a node
struct node {
    int data;
    struct node *left, *right;
};

// Function to create a new node
struct node* createNode(int value) {
    struct node* newNode = (struct node*)malloc(sizeof(struct node));
    newNode->data = value;
    newNode->left = newNode->right = NULL;
    return newNode;
}

// Function to insert a node in BST
struct node* insert(struct node* root, int value) {
    if (root == NULL)  // If tree is empty
        return createNode(value);
    
    if (value < root->data)
        root->left = insert(root->left, value);
    else if (value > root->data)
        root->right = insert(root->right, value);
    
    return root;  // return unchanged root pointer
}

// Function to find the minimum value node in BST
struct node* findMin(struct node* root) {
    while (root && root->left != NULL)
        root = root->left;
    return root;
}

// Function to delete a node in BST
struct node* deleteNode(struct node* root, int value) {
    if (root == NULL)
        return root;

    if (value < root->data)
        root->left = deleteNode(root->left, value);
    else if (value > root->data)
        root->right = deleteNode(root->right, value);
    else {
        // Node found
        if (root->left == NULL) {
            struct node* temp = root->right;
            free(root);
            return temp;
        }
        else if (root->right == NULL) {
            struct node* temp = root->left;
            free(root);
            return temp;
        }

        // Node with two children: find inorder successor
        struct node* temp = findMin(root->right);
        root->data = temp->data;
        root->right = deleteNode(root->right, temp->data);
    }
    return root;
}

// Function to search for a value
struct node* search(struct node* root, int key) {
    if (root == NULL || root->data == key)
        return root;
    if (key < root->data)
        return search(root->left, key);
    else
        return search(root->right, key);
}

// Inorder Traversal (Left, Root, Right)
void inorder(struct node* root) {
    if (root != NULL) {
        inorder(root->left);
        printf("%d ", root->data);
        inorder(root->right);
    }
}

// Preorder Traversal (Root, Left, Right)
void preorder(struct node* root) {
    if (root != NULL) {
        printf("%d ", root->data);
        preorder(root->left);
        preorder(root->right);
    }
}

// Postorder Traversal (Left, Right, Root)
void postorder(struct node* root) {
    if (root != NULL) {
        postorder(root->left);
        postorder(root->right);
        printf("%d ", root->data);
    }
}

// Main function
int main() {
    struct node* root = NULL;
    int choice, value;

    while (1) {
        printf("\n\n--- Binary Search Tree Operations ---\n");
        printf("1. Insert\n2. Delete\n3. Search\n4. Inorder Traversal\n");
        printf("5. Preorder Traversal\n6. Postorder Traversal\n7. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
        case 1:
            printf("Enter value to insert: ");
            scanf("%d", &value);
            root = insert(root, value);
            printf("Inserted %d\n", value);
            break;
        case 2:
            printf("Enter value to delete: ");
            scanf("%d", &value);
            root = deleteNode(root, value);
            printf("Deleted %d (if it existed)\n", value);
            break;
        case 3:
            printf("Enter value to search: ");
            scanf("%d", &value);
            if (search(root, value))
                printf("%d found in BST\n", value);
            else
                printf("%d not found in BST\n", value);
            break;
        case 4:
            printf("Inorder Traversal: ");
            inorder(root);
            printf("\n");
            break;
        case 5:
            printf("Preorder Traversal: ");
            preorder(root);
            printf("\n");
            break;
        case 6:
            printf("Postorder Traversal: ");
            postorder(root);
            printf("\n");
            break;
        case 7:
            printf("Exiting...\n");
            exit(0);
        default:
            printf("Invalid choice! Try again.\n");
        }
    }
    return 0;
}