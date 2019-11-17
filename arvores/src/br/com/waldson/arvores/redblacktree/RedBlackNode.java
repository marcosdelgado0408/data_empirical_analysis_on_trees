package br.com.waldson.arvores.redblacktree;

public class RedBlackNode {
    RedBlackNode right;
    RedBlackNode left;
    RedBlackNode parent;
    Color color;
    int key;

    public RedBlackNode(int key) {
        this.key = key;
    }

    public RedBlackNode getRight() { return right; }

    public void setRight(RedBlackNode right) { this.right = right; }


    public RedBlackNode getLeft() { return left; }

    public void setLeft(RedBlackNode left) { this.left = left; }


    public Color getColor() { return color; }

    public void setColor(Color color) { this.color = color; }


    public int getKey() { return key; }

    public void setKey(int key) { this.key = key; }


    public static RedBlackNode getParent(RedBlackNode node) {
        if(node.parent == null){
            return null;
        }
        else {
            return node.parent;
        }
        // return parent == null ? null : node.parent;
    }

    public static RedBlackNode getGrandparent(RedBlackNode node){
        return getParent(getParent(node)); // retornando o avô do nó
    }

    public static RedBlackNode getSibling(RedBlackNode node){
        RedBlackNode parent = getParent(node);

        if(parent == null){
            return null;
        }

        // se você é filho esquerdo do seu pai, seu irmão será o filho direito do seu pai
        if(node == parent.left){
            return parent.right;
        }
        // se você é filho direito do seu pai, seu irmão será o filho resquerdo do seu pai
        else {
            return parent.left;
        }

    }

    public static RedBlackNode getUncle(RedBlackNode node){
        RedBlackNode parent =  node.parent;

        // retornando o outro filho(que não seja seu pai) do seu avô, ou seja, seu tio
        return getSibling(parent);
    }

    public static void rotateLeft(RedBlackNode node){
        RedBlackNode nodeRight = node.right;
        RedBlackNode parent = getParent(node);
        assert nodeRight != null;

        node.right = nodeRight.left;
        nodeRight.left = node;
        node.parent = nodeRight;

        if(node.right != null){
            node.right.parent = node;
        }

        if(parent != null){
            if(node == parent.left){
                parent.left = nodeRight;
            }
            else if(node == parent.right){
                parent.right = nodeRight;
            }
        }

        nodeRight.parent = parent;

    }

    public static void rotateRight(RedBlackNode node){
        RedBlackNode nodeLeft = node.left;
        RedBlackNode parent = getParent(node);
        assert nodeLeft != null;

        node.left = nodeLeft.right;
        nodeLeft.right = node;
        node.parent = nodeLeft;

        if(node.left != null){
            node.left.parent = node;
        }

        if(parent != null){
            if(node == parent.right){
                parent.right = nodeLeft;
            }
            else if(node == parent.left){
                parent.left = nodeLeft;
            }
        }

        nodeLeft.parent = parent;

    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    @Override
    public String toString() {
        return String.valueOf(this.key);
    }
}
