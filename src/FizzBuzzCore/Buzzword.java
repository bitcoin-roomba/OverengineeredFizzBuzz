package FizzBuzzCore;

public class Buzzword {

	private int x;
	private String word;
	
	public Buzzword(int x, String word) {
		if (x == 0) {
			throw new IllegalArgumentException("divide by zero");
		}
		this.x = x;
		this.word = word;
	}
	
	public int getX() {
		return x;
	}

	public String getWord() {
		return word;
	}

	
	
	
	
}
