package Applet3;

import javax.swing.JApplet;

public class principal extends JApplet{
		private figura dibujo;	
		public void init() {
			dibujo = new figura(this);
			setSize(800, 600);
			add(dibujo);
		}	
}
