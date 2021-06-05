package controller;

import model.World;
import processing.core.PApplet;

public class Controller {
	
	PApplet app;
	World logic;
	
	public Controller(PApplet app) {
		
	this.app=app;
	logic= new World(this.app);
		
	}
	
	public void Init() {
		
		logic.Init();
	}

}
