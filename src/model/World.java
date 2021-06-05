package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class World {

	PApplet app;

	ArrayList<Marco> marcos = new ArrayList<Marco>();
	ArrayList<Polo> polos = new ArrayList<Polo>();

	public World(PApplet app) {

		this.app = app;
		marcos.add(new Marco(app, 20, 20, 2));

		for (int i = 0; i < 20; i++) {

			polos.add(new Polo(app,(int) app.random(app.width),(int) app.random(app.height)));
		}

	}

	public void Init() {

		for (Polo polo : polos) {

			new Thread(polo).start();
			polo.Draw();
		}

		for (Marco marco : marcos) {

			new Thread(marco).start();
			marco.Draw();

		}
	
		try {
			for (Marco marco : marcos) {
				
				FindPolo(marco);
				
				Collisions(marco);
			}

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getMessage());
		}

	}

	public void FindPolo(Marco marco) {
		
		float minDist = 1500;
		int index = 0;

		for (int i = 0; i < polos.size(); i++) {

			float distance = PApplet.dist(marco.posX, marco.posY, polos.get(i).posX, polos.get(i).posY);
			polos.get(i).setBeignChase(false);
			if (distance < minDist) {
				minDist = distance;
				index = i;
			}

		}

		polos.get(index).setBeignChase(true);
		marco.setDirX(polos.get(index).getPosX());
		marco.setDirY(polos.get(index).getPosY());

	}

	public void Collisions(Marco marco) {

		for (int i = 0; i < polos.size(); i++) {
			float distance = PApplet.dist(marco.posX, marco.posY, polos.get(i).posX, polos.get(i).posY);
			if (distance < 30) {

				marcos.add(new Marco(this.app, polos.get(i).getPosX(), polos.get(i).getPosY(), 2));
				marcos.remove(0);
				polos.remove(i);
			}

		}

	}

}
