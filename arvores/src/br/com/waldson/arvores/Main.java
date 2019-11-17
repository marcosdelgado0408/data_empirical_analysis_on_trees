package br.com.waldson.arvores;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Main {

    public static void main(String[] args) {

        GerarTempo gerarTempo = new GerarTempo();


        // inserção ABB
            long tempoExecInsertABB = gerarTempo.insercaoABB();
        System.out.println("inseriu abb");

        // inserção AVL
            long tempoExecInsertAVL = gerarTempo.insercaoAVL();
        System.out.println("inseriu avl");

        // inserção RedBlackTree
            long tempoExecInsertRedBlackTree = gerarTempo.insercaoRedBlackTree();
        System.out.println("inseriu rbt");

        DefaultCategoryDataset insercaoDataset = new DefaultCategoryDataset();
        insercaoDataset.addValue(tempoExecInsertABB, "tempo de execução", "ABB");
        insercaoDataset.addValue(tempoExecInsertAVL, "tempo de execução", "AVL");
        insercaoDataset.addValue(tempoExecInsertRedBlackTree, "tempo de execução", "REDBLACKTREE");
        JFreeChart insercaoFreeChart = ChartFactory.createLineChart("Análise Empririca\nInserção crescente ABB, AVL e RedBlackTree", "Árvore", "Tempo de execução(ms)", insercaoDataset, PlotOrientation.VERTICAL, true, true, false);

        try {
            File insercaoFile = new File("grafico_insercoes.png");
            FileOutputStream outputStream = new FileOutputStream(insercaoFile);
            ChartUtils.writeChartAsPNG(outputStream, insercaoFreeChart, 500, 500);
            outputStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        // busca ABB
            long tempoBuscaABB = gerarTempo.buscarDecABB();
        System.out.println("buscou abb");

        // Busca AVL
            long tempoBuscaAVL = gerarTempo.buscarDecAVL();
        System.out.println("buscou avl");

        // Busca RedBlackTree
            long tempoBuscaRedBlackTree = gerarTempo.buscarDecRedBlackTree();
        System.out.println("buscou rbt");

        DefaultCategoryDataset buscaDataSet = new DefaultCategoryDataset();
        buscaDataSet.addValue(tempoBuscaABB, "tempo de execução", "ABB");
        buscaDataSet.addValue(tempoBuscaAVL, "tempo de execução", "AVL");
        buscaDataSet.addValue(tempoBuscaRedBlackTree, "tempo de execução", "REDBLACKTREE");
        JFreeChart buscaFreeChart = ChartFactory.createLineChart("Análise Empririca\nBusca Decrescente ABB, AVL e RedBlackTree", "Árvore", "Tempo de execução(ms)", buscaDataSet, PlotOrientation.VERTICAL, true, true, false);

        try {

            File buscaFile = new File("grafico_busca.png");
            OutputStream outputStream = new FileOutputStream(buscaFile);
            ChartUtils.writeChartAsPNG(outputStream, buscaFreeChart, 500, 500);
            outputStream.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        // remoção ABB
            long tempoRemocaoABB = gerarTempo.removerDecABB();
        System.out.println("removeu abb");
        // remoção AVL
            long tempoRemocaoAVL = gerarTempo.removerDecAVL();
        System.out.println("removeu avl");

        DefaultCategoryDataset remocaoDataset = new DefaultCategoryDataset();
        remocaoDataset.addValue(tempoRemocaoABB, "tempo de execução", "ABB");
        remocaoDataset.addValue(tempoRemocaoAVL, "tempo de execução", "AVL");
        JFreeChart remocaoFreeChart = ChartFactory.createLineChart("Análise Empririca\nRemoção Decrescente ABB e AVL", "Árvore", "Tempo de execução(ms)", remocaoDataset, PlotOrientation.VERTICAL, true, true, false);

        try {

            File remocaoFile = new File("grafico_remocao.png");
            OutputStream outputStream = new FileOutputStream(remocaoFile);
            ChartUtils.writeChartAsPNG(outputStream, remocaoFreeChart, 500, 500);
            outputStream.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }

//=========================================================================================================================================================================================================================
//=========================================================================================================================================================================================================================

        // inserção aleatória ABB
            long randomInsertABBTime = gerarTempo.insercaoAleatoriaABB();
        System.out.println("inseriu aleatoriamente abb");

        // inserção aleatória AVL
            long randomInsertAVLTime = gerarTempo.insercaoAleatoriaAVL();
        System.out.println("inseriu aleatoriamente AVL");

        // inserção aleatória RedBlackTree
            long randomInsertRedBlackTreeTime = gerarTempo.insercaoAleatoriaRedBlackTree();
        System.out.println("inseriu aleatoriamente rbt");

        DefaultCategoryDataset insercaoAleDataSet = new DefaultCategoryDataset();
        insercaoAleDataSet.addValue(randomInsertABBTime, "tempo de execução", "ABB");
        insercaoAleDataSet.addValue(randomInsertAVLTime, "tempo de execução", "AVL");
        insercaoAleDataSet.addValue(randomInsertRedBlackTreeTime, "tempo de execução", "REDBLACKTREE");
        JFreeChart insercaoAleFreeChart = ChartFactory.createLineChart("Análise Empririca\nInserção aleatória ABB, AVL e RedBlackTree", "Árvore", "Tempo de execução(ms)", insercaoAleDataSet, PlotOrientation.VERTICAL, true, true, false);

        try {

            File insercaoAleFile = new File("grafico_insercao_aleatoria.png");
            OutputStream outputStream = new FileOutputStream(insercaoAleFile);
            ChartUtils.writeChartAsPNG(outputStream, insercaoAleFreeChart, 500, 500);
            outputStream.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        // busca 1.000.000 ABB
        long tempoBuscaABB1M = gerarTempo.buscarDecABB2();
        System.out.println("buscou abb um milhao");

        // Busca 1.000.000 AVL
        long tempoBuscaAVL1M = gerarTempo.buscarDecAVL2();
        System.out.println("buscou avl um milhao");

        // Busca RedBlackTree
        long tempoBuscaRedBlackTree1M = gerarTempo.buscarDecRedBlackTree2();
        System.out.println("buscou rbt um milhao");

        DefaultCategoryDataset busca1MDataSet = new DefaultCategoryDataset();
        busca1MDataSet.addValue(tempoBuscaABB1M, "tempo de execução", "ABB");
        busca1MDataSet.addValue(tempoBuscaAVL1M, "tempo de execução", "AVL");
        busca1MDataSet.addValue(tempoBuscaRedBlackTree1M, "tempo de execução", "REDBLACKTREE");
        JFreeChart busca1MFreeChart = ChartFactory.createLineChart("Análise Empririca\nBusca Decrescente ABB, AVL e RedBlackTree", "Árvore", "Tempo de execução(ms)", busca1MDataSet, PlotOrientation.VERTICAL, true, true, false);

        try {

            File busca1MFile = new File("grafico_busca_1_milhao_elementos.png");
            OutputStream outputStream = new FileOutputStream(busca1MFile);
            ChartUtils.writeChartAsPNG(outputStream, busca1MFreeChart, 500, 500);
            outputStream.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // remoção ABB 1 milhao
        long tempoRemocaoABB1M = gerarTempo.removerDecABB2();
        System.out.println("removeu abb 1 milhao de alementos");
        // remoção AVL
        long tempoRemocaoAVL1M = gerarTempo.removerDecAVL2();
        System.out.println("removeu avl 1 milhao de elementos");

        DefaultCategoryDataset remocaoDataset1M = new DefaultCategoryDataset();
        remocaoDataset1M.addValue(tempoRemocaoABB1M, "tempo de execução", "ABB");
        remocaoDataset1M.addValue(tempoRemocaoAVL1M, "tempo de execução", "AVL");
        JFreeChart remocao1MFreeChart = ChartFactory.createLineChart("Análise Empririca\nRemoção Decrescente ABB e AVL", "Árvore", "Tempo de execução(ms)", remocaoDataset1M, PlotOrientation.VERTICAL, true, true, false);

        try {

            File remocao1MFile = new File("grafico_remocao_1_milhao_elementos.png");
            OutputStream outputStream = new FileOutputStream(remocao1MFile);
            ChartUtils.writeChartAsPNG(outputStream, remocao1MFreeChart, 500, 500);
            outputStream.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }




    }









}
