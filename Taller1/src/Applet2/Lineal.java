package Applet2;

public class Lineal
{
	/*
	 * M�todo que organiza un arreglo de n�meros comparando uno por uno 
	 * @param vector izq  n�meros a organizar
	 * @return vector arregloOrdenado  n�meros organizados 
	 */
	public int[] Ordenar (int[] arreglo) 
    {
        int auxiliar;
        int[] arregloOrdenado;
        for (int i = 1; i < arreglo.length; i++) 
        {
            for (int j = 0; j < arreglo.length - i; j++) 
            {
                if (arreglo[j] >= arreglo[j + 1])
                {
                    auxiliar = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = auxiliar;
                }
            }
        }
        
        return arreglo;
    }
	/*
	 * M�todo que permite la busqueda de un numero
	 * Compara   posicion por posicion  con el numero buscado, si encuentra el numero 
	 * buscado, retorna la en la que se encuentra el numero buscado
	 * @param vector arreglo  
	 * @param entero buscar
	 * @return entero i
	 * @return -1
	 */
    public int Buscar (int[] arreglo, int buscar)
    {
      int n = arreglo.length;
       for (int i = 0; i < n; i++)
        {
             if(arreglo[i] == buscar)
            {
              return i;
              
            }
        }
       return -1;
    }
}