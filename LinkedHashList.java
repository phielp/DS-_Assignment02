// Linked list for hash table using collision chaining
public class LinkedHashList {

	private LinkedNode head;		// first node
	private LinkedNode tail;		// last node
	private int length;		

	// constructs list with first entry
	public LinkedHashList(String word) {
		head = new LinkedNode(word);
		tail = head;
		length = 1;
	}
 
 	// add node to list
	public void addNode(String word) {
		LinkedNode newNode = new LinkedNode(word);
		tail.next = newNode;
		tail = newNode;
		length += 1;
	}

	// return first entry
	public LinkedNode getFirst() {
		return head;
	}

	// return length
	public int size() {
		return length;
	}
}

