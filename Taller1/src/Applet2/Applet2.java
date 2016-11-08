 	package Applet2;
import java.awt.*;
import javax.swing.*;

import Applet1.BubbleSort;
import Applet1.Counting;
import Applet1.MergeSort;
import Applet1.QuickS;

import java.io.*;
import java.nio.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**	
 *@author Leidy Johana García Q
 *@date 07 / 11 / 2016
 */
public class Applet2 extends JApplet implements ActionListener
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
	/* Declaracion de los metodos publicos */
	public JTextArea area1;
	public static final  String Jbuscar = "buscar";
	public static final  String JAbrir = "Abrir";
	public JLabel lbl1;
	public JTextArea area2;
	public JLabel lbl2;
	public JTextArea area3;
	public JLabel lbl3;
	public JTextArea area4;
	public JLabel lbl4;


	/**
	 * Método de creacion del applet
	 * Inicializacion y ubicacion del boton, cmapos de texto y etiquetas
	 */
	public void init()
	{
		// Creacion ventana
		setLayout(null);
		setSize(500,250);
		
		// inicializacion boton
		bton1 = new JButton("Buscar");
		bton1.setBounds(370,130, 100, 30);
		bton1.addActionListener(this);
		bton1.setActionCommand(Jbuscar);
		bton1.setBackground(Color.LIGHT_GRAY);
		
		// Inicializacion y ubicacion de los campos te texto y etiquetas
	    area1 = new JTextArea();
	    area1.setBounds(30, 50, 440, 40);
	    
	    lbl1 = new JLabel();
	    lbl1.setText("Numeros ingresados");
	    lbl1.setBounds(30, 20, 140, 40);
	    
	    area2 = new JTextArea();
	    area2.setBounds(30, 120, 100, 40);
	    
	    lbl2 = new JLabel();
	    lbl2.setText("Número a buscar");
	    lbl2.setBounds(30, 90, 140, 40);
	    
	    area3 = new JTextArea();
	    area3.setBounds(170, 120, 160, 40);
	    
	    lbl3 = new JLabel();
	    lbl3.setText("El numero se encuentra");
	    lbl3.setBounds(170, 90, 200, 40);
	    
	    area4 = new JTextArea();
	    area4.setBounds(30,180,440,40);
	    
	    lbl4 = new JLabel();
	    lbl4.setText("Numeros ordenados");
	    lbl4.setBounds(30,150,170,40);
	    
	    Color color=new Color(235, 224, 246);
	    
	    //Se agregan cada uno de los botones, campos de texto y etiquetas
		add(bton1);
		add(area1);
		add(lbl1);
		add(area2);
		add(lbl2);
		add(lbl3);
		add(area3);
		add(area4);
		add(lbl4);
		addmenu();
		area1.setBackground(color);
		area2.setBackground(color);	
		area3.setBackground(color);
		area4.setBackground(color);
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
		
		// Creacion de la barra de menu con sus items
		barra=new JMenuBar();
        inicio=new JMenu("Inicio");
	    opc=new JMenu("Opciones");	
		abrir=new JMenuItem("Abrir");
		barra.setBackground(Color.lightGray);
		abrir.addActionListener(new ActionListener() 
		{
			@Override
			// Sobreeescribir un método
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource() == abrir) // 
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
			// Sobreescritura de Métodos
			public void actionPerformed(ActionEvent e)
			{
				String con = area2.getText(); // Se guarda en una String el valor que tenga el campo de texto (area2)
				int resultad = fc.showSaveDialog(null); // Devuelve un int con el valor que escogio el usuario
				if(resultad == JFileChooser.APPROVE_OPTION) // 
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
				area3.setText("");
				area4.setText("");
				combo1.setSelectedIndex(0);
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
		cambiar = new JMenuItem("Cambiar Metodo");
		cambiar.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				area2.setText("");
				area3.setText("");
				area4.setText("");
			}
		});
		
		opc.add(cambiar);
		barra.add(inicio);
	    barra.add(opc);
	    inicio.add(abrir);
        inicio.add(guardar);
	    opc.add(ingresar);
		opc.add(salir);
		
	    setJMenuBar(barra);		
	    
	    
	    combo1=new JComboBox();
        combo1.setBounds(355,10,115,20);
        add(combo1);
        combo1.setBackground(Color.LIGHT_GRAY);
        combo1.addItem("Escoger");
        combo1.addItem("Binary Search");
        combo1.addItem("Lineal Search");
        combo1.addItem("Interpolation Search");
        combo1.addActionListener(this); 
	}
	/*
	 * Este metodo se encarga de los eventos del "comboBox" al presionar 
	 * el boton de Ordenar y tener alguna opcion del combo box seleccionada 
	 */
	@Override
	public void actionPerformed(ActionEvent evento) 
	{
		Binary bi = new Binary();
		Lineal li=new Lineal();
		Interpolation in = new Interpolation();
		
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
				String numero = area2.getText();
		        String[] array = num.split(",");
		        int bus = Integer.parseInt(numero);
		        int a = array.length;
		        int izq [] = new int [a];
		        for (int i = 0; i < array.length; i++)
		        {
		        	izq [i] = Integer.parseInt(array[i]); 	  
		        }
		       
		       print(bi.Ordenar(izq));
		       printer(bi.binary(izq, bus));
		        
			}
		}
	
		if(evento.getActionCommand().equals(Jbuscar))
		{
			if(combo1.getSelectedIndex() == 2)
			{
				String numero = area2.getText();
				String[] array = num.split(",");
				 int bus = Integer.parseInt(numero);
		        int a = array.length;
		        int izq [] = new int [a];
		        for (int i = 0; i < array.length; i++)
		        {
		        	izq [i] = Integer.parseInt(array[i]); 	  
		        }
		        print(li.Ordenar(izq));
		        printer(li.Buscar(izq, bus));
			}
		}	
		
		if(evento.getActionCommand().equals(Jbuscar))
		{
			if(combo1.getSelectedIndex() == 3)
			{
					String numero = area2.getText();
					String[] array = num.split(",");
			        int a = array.length;
			        int bus = Integer.parseInt(numero);
			        int izq [] = new int [a];
			        for (int i = 0; i < array.length; i++)
			        {
			        	izq [i] = Integer.parseInt(array[i]); 	  
			        }
			        print(in.Ordenar(izq));
			        printer(in.interpolationSearch(izq, bus));	        
			}
		}	
	}
	/*
	 * Este metodo es para la impresion del conjunto de numeros ordenados
	 * y asignarlos al campo de texto deseado
	 * @param  arreglo 
	 */
	public void print (int a [])
	{
		String v= "";
		for(int i = 0; i <a.length; i++)
		{
			v=v+a[i];
			if( i != a.length-1)
			{
				v = v+",";
			}
		}
		area4.setText(v);
	}
	/*
	 * Este metodo es para la impresion de la posicion del número buscado
	 * y asignacion del mensaje al campo de texto deseado
	 * @param  entero b 
	 */
	public void printer(int b)
	{
		String buscado = "";
		if(b < 0 ) 
		{
			buscado = "No se encuentra el número";
		}
		else
		{
		    buscado = "en la posicion "+ b;
		}
		area3.setText(buscado);
	}
}
