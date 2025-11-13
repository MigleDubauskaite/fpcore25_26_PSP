package examen_practicas._1_sensor_procesador;

public class TestMensajero {
	
public static void main(String[] args) {
		
		Mensajero m = new Mensajero("Hola");
		Mensajero m2 = new Mensajero("Migle");
		
		LanzadorMensajero lm1 = new LanzadorMensajero(m);
		LanzadorMensajero lm2 = new LanzadorMensajero(m2);
		
		lm1.start();
		lm2.start();
}

}
