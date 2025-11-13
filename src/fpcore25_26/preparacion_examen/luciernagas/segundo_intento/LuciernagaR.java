package fpcore25_26.preparacion_examen.luciernagas.segundo_intento;

public class LuciernagaR implements Runnable {

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

    public LuciernagaR(String nombre, boolean encendido, int energia, String color) {
        this.nombre = nombre != null ? nombre : "Luciernaga Desconocida";
        this.encendido = encendido;
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

        LuciernagaR l1 = new LuciernagaR("Luci", true, 8, VERDE);
        LuciernagaR l2 = new LuciernagaR("Brilla", false, 6, AMARILLO);
        LuciernagaR l3 = new LuciernagaR("Chispa", true, 9, MORADO);

        Thread t1 = new Thread(l1);
        Thread t2 = new Thread(l2);
        Thread t3 = new Thread(l3);

        t1.start();
        t2.start();
        t3.start();
    }
}
