package application;

import java.util.NoSuchElementException;
import java.util.OptionalDouble;

import entites.Lista;

public class SomaLista {

	public static void main(String[] args) {
		new SomaLista();
	}

	public SomaLista() {
		somaLista();
	}

	private void somaLista() {
		Lista<Float> lista = new Lista<>();
		
		for (int num = 1; num <= 10; num++) {
			lista.insereLista(Float.valueOf(num));
		}	

		OptionalDouble optional = soma(lista);
		optional.ifPresentOrElse(e -> System.out.printf("\nA soma de todos os elementos da lista é: %.1f", e), 
				() ->System.out.println("\nNão foi possível somar"));
		
		int inicio = 2,
			fim = 5;
		OptionalDouble optional2 = soma(lista, inicio, fim);
		optional2.ifPresentOrElse(e -> System.out.printf("\nA soma dos elementos presentes entre a posicao %d e %d inclusive é: %.1f", inicio, fim, e), 
				() ->System.out.println("\nNão foi possível somar"));
	}
	
	/*
	Soma todos os números armazenados na lista. Retorna o valor da soma.
	*/
	public static OptionalDouble soma(Lista<? extends Number> lista) {
		return soma(lista, 0 , lista.tamanhoLista()-1);
	}

	/* Soma todos os números armazenados na lista segundo o intervalo especificado pelos parâmetros
	inicio e fim que especificam, respectivamente, a posição inicial e final (inclusive) do intervalo a ser
	somado na lista. Retorna o valor da soma.
	*/
	public static <T extends Number> OptionalDouble soma(Lista<T> lista, int inicio, int fim) {
		try {
			Double soma = 0.0;
	
			for (int i = inicio; i <= fim; i++) {
				soma +=lista.obterElemento(i).get().doubleValue();
			}
			return OptionalDouble.of(soma);
			
		} catch (NoSuchElementException e){
			return OptionalDouble.empty();
		}
	}
	

}
