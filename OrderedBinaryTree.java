/*
 * Parent class for ordered binary trees of integers.
 *
 * Note that these trees are immutable: insertion of
 * an element into a tree does not modify the tree, instead
 * a new tree is created and returned by the insert method.
 *
 * When an integer is inserted into a non-empty tree it is
 * either inserted into the left or right sub-tree, depending
 * on whether it is smaller or greater than the integer
 * stored at the root of the tree. Duplicates are discarded.
 */

abstract class OrderedBinaryTree {

    /* Is this tree empty? */
    public abstract boolean isEmpty();

    /* Insert a new element in order. Duplicates are discarded. */
    public abstract OrderedBinaryTree insert(int x);

    /* The number of integers stored in this tree. */
    public abstract int size();

    /* The height of this tree. */
    public abstract int height();

    /* Print the elements of this tree in order from smallest to biggest, each on a separate line. */
    public abstract void print();

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        OrderedBinaryTree t = new EmptyTree();
        for (int i = a - 1; i >= 0; --i) {
            int j = ((b + 1) * (i / (b + 1))) % (c + 1);
            t = t.insert(j);
        }
        //System.out.println(t.height());

        //System.out.println(t.size());
       // t.print();

    }

}

/* Empty trees. */
class EmptyTree extends OrderedBinaryTree {
    public EmptyTree() {
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

        @Override
    public OrderedBinaryTree insert(int x) {        
        EmptyTree left = new EmptyTree();
        EmptyTree right = new EmptyTree();
        
        NonEmptyTree tree = new NonEmptyTree(left, x, right);
        tree.insert(x);
        return tree;
    }   
    @Override
    public int size() {
        return 0;
    }
    
    @Override
    public int height() {
        return 0;
    }

    @Override
    public void print() {    
    }
}
/* Trees with an integer stored at the root and a left and right sub-tree. */
class NonEmptyTree extends OrderedBinaryTree {
     public int data;
     public OrderedBinaryTree left, right;

    public NonEmptyTree(OrderedBinaryTree left, int x, OrderedBinaryTree right) {
        this.left = left;
        this.right = left;
        this.data = x;
    }

    // TO BE COMPLETED
    @Override
    public boolean isEmpty() {
       
        return false;
    }

    @Override
    public OrderedBinaryTree insert(int x) {        
       NonEmptyTree root = new NonEmptyTree(left, data,right);
       return insert(root,x);
    }

   private OrderedBinaryTree insert(OrderedBinaryTree root, int x) {
       if(root.isEmpty()){
           data = x;
           return root;
       }
       if(data < x){
           left = insert(left,x);
       }else if(data > x){
           right = insert(right,x);
       }
       return root;
   
}

   @Override
    public int size() {
        NonEmptyTree tree = new NonEmptyTree(left,data,right);
        return size(tree);
    }

    public int size(OrderedBinaryTree l) {
        if (l.isEmpty()) {
            return 0;
        }
        return size(left) + 1 + size(right);
    }

    @Override
    public int height() {
        NonEmptyTree tree = new NonEmptyTree(left,data,right);
        return height(tree);
    }

    public int height(OrderedBinaryTree l) {
        if (l.isEmpty()) {
            return 0;
        }
        return 1 + Math.max(height(left), height(right));
    }

    @Override
    public void print() {
        NonEmptyTree tree = new NonEmptyTree(left,data,right);
        print(tree);
    }

    public void print(OrderedBinaryTree l) {
        if (l.isEmpty()) {
            print(left);
            System.out.println(data);
            print(right);
        }
    }
}

