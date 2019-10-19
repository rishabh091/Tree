package tree;

/*
* class that have all the necessary functions to implement tree
* */
public class Tree {
    private Node root=null;

    /*
    * function to add element in tree
    * */
    public void insert(int data){
        root=insertRoot(root,data);
    }
    /*
    * recursive function to add element in tree
    * if root is null that means the tree is empty and then it will add data to root and will break out of recursion
    * */
    private Node insertRoot(Node root,int data){
        if(root==null){
            root=new Node(data);
            return root;
        }
        else{
            if(data > root.data){
                root.right=insertRoot(root.right,data);
            }
            else if(data < root.data){
                root.left=insertRoot(root.left,data);
            }
            else{
                System.err.println("A tree must have unique values.");
            }

            return root;
        }
    }

    /*
    * function to display tree in inorder traversal
    * */
    public void inorderDisplay(){
        System.out.println("Inorder traversal : ");
        inorderDisplayRoot(root);
    }
    /*
    * recursive function to display tree in inorder traversal
    * */
    private void inorderDisplayRoot(Node root){
        if(root != null){
            inorderDisplayRoot(root.left);
            System.out.println(root.data);
            inorderDisplayRoot(root.right);
        }
    }

    /*
    * function to display tree in pre order traversal
    * */
    public void preOrderDisplay(){
        System.out.println("Pre order traversal : ");
        preOrderDisplayRoot(root);
    }
    /*
    * recursive function to display tree in pre order traversal
    * */
    private void preOrderDisplayRoot(Node root){
        if(root != null){
            System.out.println(root.data);
            preOrderDisplayRoot(root.left);
            preOrderDisplayRoot(root.right);
        }
    }

    /*
    * function to display tree in post order traversal
    * */
    public void postOrderDisplay(){
        System.out.println("Post order traversal : ");
        postOrderDisplayRoot(root);
    }
    /*
    * recursive function to display tree in post order traversal
    * */
    private void postOrderDisplayRoot(Node root){
        if(root != null){
            postOrderDisplayRoot(root.left);
            postOrderDisplayRoot(root.right);
            System.out.println(root.data);
        }
    }

    /*
    * function to count no of nodes in tree
    * */
    public int size(){
        return sizeRoot(root,0);
    }
    /*
    * recursive function to count number of root
    * */
    private int sizeRoot(Node root,int count){
        if(root!=null){
            count=sizeRoot(root.left,count);
            count++;
            count=sizeRoot(root.right,count);
        }
        return count;
    }

    /*
    * function to call no of leaf nodes in a tree
    * */
    public int leafCount(){
        return leafCountRoot(root,0);
    }
    /*
    * recursive function to check whether the node is leaf node or not if the node is leaf node
    * then increasing and returning the count
    * */
    private int leafCountRoot(Node root,int count){
        if(root != null){
            if(root.left == null && root.right == null){
                count++;
            }
            count=leafCountRoot(root.left,count);
            count=leafCountRoot(root.right,count);
        }

        return count;
    }

    /*
    * contains function will return return true if the given element is present in tree and false if not
    * */
    public boolean contains(int data){
        return containsRoot(root,data,false);
    }
    /*
    * recursive to check whether the element exist in tree or not
    * */
    private boolean containsRoot(Node root, int data, boolean result){
        if(root != null){
            if(root.data == data){
                result=true;
            }
            if(!result){
                result=containsRoot(root.left,data,result);
                result=containsRoot(root.right,data,result);
            }
        }

        return result;
    }

    /*
    * function to get minimum element from a tree
    * */
    public int getMin(){
        return getMinRoot(root).data;
    }
    /*
    * recursive function to get minimum element from a tree
    * it will check whether the left node of the tree is null or not and will traverse to the last left node
    * and then return the last left node which is the smallest element in binary search tree
    * */
    private Node getMinRoot(Node root){
        if(root.left != null){
            root=getMinRoot(root.left);
        }

        return root;
    }

    /*
    * function to get maximum element from a tree
    * */
    public int getMax(){
        return getMaxRoot(root).data;
    }
    /*
    * recursive function to get maximum element from a tree
    * it will check and traverse to the right most node of the root which will be the largest node of
    * the tree and then we will extract the data from that node
    * */
    private Node getMaxRoot(Node root){
        if(root.right != null){
            root=getMaxRoot(root.right);
        }

        return root;
    }

    /*
    * function to get level of tree
    * */
    public int getLevel(){
        return getLevelRoot(root,0);
    }
    /*
    * recursive function to get level of the tree
    * I DONT KNOW HOW THIS WORKS
    * */
    private int getLevelRoot(Node root,int level){
        if(root == null){
            return level;
        }
        else{
            level++;
            int ldepth=getLevelRoot(root.left,level);
            int rdepth=getLevelRoot(root.right,level);

            if(ldepth > rdepth){
                return ldepth;
            }
            else{
                return rdepth;
            }
        }
    }
}

/*
* Node class to create own data structure
* */
class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data=data;
    }
}
