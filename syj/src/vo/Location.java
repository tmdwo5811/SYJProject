package vo;

public class Location extends Vo {
	
	private int no;
	private String name;

	public Location() {}
	public Location(int no) {
		this.no = no;
	} //Location();
	
	public int getNo() { return no; }
	public String getName() { return name; }
	public void setNo(int no) { this.no = no; }
	public void setName(String name) { this.name = name; }
	
	@Override
	public String toString() {
		return "Location [no=" + no + ", name=" + name + "]";
	} //toString();
	
} //class Location;
