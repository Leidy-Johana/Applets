package Applet1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Vector;
public class BubbleSort 
{
	/*
	 * Método que organiza un arreglo de números comparando uno por uno 
	 * @param vector izq  números a organizar
	 * @return vector arregloOrdenado  números organizados 
	 */
    public static int[] burbuja(int[] izq)
    {
      int auxiliar;
      int[] arregloOrdenado;
      for(int i = 2; i < izq.length; i++)
      {
        for(int j = 0;j < izq.length-i;j++)	
        {
          if(izq[j] > izq[j+1])
          {
        	  auxiliar = izq[j];
        	  izq[j] = izq[j+1];
        	  izq[j+1] = auxiliar;
          }   
        }
      }
      arregloOrdenado = izq;
      return arregloOrdenado;
    }
}