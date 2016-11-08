package Applet2;

public class Interpolation
{
	/*
	 * Método que organiza un arreglo de números comparando uno por uno 
	 * @param vector izq  números a organizar
	 * @return vector arregloOrdenado  números organizados 
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
	 * <b>pre:</b>Escoge un minimo y un maximo de los cuales saca la mitad 
	 * pregunta si el dato de la mitad es gual al buscado si lo es, lo retorna
	 * <b>post:</b> Si no el minimo sera el dato de la mitad mas 1 y seguira preguntando hasta
	 * hallar el numero buscado
	 * @param vector array  
	 * @param entero data
	 * @return entero index
	 */
	 public int interpolationSearch(int[] array,int data){
	  int lower=0;
	  int higher=array.length-1;
	  int index=-1;
	  int middle=0;
	  while (true){
	   if(lower>=higher ||array[lower]==array[higher]){
	    break;
	   }
	    middle=lower+((higher-lower)/(array[higher]-array[lower])*(data-array[lower]));
	   if(array[middle]==data){
	             index=middle;
	             break; 
	   }else
	   {
	    if(array[middle]<data)
	    {
	     lower=middle+1;
	    }else
	    {
	     if(array[middle]>data)
	     {
	      higher=middle-1;
	     }
	    }
	   }
	  }
	  return index;
	  
	 }
	 
	}