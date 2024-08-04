package interfaceGenerica;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public interface Pesquisa {

    /*
     * Pesquisa um elemento na lista.
     */
    public default <T extends Comparable<T>> Optional<T> pesquisar(List<T> lista, T elemento) {
        for (T item : lista) {
            if (item.compareTo(elemento) == 0) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

    /*
     * Pesquisa um elemento no vetor. Se o elemento for encontrado retorna a sua posição no vetor
     * encapsulada em um objeto OptionalInt.
     */
    public default <T extends Comparable<T>> OptionalInt pesquisar(T[] vetor, T elemento) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i].compareTo(elemento) == 0) {
                return OptionalInt.of(i);
            }
        }
        return OptionalInt.empty();
    }

    /*
     * Pesquisa um elemento na matriz. Se o elemento for encontrado os índices da linha e coluna de sua
     * posição na matriz devem ser armazenados, respectivamente, nos índices 0 e 1 do vetor de tamanho
     * dois a ser encapsulado no objeto Optional, caso contrário retorna o Optional vazio.
     */
    public static <T extends Comparable<T>> Optional<int[]> pesquisar(T[][] matriz, T elemento) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j].compareTo(elemento) == 0) {
                	
                    return Optional.of(new int[]{i, j});
                }
            }
        }
        return Optional.empty();
    }
}