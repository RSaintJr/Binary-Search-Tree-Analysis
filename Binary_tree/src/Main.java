import Tree.*;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // Tamanhos de entrada a serem testados

        int[] tamanhosEntrada = { 100000, 1000000 };

        // Executa algoritmo para cada tamanho de entrada
        for (int tamanho : tamanhosEntrada) {
			int[] entrada = gerarEntrada_aleatoria(tamanho);
//			int[] entrada = gerarEntrada_ordenada(tamanho);

            B_Tree arvore = new B_Tree(8);
            for (int i = 0; i < tamanho; i++){
                arvore.inserir(entrada[i]);
            }


            // Marca o tempo de início
            long inicio = System.nanoTime();

            // Chama o algoritmo a ser testado
            meuAlgoritmo(entrada,arvore);


            // Marca o tempo de fim
            long fim = System.nanoTime();

            // Calcula o tempo de execução em milissegundos
            double tempoExecucao = Math.round((fim - inicio) / 1000000.0);

            System.out.println("Tempo de execucao para tamanho " + tamanho + ": " + tempoExecucao + "ms");
        }

    }

    public static void meuAlgoritmo(int[] arr, B_Tree arvore) {
        for (int i = 0; i < arr.length; i++){
            arvore.remover(arr[i]);
        }

//        arvore.buscar(999999999);
    }

    // Gera uma entrada aleatória para testes
    public static int[] gerarEntrada_aleatoria(int tamanho) {
        int[] arr = new int[tamanho];
        Random random = new Random();

        for (int i = 0; i < tamanho; i++) {
            arr[i] = random.nextInt(Integer.MAX_VALUE);
        }

        return arr;
    }


    // Gera uma entrada ordenada para testes.
    public static int[] gerarEntrada_ordenada(int tamanho) {
        int[] arr = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            arr[i] = i;
        }
        return arr;
    }
}