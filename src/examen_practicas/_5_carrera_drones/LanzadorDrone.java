package examen_practicas._5_carrera_drones;

public class LanzadorDrone implements Runnable{
	
	private Drone drone;
	
	public LanzadorDrone(Drone drone) {
		this.drone = drone;
	}

	@Override
	public void run() {
		drone.volar();
	}
	
	public static void main(String[] args) {
		
		LanzadorDrone l = new LanzadorDrone(new Drone("DRON-F", 50));
		Thread t = new Thread(l);
		
		t.start();

	}


}
