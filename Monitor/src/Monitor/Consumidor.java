package Monitor;

// TODO: Auto-generated Javadoc
/**
 * The Class Consumidor.
 */
public class Consumidor extends Thread {

	/** The buff. */
	private Monitor buff;

	/** Kontsumitzaileak prozesatuko dituen elementuen kopurua. */
	private int n;

	/** Gehieneko itxaronaldia kontsumo-eragiketa bakoitzaren artean. */
	private int sleep;

	/**
	 * Instantiates a new consumidor.
	 *
	 * @param b Buffer partekatuaren erreferentzia (monitorea).
	 * @@param n Hariak kontsumitu behar dituen elementuen kopurua.
	 * @param s Gehieneko itxaronaldia kontsumo-eragiketa bakoitzaren artean.
	 */
	public Consumidor(Monitor b, int n, int s) {
		this.buff = b;
		this.n = n;
		this.sleep = s;
	}

	/**
	 * Run.
	 */
	public void run() {
		try {
			char c;
			for (int i = 0; i < n; i++) {
				c = buff.sacar();
				System.out.println("Consumí: " + c);
				sleep((int) (Math.random() * sleep));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

}
