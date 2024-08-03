package application;

import java.util.Optional;

import entites.Lista;

public class ClasseGenericaTest {
	

	public ClasseGenericaTest() {
		testaClasseGenerica();
	}
	
	public static void main(String[] args) {
		new ClasseGenericaTest();

	}
	
	//Método para testar as classes genéricas Nodo e Lista criadas
	private void testaClasseGenerica() {
		Lista<String> lista = new Lista<>();
		
		for (int i = 'a'; i <= 'j'; i++) {
			lista.insereLista(Character.toString(i));
		}
		System.out.printf("\nLista criada com %d elementos\n", lista.tamanhoLista());
		
		
		String elemento = "c";
		System.out.printf("\nO elemento %s está na posição %d\n", elemento, lista.pesquisaElemento(elemento));
		
		int posicao = 2;
		Optional<String> optional = lista.obterElemento(posicao);

		optional.ifPresentOrElse(
		    e -> System.out.printf("\nO elemento '%s' está na posição %d\n", e, posicao),
		    () -> System.out.println("Elemento não encontrado")
		);
		
		
		 // Remove o elemento 'c'
	    boolean removido = lista.removeLista(elemento);
	    if (removido) {
	        System.out.printf("\nO elemento '%s' foi removido com sucesso\n", elemento);
	    } else {
	        System.out.printf("\nO elemento '%s' não foi encontrado para ser removido\n", elemento);
	    }
		
	}

}
