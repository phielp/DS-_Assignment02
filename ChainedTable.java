import java.lang.*;
import java.util.*;

// hash table using collision chaining method
public class ChainedTable {

	private LinkedHashList[] hashtable;
	private Compressable compressor;
	private int table_size;
	private int size = 0;

	// creates hashtable
	public ChainedTable(int hash_size) {
		Compressable function = new Division(hash_size);
		hashtable = new LinkedHashList[hash_size];
		table_size = size;
		compressor = function;
	}

	// method for storing a word
	public void put(String word, String value) {
		int index = compressor.calcIndex(word);

		if (hashtable[index] == null) {
			table_size += 1;
			hashtable[index] = new LinkedHashList(word);
		} else {
			table_size += 1;
			hashtable[index].addNode(word);
		}
	}

	// method for retrieving a word
	public String get(String word) {
		int index = compressor.calcIndex(word);
		// checks if empty
		if (hashtable[index] == null) {
			return null;
		}
		// get next word
		LinkedNode node = hashtable[index].getFirst();
		while (!node.getWord().equals(word)) {
			try {
				node = node.nextNode();
			} catch (IndexOutOfBoundsException e) {
				// no match
				return null;
			}
		}
		return node.getWord();
	}
	public int size() {
		return table_size;
	}
}


