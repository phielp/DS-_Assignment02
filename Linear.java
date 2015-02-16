public class Linear implements Compressable {
	private String[] keys;
	private int hsize;
	private String[] values;
	private Compressable comp;

	public Linear(int size)
	{
		this.hsize = size;
		this.hashTable = new Pair[size];

	}

	public hashTable()
	{
		return this.hashTable;
	}

	public String getVal(String key)
	{
		int i = comp.calcIndex(key);
		int originali= i;

		// check if key exists
		while (i < this.hsize)
		{
			if (key.equals(keys[i])) 
			{
				return values[i];
			}
			i++;
		}

		// wraparound
		i = 0;
		while (i < this.hsize)
		{
			if (key.equals(keys[i])) 
			{
				return values[i];
			}
			i++;
		}

		return null;
	}

	public void add(String key, String value)
	{
		int i = comp.calcIndex(key);

		while (i < this.hsize)
		{
			if (keys[i] == null) 
			{
				keys[i] = key;
				values[i] = value;
			}
			i++;
		}

		// wraparound
		i=0;
		while (i < this.hsize)
		{
			if (keys[i] == null) 
			{
				keys[i] = key;
				values[i] = value;
			}
			i++;
		}


	}

}