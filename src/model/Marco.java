package model;

import processing.core.PApplet;

public class Marco implements Runnable{
	
	float posX,posY,speed;
	float radius;
	float dirX,dirY;
	PApplet app;
	
	public Marco(PApplet app,float posX,float posY,float speed) {
		
	this.posX=posX;
	this.posY=posY;
	this.speed=speed;
	this.app=app;
	dirX=app.width/2;
	dirY=app.height/2;
	radius=30;
		
	}
	
	
	@Override
	public void run() {
		
		Move();
		
		try {
			Thread.sleep(20);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	public void Draw() {
		
		app.fill(255,0,255);
		app.ellipse(posX, posY, radius, radius);
		app.text("Marco", posX-20, posY+40);
		
	}
	
	public void Move() {
	
		float angle = PApplet.atan2(this.dirY-this.posY, this.dirX-this.posX);
		float newX = PApplet.cos(angle) * speed + this.posX;
		float newY = PApplet.sin(angle) * speed + this.posY;
		
		this.posX = newX;
		this.posY = newY;
		
		
	}


	public float getDirX() {
		return dirX;
	}


	public void setDirX(float dirX) {
		this.dirX = dirX;
	}


	public float getDirY() {
		return dirY;
	}


	public void setDirY(float dirY) {
		this.dirY = dirY;
	}
	
	
	
}
