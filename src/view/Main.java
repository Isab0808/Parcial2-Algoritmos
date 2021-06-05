package view;

import controller.Controller;
import processing.core.PApplet;

public class Main  extends PApplet{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PApplet.main("view.Main");
		
	}
	
	
	Controller controller;
	public void settings() {
		
		size(1000,1000);
	}
	public void setup() {
		
		controller = new Controller(this);
		
	}
	
	public void draw() {
		
		
		background(0);
		controller.Init();
		
	}

}

