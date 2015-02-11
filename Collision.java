/* Ik doe hier maar wat hoor...
 * Dit is iig de collision chaining en dan moeten we 
 * nog een probing technique kiezen
 */

public class Collision implements Compressable {
	public int table_length;
	public int initial = 11;		// initialCapacity
	public float load = 0.75;		// loadFactor

	public Collision(int length) {
		table_length = length;
	}

	public int hashCode(String key) {
		int hash = initial;

	}
}
