package fpcore25_26.preparacion_examen.luciernagas.segundo_intento;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LuciernagaExS extends Thread {

    private String nombre;
    private boolean encendido;
    private int energia;
    private static long milis = 300; 
    private String color; 

    public static final String RESET = "\u001B[0m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String MORADO = "\u001B[35m";
    public static final String ROJO = "\u001B[31m";

    public LuciernagaExS(String nombre, int energia, String color) {
        this.nombre = nombre != null ? nombre : "Luciernaga Desconocida";
        encendido = false;
        this.energia = energia < 1 ? 1 : energia > 50 ? 50 : energia;
        this.color = color != null ? color : RESET;
    }

    private void reducirEnergia() {
        while (energia > 0) {
            energia--;
            System.out.printf("%s %s tiene %d %% %s%n", color, nombre, energia, RESET);
            try {
                Thread.sleep(milis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("%s %s ya no tiene energía...%s%n%n", ROJO, nombre, RESET);
        encendido = false;
    }

    public void enciende() {
        if (!encendido && energia > 5) {
            encendido = true;
            reducirEnergia();
        } else if (encendido && energia > 5) {
            reducirEnergia();
        } else if (energia <= 5)
            System.out.printf("%s%s no puede encenderse...%s%n", color, nombre, RESET);
    }

    @Override
    public void run() {
        enciende();
    }

    @Override
    public String toString() {
        return String.format("%s%s (%b) tiene %d %% de energía%s", color, nombre, encendido, energia, RESET);
    }

    public static void main(String[] args) {

        LuciernagaExS l1 = new LuciernagaExS("Luci", 8, VERDE);
        LuciernagaExS l2 = new LuciernagaExS("Brilla", 6, AMARILLO);
        LuciernagaExS l3 = new LuciernagaExS("Chispa", 9, MORADO);

        ExecutorService executor = Executors.newFixedThreadPool(1);
        
        executor.execute(l1);
        executor.execute(l2);
        executor.execute(l3);
        
        executor.shutdown();
    }
}
