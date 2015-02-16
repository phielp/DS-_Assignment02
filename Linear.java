public class Linear {
	private String[] keys;
	private int hsize;
	private String[] values;
	private Compressable comp;
	private int numberofitems;

	// constructor
	public Linear(int size, Compressable comp)
	{
		this.hsize = size;
		this.keys = new String[size];
		this.values = new String[size];
		this.comp = comp;
	}

	// if table is too full, enlarge it
    public void resize()
    {
    	hsize = 2 * hsize;
    	String[] newkeys = new String[hsize];
    	String[] newvalues = new String[hsize];

    	// put all entries in new table
    	int i = 0;
    	while (i < hsize/2)
    	{
    		if (keys[i] != null)
    		{
    			newkeys[i] = keys[i];
    			newvalues[i] = values[i];
    		}
    		i++;
    	}

    	keys = newkeys;
    	values = newvalues;
    }

    // check if table needs to be resized
    public void resizecheck()
    {
    	if (((double) numberofitems/hsize) > 0.75)
    	{
    		resize();
    	}
    }

    public int size()
    {
    	return this.hsize;
    }

	public String get(String key)
	{
		int i = comp.calcIndex(key);
		int originali = i;

		// check if key exists
		while (i < this.hsize)
		{
			if (key.equals(this.keys[i])) 
			{
				return this.values[i];
			}
			i++;
		}

		// wraparound
		i = 0;
		while (i < this.hsize)
		{
			if (key.equals(this.keys[i])) 
			{
				return this.values[i];
			}
			i++;
		}

		return null;
	}

	public void put(String key, String value)
	{
		int i = comp.calcIndex(key);

		resizecheck();
		if (this.keys[i] == null) 
		{
			this.keys[i] = key;
			this.values[i] = value;
			this.numberofitems++;
			return;
		}

		while (i < this.hsize)
		{
			if (this.keys[i] == null) 
			{
				this.keys[i] = key;
				this.values[i] = value;
				this.numberofitems++;
				return;
			}
			i++;
		}

		// wraparound
		i=0;
		while (i < this.hsize)
		{
			if (this.keys[i] == null) 
			{
				this.keys[i] = key;
				this.values[i] = value;
				this.numberofitems++;
				return;
			}
			i++;
		}

	}

}