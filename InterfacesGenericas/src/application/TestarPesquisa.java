package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import interfaceGenerica.Pesquisa;

public class TestarPesquisa implements Pesquisa{

    public TestarPesquisa() {
        executaTestarPesquisa();
    }

    private void executaTestarPesquisa() {
        List<String> lista1 = new ArrayList<>(Arrays.asList("fubá", "arroz", "feijão", "açúcar"));
        List<Integer> lista2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        Integer[] vetor1 = {10, 20, 30, 40, 50};
        String[] vetor2 = {"a", "b", "c", "d"};
        String[][] matrizString = {
            {"a", "b", "c", "d"},
            {"e", "f", "g", "h"},
            {"i", "j", "k", "l"},
            {"m", "n", "o", "p"}
        };
        Double[][] matriz2 = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0, 6.0},
            {7.0, 8.0, 9.0}
        };

        // Executando e imprimindo resultados dos testes
        System.out.println("Resultado da pesquisa:");
        System.out.println("Lista1: " + testarPesquisa(lista1, "arroz").get());
        System.out.println("Lista2: " + testarPesquisa(lista2, 4).get());
        System.out.println("Vetor1: " + testarPesquisa(vetor1, 10).get());
        System.out.println("Vetor2: " + testarPesquisa(vetor2, "c").get());
   
        Optional<?> resultadoMatrizString = testarPesquisa(matrizString, "g");
        imprimirIndices(resultadoMatrizString, "MatrizString");

        Optional<?> resultadoMatriz2 = testarPesquisa(matriz2, 5.0);
        imprimirIndices(resultadoMatriz2, "Matriz2");
    }

    private void imprimirIndices(Optional<?> resultado, String nomeDaMatriz) {
        if (resultado.isPresent() && resultado.get() instanceof int[]) {
            int[] indices = (int[]) resultado.get();
            System.out.println(nomeDaMatriz + ": Linha " + indices[0] + ", Coluna " + indices[1]);
        } else {
            System.out.println(nomeDaMatriz + ": Elemento não encontrado.");
        }
    }

    /*
     * Método genérico para testar pesquisa sobre listas, vetores ou matrizes
     */
    @SuppressWarnings("unchecked")
	private <E extends Comparable<E>> Optional<?> testarPesquisa(Object estrutura, E elemento) {
    	
        if (estrutura instanceof List<?>) {
            return Optional.ofNullable(pesquisar((List<E>) estrutura, elemento).orElse(null));
        } else if (estrutura instanceof Comparable<?>[]) {
            return Optional.ofNullable(pesquisar((E[]) estrutura, elemento).getAsInt());
        } else if (estrutura instanceof Comparable<?>[][]) {
            return Optional.ofNullable(Pesquisa.pesquisar((E[][]) estrutura, elemento).orElse(null));
        } else {
            return Optional.empty();
        }
    }

	public static void main(String[] args) {
        new TestarPesquisa(); 
    }


}
