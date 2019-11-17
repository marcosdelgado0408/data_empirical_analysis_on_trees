package br.com.waldson.arvores;

import br.com.waldson.arvores.abb.BinarySearchTree;
import br.com.waldson.arvores.avl.AVLTree;
import br.com.waldson.arvores.misc.Pessoa;
import br.com.waldson.arvores.redblacktree.RedBlackTree;

import java.util.Random;

public class GerarTempo {
    private int Tam = 500000;
    private int TamSegundoConjunto = 1000000;
    BinarySearchTree binarySearchTree;
    AVLTree<Pessoa> avlTree;
    RedBlackTree redBlackTree;


    public GerarTempo(){
        binarySearchTree = new BinarySearchTree();
        avlTree = new AVLTree<>();
        redBlackTree = new RedBlackTree();
    }




    public long insercaoABB(){

        long inicialTime = System.currentTimeMillis();

        for(int i=1;i<=Tam;i++){
            binarySearchTree.insert(i);
        }

        long finalTime = System.currentTimeMillis();

        return finalTime - inicialTime;
    }


    public  long insercaoAVL(){

        long inicialTime = System.currentTimeMillis();

        for(int i=1;i<=Tam;i++){
            avlTree.insert(new Pessoa(i));
        }

        long finalTime = System.currentTimeMillis();

        return finalTime - inicialTime;

    }

    public  long insercaoRedBlackTree(){

        long inicialTime = System.currentTimeMillis();

        for(int i=1;i<=Tam;i++){
            redBlackTree.insert(i);
        }

        long finalTime = System.currentTimeMillis();

        return finalTime - inicialTime;
    }

// =====================================================================================================================

    public  long buscarDecABB(){

        long inicialTime = System.currentTimeMillis();

        for(int i=Tam;i>=1;i--){
            binarySearchTree.search(i);
        }

        long finalTime = System.currentTimeMillis();

        return finalTime - inicialTime;
    }

    public  long buscarDecAVL(){

        long inicialTime = System.currentTimeMillis();

        for(int i=Tam;i>=1;i--){
            avlTree.search(i);
        }

        long finalTime = System.currentTimeMillis();

        return finalTime - inicialTime;

    }

    public  long buscarDecRedBlackTree(){

        long inicialTime = System.currentTimeMillis();

        for(int i=Tam;i>=1;i--){
            redBlackTree.search(i);
        }

        long finalTime = System.currentTimeMillis();

        return finalTime - inicialTime;
    }

// ===================================================================================================================

    public long removerDecABB(){

        long inicialTime = System.currentTimeMillis();

        for(int i=Tam;i>=1;i--){
            binarySearchTree.remove(i);
        }

        long finalTime = System.currentTimeMillis();

        return finalTime - inicialTime;
    }

    public long removerDecAVL(){

        long inicialTime = System.currentTimeMillis();

        for(int i=Tam;i>=1;i--){
            avlTree.remove(i);
        }

        long finalTime = System.currentTimeMillis();

        return finalTime - inicialTime;
    }

// ====================================================================================================================
// ====================================================================================================================

    public long insercaoAleatoriaABB(){
        Random random = new Random();

        long inicialTime = System.currentTimeMillis();

        for(int i=1;i<=Tam;i++){
            binarySearchTree.insert(random.nextInt(1000000) + 1);
        }

        long finalTime = System.currentTimeMillis();

        return finalTime - inicialTime;
    }

    public long insercaoAleatoriaAVL(){
        Random random = new Random();

        long inicialTime = System.currentTimeMillis();

        for(int i=1;i<=Tam;i++){
            avlTree.insert(new Pessoa(random.nextInt(1000000) + 1));
        }

        long finalTime = System.currentTimeMillis();

        return finalTime - inicialTime;
    }

    public long insercaoAleatoriaRedBlackTree(){
        Random random = new Random();

        long inicialTime = System.currentTimeMillis();

        for(int i=1;i<=Tam;i++){
            redBlackTree.insert(random.nextInt(1000000) + 1);
        }

        long finalTime = System.currentTimeMillis();

        return finalTime - inicialTime;
    }

// =====================================================================================================================

    public long buscarDecABB2(){
        long inicialTime = System.currentTimeMillis();

        for(int i=TamSegundoConjunto;i>=1;i--){
            binarySearchTree.search(i);
        }

        long finalTime = System.currentTimeMillis();

        return finalTime - inicialTime;
    }


    public long buscarDecAVL2(){
        long inicialTime = System.currentTimeMillis();

        for(int i=TamSegundoConjunto;i>=1;i--){
            avlTree.search(i);
        }

        long finalTime = System.currentTimeMillis();

        return finalTime - inicialTime;
    }

    public long buscarDecRedBlackTree2(){
        long inicialTime = System.currentTimeMillis();

        for(int i=TamSegundoConjunto;i>=1;i--){
            redBlackTree.search(i);
        }

        long finalTime = System.currentTimeMillis();

        return finalTime - inicialTime;
    }

// =====================================================================================================================

    public long removerDecABB2(){
        long inicialTime = System.currentTimeMillis();

        for(int i=TamSegundoConjunto;i>=1;i--){
            binarySearchTree.remove(i);
        }

        long finalTime = System.currentTimeMillis();

        return finalTime - inicialTime;
    }

    public long removerDecAVL2(){
        long inicialTime = System.currentTimeMillis();

        for(int i=TamSegundoConjunto;i>=1;i--){
            avlTree.remove(i);
        }

        long finalTime = System.currentTimeMillis();

        return finalTime - inicialTime;
    }


}
