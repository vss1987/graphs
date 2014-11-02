package Graph;

public class Node {
	
	private int value;
	private int color;
	private int distance;
	private Node parent;
	private int startTime;
	private int fTime;
	
	public Node(){
		
	}
	
	public Node(int value){
		this.value = value;
		this.distance = -1;
		this.color = 0;
		this.parent = null;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getfTime() {
		return fTime;
	}

	public void setfTime(int fTime) {
		this.fTime = fTime;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (value != other.value)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\nNode [value=" + value + ", color=" + color + ", distance="
				+ distance + ", parent=" + parent + ", startTime=" + startTime
				+ ", fTime=" + fTime + "]";
	}
	
}
