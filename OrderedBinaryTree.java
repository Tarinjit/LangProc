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
        t.print();

    }

}

/* Empty trees. */
class EmptyTree extends OrderedBinaryTree {

    public int data;
    public EmptyTree left, right, root;

    public EmptyTree() {
        data = 0;
        left = null;
        right = null;
        root = null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public OrderedBinaryTree insert(int x) {

        return insert(x, root);
    }

    public EmptyTree insert(int x, EmptyTree curr) {
        
        if (curr == null) {
            curr.data = x;
        }else if (x < curr.data) {
            curr.left = insert(x,curr.left);
        }else if (x > curr.data) {
            curr.right = insert(x,curr.right);
        }
        return curr;
    }

    /*
    @Override
    public OrderedBinaryTree insert(int x) {
        EmptyTree tree = new EmptyTree();

        tree.data = x;

        if (root == null) {
            root = tree;
            return this;
        } else {
            EmptyTree current = root;
            EmptyTree parent = null;

            while(true){
            EmptyTree prev = new EmptyTree();

            while (true) {
                parent = current;

              if(current.data == x){
                  continue;
              }  
                if (x < current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = tree;
                        
                        return this;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = tree;
                        return this;
                    }

                }

            }
            }
       }
       //return this;
    }
     */
    @Override
    public int size() {
        return size(root);
    }

    public int size(EmptyTree t) {
        if (t == null) {
            return 0;
        }
        return size(t.left) + 1 + size(t.right);
    }

    @Override
    public int height() {
        return height(root);
    }

    public int height(EmptyTree t) {
        if (t == null) {
            return 0;
        }
        return 1 + Math.max(height(t.left), height(t.right));
    }

    @Override
    public void print() {
        printTree(root);
    }

    public void printTree(EmptyTree t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(" " + t.data);
            printTree(t.right);
        }
    }
}

/* Trees with an integer stored at the root and a left and right sub-tree. */
class NonEmptyTree extends OrderedBinaryTree {

    public NonEmptyTree(OrderedBinaryTree left, int x, OrderedBinaryTree right) {
        // TO BE COMPLETED
    }

    // TO BE COMPLETED
    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrderedBinaryTree insert(int x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int height() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void print() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
