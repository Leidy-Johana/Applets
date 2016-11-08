package Applet2;

public class Binary
{
	/*
	 * Método que organiza un arreglo de números comparando uno por uno 
	 * @param vector arreglo  números a organizar
	 * @return vector arreglo  números organizados 
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
	 * Método que permite la busqueda de un numero
	 * <b>pre:</b>Escoge un inicio y un fin de los cuales saca la mitad 
	 * pregunta si el dato de la mitad es gual al buscado si lo es, lo retorna
	 * <b>post:</b> Si no el minimo sera el dato de la mitad mas 1 y seguira preguntando hasta
	 * hallar el numero buscado
	 * @param vector vector  
	 * @param entero usuario
	 * @return m
	 * @return -1
	 */
	public int binary(int[] vector, int usuario)
	{
		int fin = vector.length - 1;
		int inicio = 0;
		int m=-1;
		while (inicio <= fin) {
			m = (inicio + fin) / 2;
			if (vector[m] == usuario) {
				return m;
        } else
        {
         if (usuario > vector[m])
         {
               inicio = m + 1;
         } else 
         {
        	 	
                fin = m - 1;
         }
         
        }
         
    }
    
		return -1;
	}
}