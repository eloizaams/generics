package entites;

import java.util.Optional;

//classe genérica chamada Lista para representar o tipo abstrato de dados lista encadeada.
public class Lista<E> {
	
	private Nodo<E> inicio;
	private Nodo<E> fim;
	private int tamanho;
	
	// cria uma lista vazia
	public Lista() {
		this.inicio = null;
		this.fim = null;
		tamanho = 0;
	}

	//insere um novo elemento do tipo E no final da lista
	public boolean insereLista(E elemento) {
		Nodo<E> novoNodo = new Nodo<>(elemento);
		
		if (listaVazia()) {
			inicio = novoNodo;
			fim = novoNodo;
		}
		else {
			fim.setProximo(novoNodo);
			fim = novoNodo;
		}
		tamanho++;
		return true;
	}
	
	public boolean removeLista(E elemento) {
		if (!listaVazia()) {
			
			Nodo<E> atual, anterior;
			atual = inicio;
			anterior = atual; 
			 
			while(atual.getProximo() != null) {
				if (atual.getElemento().equals(elemento)) {
					anterior.setProximo(atual.getProximo());	
					tamanho--;
					return true;
				}
				anterior = atual;
				atual = atual.getProximo();
			}
		}
		return false;
		
	}
	
	//Pesquisa o elemento E na lista e retorna a posição de sua primeira ocorrência, indexada a partir de zero
	public int pesquisaElemento(E elemento) {
		int corrente = -1;
		int posicao = corrente;
		
		if (!listaVazia()) {
			Nodo<E> atual = inicio;		 
			while(atual.getProximo() != null) {
				corrente++;
			
				if (atual.getElemento().equals(elemento)) {
					posicao = corrente;
					break;
				} 
				atual = atual.getProximo();
			}
		}
		return posicao;	
	}
	
	public Optional<E> obterElemento (int posicao){
		if (!listaVazia() && posicao >= 0 && posicao < tamanho) {
			Nodo<E> atual = inicio;		
			int posicaoAtual = -1;
			while(posicaoAtual < tamanho) {
				posicaoAtual++;
				if (posicaoAtual == posicao) {
					
					return Optional.of(atual.getElemento());
				}
				atual = atual.getProximo();
			}
		}
		return Optional.empty();
		
	}
	
	public int tamanhoLista() {
		return tamanho;
	}
	
	public boolean listaVazia() {
		return tamanho == 0;
	}
	
	
	
	

}
