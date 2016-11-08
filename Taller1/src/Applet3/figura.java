package Applet3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class figura extends JPanel implements ActionListener,MouseListener{
		private principal interfaz;
		private JMenuBar jmbsoporte;		
		private JMenu jmopciones;		
		private JMenuItem jmilimpiar;	
		private JMenuItem jmisalir;	
		public static final String limpiar="limpiar";	
		public static final String salir="salir";		
		private JComboBox jcfiguras;	
		public figura(principal interfaz){			
			this.interfaz=interfaz;	
			this.setLayout(new BorderLayout());		
			addMouseListener(this);		
			jmbsoporte=new JMenuBar();		
			jmopciones=new JMenu("otros");		
		    jmilimpiar=new JMenuItem("salir");		
			jmisalir=new JMenuItem("limpiar");			
			jcfiguras=new JComboBox();		
			jmopciones.add(jmilimpiar);			
			jmopciones.add(jmisalir);		
			jmbsoporte.add(jmopciones);		
			jcfiguras.addItem("Cuadrado");			
			jcfiguras.addItem("Triangulo");			
			jcfiguras.addItem("Circulo");			
			jcfiguras.addItem("Rombo");
			jmilimpiar.addActionListener(this);	
			jmilimpiar.setActionCommand(limpiar);
			jmisalir.addActionListener(this);
			jmisalir.setActionCommand(salir);
			add(jmbsoporte,BorderLayout.WEST);	
			add(jcfiguras,BorderLayout.NORTH);
		}
public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals(salir)){
				System.exit(0);
			}else{
				if(e.getActionCommand().equals(limpiar)){
					repaint();
				}	
			}	
		}
		public void mouseClicked(MouseEvent e) {	
			int x=e.getX(); 
			int y=e.getY();
			Graphics g=getGraphics();
			if(jcfiguras.getSelectedIndex()==0){
				g.fillRect(x-50, y-50, 100, 100);
			}else{	
				if(jcfiguras.getSelectedIndex()==1){
					g.drawLine(x, y-50, x+50, y+50);
					g.drawLine(x, y-50, x-50, y+50);
					g.drawLine(x-50, y+50, x+50, y+50);		
				}else{			
					if(jcfiguras.getSelectedIndex()==2){
						g.fillOval(x-50, y-50, 100, 100);				
					}else{				
						if(jcfiguras.getSelectedIndex()==3){
							g.drawLine(x, y-50, x+30, y);
							g.drawLine(x, y-50, x-30, y);
							g.drawLine(x+30, y, x, y+50);
							g.drawLine(x-30, y, x, y+50);				
						}
					}	
				}
			}
		}
		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
}
