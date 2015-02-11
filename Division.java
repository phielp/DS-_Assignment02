public class Division implements Compressable {
    public int table_length;
    public int initial = 11;
    public int multiplier = 31;
    
    public Division(int length) {
        table_length = length;
    }

    public int calcIndex(Object key) {
        String strKey = (String) key;
        int index;        
        index = Math.abs(hashCode(strKey)) % table_length;
        return index;
    }

    public int hashCode(String key) {
        int hash = initial;
        char[] val = key.toCharArray();
        int len = key.length();
   
        for (int i = 0; i < len; i++) {
            hash = multiplier * hash + val[i];
        }
        return hash;
    }
}
