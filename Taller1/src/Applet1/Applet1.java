package Applet1;
import java.awt.Color;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.*;
import java.util.Vector;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.*;

/**	
  *@author Leidy Johana García Q
  *@date 07 / 11 / 2016
  */
public class Applet1 extends JApplet implements ActionListener
{
	// Declaracion de los atributos privados
	private JComboBox combo1;
	private JButton bton1;
	private JMenuBar barra;
	private JMenu opc;
	private JMenu inicio;
	private JMenuItem abrir;
	private JMenuItem guardar;
	private JMenuItem ingresar;
	private JMenuItem cambiar;
	private JMenuItem salir;
	private JFileChooser fc = new JFileChooser();
	private BufferedReader br;
	private File file;
	private int returnVal;
	private String num;
	private String linea;
	// Declaracion de los atributos publicos
	public JTextArea area1;
	public static final  String Jbuscar = "buscar";
	public static final  String JAbrir = "Abrir";
	public JLabel lbl1;
	public JTextArea area2;
	public JLabel lbl2;
	

	/**
	 * Método de creacion del applet
	 * Inicializacion y ubicacion del boton, cmapos de texto y etiquetas
	 */
	public void init()
	{
		setLayout(null);
		setSize(500,250);
		
		bton1 = new JButton("Ordenar");
		bton1.setBounds(370,190, 100, 30);
		bton1.addActionListener(this);
		bton1.setActionCommand(Jbuscar);
		bton1.setBackground(Color.LIGHT_GRAY);
	    area1 = new JTextArea();
	    area1.setBounds(30, 50, 440, 40);
	    
	    lbl1 = new JLabel();
	    lbl1.setText("Numeros ingresados");
	    lbl1.setBounds(30, 20, 140, 40);
	    
	    area2 = new JTextArea();
	    area2.setBounds(30, 140, 440, 40);
	    
	    lbl2 = new JLabel();
	    lbl2.setText("Números ordenados");
	    lbl2.setBounds(30, 110, 140, 40);
	    
	    Color color=new Color(235, 224, 246);
	    // Se agregan los campos de texto, etiquetas y boton al applet
		add(bton1);
		add(area1);
		add(lbl1);
		add(area2);
		add(lbl2);
		addmenu();
		area1.setBackground(color);
		area2.setBackground(color);
		
	}
	/*
	 * Este metodo inicializa y agrega al applet una barra de menu y una lista desplegable ó
	 * "Combo Box" <b>pre:</b> Para seleccionar, abrir y leer archivos de texto plano y asignarlos
	 * a un campo de texto <br> 
	 * <b>post:</b> Se leen los archivos o se manda el mensaje de eror en dado caso de algun error
	 *  en lectura del archivo <br>
	 */
	public void addmenu() 
	{
		
		barra=new JMenuBar();
        inicio=new JMenu("Inicio");
	    opc=new JMenu("Opciones");	
		abrir=new JMenuItem("Abrir");
		barra.setBackground(Color.lightGray);
		abrir.addActionListener(new ActionListener() 
		{
			
			@Override
			/* Sobreeescribir un método */
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource() == abrir)
				{
					returnVal =fc.showOpenDialog(null);
					if(returnVal == JFileChooser.APPROVE_OPTION)
					{
						file = fc.getSelectedFile();
							
						// lee el archivo
						try 
						{
							br = new BufferedReader(new FileReader(file));
							while((linea = br.readLine()) != null)
							{
								area1.setText(linea);
								num=linea;
							}
						}
						catch(Exception error)
						{
							error.printStackTrace();
						}
					}
					
				}
			}
		});	
		
		guardar=new JMenuItem("Guardar");
		guardar.addActionListener(new ActionListener()
		{	
			@Override
			/*Sobreescritura de Métodos*/
			public void actionPerformed(ActionEvent e)
			{
				String con = area2.getText();
				int resultad = fc.showSaveDialog(null);
				if(resultad == JFileChooser.APPROVE_OPTION)
				{
					File fi = fc.getSelectedFile();
					try
					{
						FileWriter fw= new FileWriter(fi.getPath());
						fw.write(con);
						fw.flush();
						fw.close();
						
					}
					catch (Exception error)
					{
						error.printStackTrace();
					}
				}
				
			}
		});
	
	    ingresar = new JMenuItem("Ingresar Nuevo");
	    ingresar.addActionListener(new ActionListener()
	    {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				area1.setText("");		
				area2.setText("");
				combo1.setSelectedIndex(0);
			}
		});
	    cambiar = new JMenuItem("Cambiar Metodo");
		cambiar.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				area2.setText("");
			}
		});
		salir=new JMenuItem("Salir");
		salir.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		barra.add(inicio);
	    barra.add(opc);
	    inicio.add(abrir);
        inicio.add(guardar);
	    opc.add(ingresar);
		opc.add(cambiar);
		opc.add(salir);
	    setJMenuBar(barra);		
	    
	    
	    combo1=new JComboBox();
        combo1.setBounds(355,10,115,20);
        add(combo1);
        combo1.setBackground(Color.LIGHT_GRAY);
        combo1.addItem("Escoger");
        combo1.addItem("Bubble Sort");
        combo1.addItem("Counting Sort");
        combo1.addItem("Merge Sort");
        combo1.addItem("Quick Sort ");
        combo1.addActionListener(this); 
	}
	/*
	 * Este metodo se encarga de los eventos del "comboBox" al presionar 
	 * el boton de Ordenar y tener alguna opcion del combo box seleccionada 
	 */
	
	@Override
	public void actionPerformed(ActionEvent evento) 
	{
		QuickS q=new QuickS();
		Counting cg=new Counting();
		BubbleSort bs = new BubbleSort();
		MergeSort ms= new MergeSort();
		if(evento.getActionCommand().equals(Jbuscar))
		{
			if(combo1.getSelectedIndex() == 0)
			{
				System.out.println("Escoja una opcion");
			}
		}
		if(evento.getActionCommand().equals(Jbuscar))
		{
			
			if(combo1.getSelectedIndex() == 1)
			{
		        String[] array = num.split(","); 	
		        int a = array.length;
		        int izq [] = new int [a];
		        for (int i = 0; i < array.length; i++)
		        {
		        	izq [i] = Integer.parseInt(array[i]); 	  
		        }
		       
		        print(bs.burbuja(izq));
			}
		}
		else
		{
		}
		if(evento.getActionCommand().equals(Jbuscar))
		{
			if(combo1.getSelectedIndex() == 2)
			{
				String[] array = num.split(",");
		        int a = array.length;
		        int izq [] = new int [a];
		        for (int i = 0; i < array.length; i++)
		        {
		        	izq [i] = Integer.parseInt(array[i]); 	  
		        }
		        print(cg.countingSort(izq));
			}
		}	
		
		if(evento.getActionCommand().equals(Jbuscar))
		{
			if(combo1.getSelectedIndex() == 3)
			{
					String[] array = num.split(",");
			        int a = array.length;
			        int izq [] = new int [a];
			        for (int i = 0; i < array.length; i++)
			        {
			        	izq [i] = Integer.parseInt(array[i]); 	  
			        }
			        print(ms.sort(izq));
			        
			}
		}	
		
		if(evento.getActionCommand().equals(Jbuscar))
		{
			if(combo1.getSelectedIndex() == 4)
			{

					String[] array = num.split(",");
			        int a = array.length;
			        int arreglo [] = new int [a];
			        for (int i = 0; i < array.length; i++)
			        {
			        	arreglo [i] = Integer.parseInt(array[i]); 	  
			        }
			        print(q.Sort(arreglo));
			}
		}
	}
	/*
	 * Este metodo es para la impresion del conjunto de numeros ordenados
	 * y asignarlos al campo de texto deseado
	 * @param  arreglo 
	 */
	
	public void print (int arreglo [])
	{
		String v= "";
		for(int i = 0; i <arreglo.length; i++)
		{
			v=v+arreglo[i];
			if( i != arreglo.length-1)
			{
				v = v+",";
			}
		}
		area2.setText(v);
	}
	
	
	
}

