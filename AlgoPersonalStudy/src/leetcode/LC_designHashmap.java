package leetcode;

public class LC_designHashmap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class MyHashMap {
    private static boolean[] keys = new boolean[1000001];
    private static int[] values = new int[1000001];
    public MyHashMap() {

    }
    
    public void put(int key, int value) {
        keys[key] = true;
        values[key] = value;
    }
    
    public int get(int key) {
        if(keys[key]) return values[key];
        else return -1;
    }
    
    public void remove(int key) {
        keys[key] = false;
    }
}

