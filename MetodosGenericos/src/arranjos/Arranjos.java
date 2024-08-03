package arranjos;

import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalInt;

public class Arranjos {

	public Arranjos() {
		testarFuncoesGenericas();
	}
	
	public static void main(String[] args) {
		new Arranjos();

	}
	
	/*
	 * testa os métodos genpericos criados na classe
	 */
	private void testarFuncoesGenericas() {
		Integer[] vetor = {1,2,3,4,5,6,7,8,9};
		System.out.println("\nVetor ordem crescente dos índices");
		exibirVetor (vetor, true);
		System.out.println("\nVetor ordem decrescente dos índices");
		exibirVetor (vetor, false);
		System.out.println("\nVetor vazio");
		Double[] vetorDouble = null;
		exibirVetor (vetorDouble, false);


		String[][] matrizStr = {{"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}};
		
		System.out.println("\nTestando exibir matriz");
		
		if (exibirMatriz(matrizStr)) {
			System.out.println("\nReturn = true\n");
		}
		
		String[][] matrizString = {
	            {"a", "b", "c", "d"},
	            {"e", "f", "g", "h"},
	            {"i", "j", "k", "l"},
	            {"m", "n", "o", "p"}
	        };

	      
			System.out.println("Exibe todas as linhas e colunas da matriz.");
	        exibirMatriz(matrizString, 'T', 'T'); 
	        
	        System.out.println("Exibe as linhas da matriz, mas apenas as colunas pares");
	        exibirMatriz(matrizString, 'T', 'P'); 
	        
	        System.out.println("Exibe apenas as linhas e colunas ímpares da matriz.");
	        exibirMatriz(matrizString, 'I', 'I'); 
	        
	        System.out.println("Exibe as linhas pares e as colunas ímpares da matriz.");
	        exibirMatriz(matrizString, 'P', 'I'); 
	        
	        // Exemplo de uso do método pesquisar
	        String[] vetorStr = {"a", "b", "c", "d"};

	      
	        OptionalInt posicao = pesquisar(vetorStr, "c", Comparator.naturalOrder());
	        posicao.ifPresentOrElse(
	            (index) -> System.out.println("Elemento encontrado na posição: " + index),
	            () -> System.out.println("Elemento não encontrado")
	        );
	        
	        String[][] matriz2 = {
	                {"a", "b", "c"},
	                {"d", "e", "f"},
	                {"g", "h", "i"}
	            };

	            // Exemplo de uso do método pesquisar
	            Optional<int[]> posicao2 = pesquisar(matriz2, "e");
	            posicao2.ifPresentOrElse(
	                (indices) -> System.out.println("Elemento encontrado na linha " + indices[0] + ", coluna " + indices[1]),
	                () -> System.out.println("Elemento não encontrado")
	            );
	}

	/* Exibe um vetor no console. Se ordemCrescente é true exibe os elementos do vetor considerando a
	ordem crescente dos índices (0 a N - 1, onde N é o tamanho do vetor); se false, exibe os elementos na
	ordem inversa. Se o vetor tiver tamanho zero ou for null retorna false e não exibe nada no console.
	Retorna true se o vetor foi exibido.
	*/
	public static <T> boolean exibirVetor (T[] vetor, boolean ordemCrescente) {
		if (vetor == null || vetor.length == 0) {
			return false;
		}
		if (ordemCrescente) {
			for(int i = 0; i < vetor.length; i++) 
				System.out.print(vetor[i].toString()+ " | ");
		}
		else {
			for(int i = vetor.length -1; i >=0; i--) 
				System.out.print(vetor[i].toString() + " | ");
		}
		System.out.println("\n");
		return true;
	}
	
	/* Exibe no console os elementos da matriz no formato tabular. Se a matriz tiver tamanho zero ou for
	null retorna false e não exibe nada no console. Retorna true se a matriz foi exibida.
	*/
	public static <T> boolean exibirMatriz (T[][] matriz) {
		return exibirMatriz(matriz, 'T', 'T');
	}
	
	/* Exibe no console os elementos da matriz no formato tabular. Se a matriz tiver tamanho zero ou for
	null retorna false e não exibe nada no console. Retorna true se a matriz foi exibida. O conteúdo da
	matriz a ser exibido depende dos seguintes valores dos parâmetros linhas e colunas:
	- ‘T’: exibe as linhas e/ou colunas da matriz;
	- ‘P’: exibe as linhas e/ou colunas pares da matriz;
	- ‘I’: exibe as linhas e/ou colunas ímpares da matriz.
	Exemplos:
	exibirMatriz(mat5x5, ‘T’, ‘T’); // Exibe todas as linhas e colunas da matriz.
	exibirMatriz(mat5x5, ‘T’, ‘P’); // Exibe as linhas da matriz, mas apenas as colunas pares.
	exibirMatriz(mat5x5, ‘I’, ‘I’); // Exibe apenas as linhas e colunas ímpares da matriz.
	exibirMatriz(mat5x5, ‘P’, ‘I’); // Exibe as linhas pares e as colunas ímpares da matriz.
	*/
	public static <T> boolean exibirMatriz (T[][] matriz, char linhas, char colunas) {
		if ( matriz == null || matriz.length == 0) 
			return false;
		
		int incrementoLinha = 1, 
			inicioLinha = 0, 
			incrementoColuna = 1, 
			inicioColuna = 0;
		
		if (linhas != 'T') 
			incrementoLinha = 2;
		
		if (linhas == 'P')
			inicioLinha = 1;
		if (colunas != 'T') 
			incrementoColuna = 2;
		
		if (colunas == 'P')
			inicioColuna = 1;
		
		for(int linha = inicioLinha; linha < matriz.length; linha += incrementoLinha) {
			final String BARRA = "  |  ";
			System.out.print( BARRA);
			int caracteresLinha = BARRA.length();
			for(int coluna = inicioColuna; coluna < matriz[linha].length; coluna += incrementoColuna) {
				String texto = matriz[linha][coluna].toString() + BARRA;
				System.out.print(texto);
				caracteresLinha += texto.length();
			}
		System.out.println("\n" + "-".repeat(caracteresLinha));
		}
		return true;
	}
	
	
	/* Pesquisa um elemento no vetor. Se o elemento for encontrado retorna a sua posição no vetor
	encapsulada em um objeto OptionalInt.
	*/
	public static <T extends Comparable<T>> OptionalInt pesquisar(T[] vetor, T elemento) {
		for(int i = 0; i < vetor.length; i++) {
			if (vetor[i].equals(elemento)) {
				return OptionalInt.of(i);
			}
		}
		return OptionalInt.empty();
	}

	/* Pesquisa um elemento no vetor usando um critério de comparação fornecido. Se o elemento for
	encontrado retorna a sua posição no vetor encapsulada em um objeto OptionalInt.
	*/
	public static <T> OptionalInt pesquisar(T[] vetor, T elemento, Comparator <? super T> comparator) {
		for(int i = 0; i < vetor.length; i++) {
			   if (comparator.compare(vetor[i], elemento) == 0) {
				return OptionalInt.of(i);
			}
		}
		return OptionalInt.empty();
	}
	
	/* Pesquisa um elemento na matriz. Se o elemento for encontrado os índices da linha e coluna de sua
	posição na matriz devem ser armazenados, respectivamente, nos índices 0 e 1 do vetor de tamanho
	dois a ser encapsulado no objeto Optional, caso contrário retorna o Optional vazio.
	*/
	public static <T extends Comparable<T>> Optional<int[]> pesquisar(T[][] matriz, T elemento){
		for(int linha = 0; linha < matriz.length; linha++) {
			for(int coluna = 0; coluna < matriz[linha].length; coluna++) {
				if(matriz[linha][coluna].equals(elemento)) {	
					return Optional.of(new int[]{linha, coluna});
				}
			}
		}
		return Optional.empty();
	}
	
}
