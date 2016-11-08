package Applet1;

public class Counting {

    /*
     * Este método organiza un arreglo de números
     * <b>pre:</b> Se evalua cual es el minimo y cual es el maximo en ese conjunto de números 
     * luego se crea un vector con la cantidad de numeros que se encuentran en el conjuntos de numeros<br>
     * <b>post:</b> recorren todos los elementos a ordenar y en el vector se guarda la cuenta la cantidad de numeros repetidos
     * recorriendo una ultima vez para tener ese conjunto de numeros ordenados <br>
     * @param vector arreglo_inicial
     * @return vector arreglo_inicial
     */
	public  int [] countingSort(int[]arreglo_inicial)
	{
		int tamano = arreglo_inicial.length,maximo=0,indice=0;
		for(int i=0;i<tamano;i++)
		{
			maximo=arreglo_inicial[i] > maximo ? arreglo_inicial[i] : maximo; // If ternario
		}
		int[] aux = new int[maximo+1];
		for(int i=0;i<tamano;i++)
		{
			aux[arreglo_inicial[i]]+=1;
		}
		for(int i=0;i<=maximo;i++)
		{
			for(int j=0;j<aux[i];j++)
			{
				arreglo_inicial[indice]=i;
				indice++;
			}
		}
		return arreglo_inicial;
	}

}
