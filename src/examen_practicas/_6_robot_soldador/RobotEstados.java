package examen_practicas._6_robot_soldador;

import java.util.ArrayList;
import java.util.List;

public class RobotEstados {

	public static void main(String[] args) {
		
		RobotSoldadorR robot = new RobotSoldadorR("R", 4);
		
		Thread hilo = new Thread(robot);
		
		List<Thread.State> estados = new ArrayList<>();
		
		System.out.println(hilo.getState());
		estados.add(hilo.getState());
		
		hilo.start();
		System.out.println(hilo.getState());
		estados.add(hilo.getState());
		
		while(hilo.isAlive()) {
			
			System.out.println(hilo.getState());
			estados.add(hilo.getState());
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		try {
			hilo.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(hilo.getState());
		estados.add(hilo.getState());
		
		System.out.println("\nLISTA DE ESTADOS: " + estados);
		

	}

}
