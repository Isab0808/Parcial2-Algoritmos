package model;

import processing.core.PApplet;

public class Polo implements Runnable {

	float posX, posY, speedX, speedY;
	PApplet app;
	float radius;
	boolean beignChase;
	int direction;

	public Polo(PApplet app, float posX, float posY) {

		this.app = app;
		this.posX = posX;
		this.posY = posY;
		speedX = 1;
		speedY = 1;
		radius = 30;

		direction = (int) app.random(4);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Move();

		try {

			Thread.sleep(10);

		}

		catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void Draw() {

		app.fill(255, 255, 255);
		app.ellipse(posX, posY, radius, radius);
		
		app.text("Polo "+posX+" ,"+posY, posX-50, posY+40);

	}

	public void Move() {

		switch (direction) {

		// abajo e izquierda
		case 0:

			this.posX -= speedX;
			this.posY += speedY;

			break;

		// izquierda arriba
		case 1:

			this.posX -= speedX;
			this.posY -= speedY;

			break;

		// derecha arriba
		case 2:

			this.posX += speedX;
			this.posY -= speedY;

			break;

		// derecha abajo
		case 3:
			this.posX += speedX;
			this.posY += speedY;

			break;

		}

		// rebote eje x
		if (this.posX - (radius / 2) <= 0 || this.posX + (radius / 2) > app.width) {

			this.speedX *= -1;

		}

		// rebota eje y
		if (this.posY - (radius / 2) <= 0 || this.posY + (radius / 2) > app.height) {

			this.speedY *= -1;

		}

	}

	public void ChangeDir() {

		direction = (int) app.random(4);
		System.out.println("change");
	}

	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}

	public boolean isBeignChase() {
		return beignChase;
	}

	public void setBeignChase(boolean beignChase) {
		this.beignChase = beignChase;
	}

}
