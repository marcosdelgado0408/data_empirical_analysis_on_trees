package br.com.waldson.arvores.redblacktree;
import static br.com.waldson.arvores.redblacktree.RedBlackNode.*;

/*
* Implementação baseada em https://en.wikipedia.org/wiki/Red%E2%80%93black_tree
*/


// TODO necessário ajeitar a remoção de nós, pois não está funcionando

public class RedBlackTree{
    RedBlackNode root = null;

    public RedBlackNode getRoot() { return root; }

    public void showTree(RedBlackNode root){
        System.out.println("key: " + root.getKey());
        if(root.left != null){
            showTree(root.left);
        }
        if(root.right != null){
            showTree(root.right);
        }
    }

    public void insert(int value){
        RedBlackNode node = new RedBlackNode(value);
        insert(node);
    }

    private void insert(RedBlackNode node){
        recursiveInsertion(this.root, node);
        balance(node);

        root = node;
        while (getParent(root) != null){
            root = getParent(root);
        }
    }

    private void recursiveInsertion(RedBlackNode root, RedBlackNode node) {

        if(root != null && node.key < root.key){
            if(root.left != null){
                recursiveInsertion(root.left, node);
                return;
            }
            else {
                root.left = node;
            }
        }
        else if(root != null){
            if(root.right != null){
                recursiveInsertion(root.right, node);
                return;
            }
            else {
                root.right = node;
            }
        }

        node.parent = root;
        node.left = null;
        node.right = null;
        node.color = Color.RED; // Sempre settamos o primeiro nó como Red -> e depois vemos se é necessário balancear
    }

    private void balance(RedBlackNode node) {
        if(getParent(node) == null){
            insertCase1(node);
        }
        else if(getParent(node).color == Color.BLACK){
            // caso 2 -> não é necessário fazer nada
        }
        else if(getUncle(node) != null && getUncle(node).color == Color.RED){
            insertCase3(node);
        }
        else {
            insertCase4(node);
        }
    }

    private void insertCase1(RedBlackNode node){ // caso o novo nó for o root
        if(getParent(node) == null){
            node.color = Color.BLACK;
        }
    }

    /* No caso 2 de inserção, a árvore mantém todas suas propriedades, portanto
    não é necessário fazer nada.*/

    private void insertCase3(RedBlackNode node){ // modificando a cor do pai, do tio e do avô
        getParent(node).color = Color.BLACK;
        getUncle(node).color = Color.BLACK;
        getGrandparent(node).color = Color.RED;
        balance(getGrandparent(node));
    }


    private void insertCase4(RedBlackNode node){
        RedBlackNode parent = getParent(node);
        RedBlackNode grandParent = getGrandparent(node);

        if(node == parent.right && parent == grandParent.left){
            rotateLeft(parent);
            node = node.left;
        }
        else if(node == parent.left && parent == grandParent.right){
            rotateRight(parent);
            node  = node.right;
        }

        insertcase4point2(node);

    }

    private void insertcase4point2(RedBlackNode node) {
        RedBlackNode parent  = getParent(node);
        RedBlackNode grandParent = getGrandparent(node);

        if(node == parent.left){
            rotateRight(grandParent);
        }
        else {
            rotateLeft(grandParent);
        }
        parent.color = Color.BLACK;
        grandParent.color = Color.RED;
    }


    // função que vai substituir "node" no lugar de "toSubstitute"
    private void replaceNode(RedBlackNode toSubistitute , RedBlackNode node){
        node.parent = toSubistitute.parent;
        if(toSubistitute == toSubistitute.parent.left){
            toSubistitute.parent.left = node;
        }
        else {
            toSubistitute.parent.right = node;
        }
    }


    public void deleteNode(int key){
        RedBlackNode redBlackNode = new RedBlackNode(key);
        deleteNode(redBlackNode);
    }

    private void deleteNode(RedBlackNode node){
        RedBlackNode replace;
        if(node.right == null){
            replace = node.left;
        }
        else {
            replace = node.right;
        }

        replaceNode(node, replace);
        if(node.color == Color.BLACK){
            if(replace.color == Color.RED){
                replace.color = Color.BLACK;
            }
            else {
                deleteCase1(replace);
            }
        }
        removeNode(node.key);
    }

