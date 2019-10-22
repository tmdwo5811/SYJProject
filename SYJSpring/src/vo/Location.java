package vo;

public class Location {
	
	private int no;
	
	public Location() {}
	public Location(int no) { this.no = no; }
	
	private static String[] array;
	
	public int getNo() { return no; }
	public String getName() { return array[no-1]; }
	public void setNo(int no) { this.no = no; }
	
	public static String[] getArray() { return Location.array; }
	public static void setArray(String[] array) { Location.array = array; }
	
	@Override
	public String toString() {
		return "Location [no=" + no + ", name=" + getName() + "]";
	} //toString();
	
} //class Location;
