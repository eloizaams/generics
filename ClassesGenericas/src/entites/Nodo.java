package entites;

//classe genérica chamada Nodo para representar um nó de uma lista encadeada.
public class Nodo<E> {
	
	private E elemento;
	private Nodo<E> proximo;
	
	
	public Nodo() {
	}

	public Nodo(E elemento) {
		this.elemento = elemento;
		this.proximo = null;;
	}

	public E getElemento() {
		return elemento;
	}

	public void setElemento(E elemento) {
		this.elemento = elemento;
	}

	public Nodo<E> getProximo() {
		return proximo;
	}

	public void setProximo(Nodo<E> proximo) {
		this.proximo = proximo;
	}


}
