public class ArvoreBinaria {

    Node root;

    public ArvoreBinaria() {
        root = null;
    }

    public void insert(int data){
       root = insertRecursive(root, data);
    }
    public Node insertRecursive(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if(data < root.data){
            root.left = insertRecursive(root.left, data);
        }
        if(data >= root.data){
            root.right = insertRecursive(root.right, data);
        }

        return root;
    }

    public void preOrder(){
        preOrderRecursive(root);
    }

    public void preOrderRecursive(Node root){
        if(root != null){
            System.out.print(root.data + " ");
            preOrderRecursive(root.left);
            preOrderRecursive(root.right);
        }
    }

    public void inOrder(){
        inOrderRecursive(root);
    }

    public void inOrderRecursive(Node root){
        if(root != null){
            inOrderRecursive(root.left);
            System.out.print(root.data + " ");
            inOrderRecursive(root.right);
        }
    }

    public void postOrder(){
        postOrderRecursive(root);
    }

    public void postOrderRecursive(Node root){
        if(root != null){
            postOrderRecursive(root.left);
            postOrderRecursive(root.right);
            System.out.print(root.data + " ");
        }
    }

    public boolean findElement(int data){
        return findElementRecursive(root, data);
    }

    public boolean findElementRecursive(Node root, int data){
        if(root == null){
           return false;
        }
        if(root.data == data){
            return true;
        }
        return (data < root.data) ? findElementRecursive(root.left, data) : findElementRecursive(root.right, data);
    }

    public Node max(Node root){
        return maxRecursive(root);
    }

    public Node maxRecursive(Node root){
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            return root;
        }
        if(root.left != null){
            return maxRecursive(root.left);
        }
        if(root.right != null){
            return maxRecursive(root.right);
        }
        return root;
    }

    public Node min(Node root){
        return minRecursive(root);
    }

    public Node minRecursive(Node root){
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            return root;
        }
        if(root.left != null){
            return minRecursive(root.left);
        }
        if(root.right != null){
            return minRecursive(root.right);
        }
        return root;
    }
}
