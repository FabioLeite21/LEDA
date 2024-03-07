package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if(array != null && leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length){
			int[] c = new int [getBigger(array, leftIndex, rightIndex)];
			

			// Relembrando: O Counting Sort tem 3 laços principais:
			// (1) Percorre o array A (tamanho array.length)
			// (2) Percorre o array C (tamanho bigger)
			// (3) Percorre novamente o array A

			// Frequência:
			for(int i = leftIndex; i < rightIndex + 1; i++){
				c[array[i]]++;
			}

			// Cumulativa:
			for(int i = 1; i < c.length; i++){
				c[i] += c[i -1];
			}

			int[] b = new int[rightIndex - leftIndex + 1]; // aqui não é int[array.length] pois não estamos ordenando, necessariamente, todo o array
		
			for(int i = rightIndex; i >= leftIndex; i --){
				b[c[array[i]] - 1] = array[i];
				c[array[i]] --;
			}
		

			// "Ordenando":
			int indexB = 0;
			for(int i = leftIndex; i < rightIndex + 1; i++){
				array[i] = b[indexB];
				indexB++;
			}
		}
	}

	public static int getBigger(Integer[] array, int leftIndex, int rightIndex){
		int bigger = array[leftIndex];
		// Busca linear

		for(int i = leftIndex; i < rightIndex +1; i++){
			if(array[i].compareTo(bigger) > 0){
				bigger = array[i];
			}
		}
		return bigger;

	}
	
	

}
