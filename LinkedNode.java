// defines node for LinkedHasList
public class LinkedNode {
	
	protected LinkedNode next;
	private String word;

	// creates node and store word
	public LinkedNode(String word) {
		this.word = word;
		next = null;
	}

	// returns next node
	public LinkedNode nextNode() {
		if (next == null) {
			throw new IndexOutOfBoundsException();
		}
		return next;
	}

	// return word
	public String getWord() {
		return word;
	}
}