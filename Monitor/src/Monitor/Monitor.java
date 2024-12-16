package Monitor;

/**
 * The Class Monitor.
 */
public class Monitor {

	private char[] buff = null;

	private int tope = 0;

	private boolean lleno = false;

	private boolean vacio = true;

	/**
	 * Instantiates a new monitor.
	 *
	 * @param capacidad Bufferraren gehienezko tamaina.
	 */
	public Monitor(int capacidad) {
		buff = new char[capacidad];
	}

	/**
	 * Poner.
	 *
	 * @param c Gehitzeko akrakterea
	 * @throws Exception the exception
	 */
	public synchronized void poner(char c) throws Exception {
		while (lleno) {
			wait();
		}
		buff[tope] = c;
		tope = tope + 1;
		vacio = false;
		lleno = tope >= buff.length;
		notifyAll();
	}

	/**
	 * Sacar.
	 *
	 * @return lortutako karakterea
	 * @throws Exception the exception
	 */
	public synchronized char sacar() throws Exception {

		while (vacio) {
			wait();
		}
		tope = tope - 1;
		char c = buff[tope];
		lleno = false;
		vacio = tope <= 0;
		notifyAll();
		return c;
	}
}