    private void deleteCase1(RedBlackNode node) {
        if(node.parent != null){
            deleteCase2(node);
        }
    }

    private void deleteCase2(RedBlackNode node) {
        RedBlackNode sibling = getSibling(node);

        if (sibling.color == Color.RED){
            node.parent.color = Color.RED;
            sibling.color = Color.BLACK;
            if (node == node.parent.left){
                rotateLeft(node.parent);
            }
            else {
                rotateRight(node.parent);
            }

        }
        deleteCase3(node);
    }

    private void deleteCase3(RedBlackNode node) {
        RedBlackNode sibling = getSibling(node);

        if(node.parent.color == Color.BLACK && sibling.color == Color.BLACK && sibling.left.color == Color.BLACK && sibling.right.color == Color.BLACK){
            sibling.color = Color.RED;
            deleteCase1(node.parent);
        }
        else {
            deleteCase4(node);
        }

    }

    private void deleteCase4(RedBlackNode node) {
        RedBlackNode sibling = getSibling(node);

        if(node.parent.color == Color.RED && sibling.color == Color.BLACK && sibling.left.color == Color.BLACK && sibling.right.color == Color.BLACK) {
            sibling.color = Color.RED;
            node.parent.color = Color.BLACK;
        }
        else {
            deleteCase5(node);
        }
    }

    private void deleteCase5(RedBlackNode node) {
        RedBlackNode sibling = getSibling(node);

        if(sibling.color == Color.BLACK){
            if(node == node.parent.left && sibling.right.color == Color.BLACK && sibling.left.color == Color.RED){
                sibling.color = Color.RED;
                sibling.left.color = Color.BLACK;
                rotateRight(sibling);
            }
            else if(node == node.parent.right && sibling.left.color == Color.BLACK && sibling.right.color == Color.RED){
                sibling.color = Color.RED;
                sibling.right.color = Color.BLACK;
                rotateLeft(sibling);
            }
        }
        deletecase6(node);

    }

    private void deletecase6(RedBlackNode node) {
        RedBlackNode sibling  = getSibling(node);

        sibling.color = node.parent.color;
        node.parent.color = Color.BLACK;

        if(node == node.parent.left){
            sibling.right.color = Color.BLACK;
            rotateLeft(node.parent);
        }
        else {
            sibling.left.color = Color.BLACK;
            rotateRight(node.parent);
        }
    }


    private int getSucessorKey(RedBlackNode node) {
        RedBlackNode max = node.getLeft();
        while (max.getRight() != null) {
            max = max.getRight();
        }
        return max.getKey();
    }


        public void removeNode(int key) {
        if (root == null) {
            return;
        }

        RedBlackNode parent  = null;
        RedBlackNode current = root;

        while (true) {
            if (key > current.getKey()) {
                if (current.getRight() != null) {
                    parent  = current;
                    current = current.getRight();
                } else {
                    break;
                }
            } else if (key < current.getKey()) {
                if (current.getLeft() != null) {
                    parent = current;
                    current = current.getLeft();
                } else {
                    break;
                }
            } else {
                if (current.isLeaf()) {
                    if (parent == null) {
                        root = null;
                    } else if (parent.getLeft() == current) {
                        parent.setLeft(null);
                    } else {
                        parent.setRight(null);
                    }
                } else if (current.getRight() == null) {
                    if (parent == null) {
                        root = current.getLeft();
                    } else if (parent.getLeft() == current) {
                        parent.setLeft(current.getLeft());
                    } else {
                        parent.setRight(current.getLeft());
                    }
                } else if (current.getLeft() == null) {
                    if (parent == null) {
                        root = current.getRight();
                    } else if (parent.getLeft() == current) {
                        parent.setLeft(current.getRight());
                    } else {
                        parent.setRight(current.getRight());
                    }
                } else {
                    int sucessorKey = getSucessorKey(current);
                    removeNode(sucessorKey);
                    current.setKey(sucessorKey);
                }
                break;
            }
        }
    }

    public boolean search(int key) {
        RedBlackNode current = root;

        while (current != null) {
            if (key == current.getKey())  {
                return true;
            } else if (key < current.getKey()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }

        return false;
    }


}
