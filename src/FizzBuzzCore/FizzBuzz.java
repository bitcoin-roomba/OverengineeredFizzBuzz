package FizzBuzzCore;
import java.util.LinkedList;

public class FizzBuzz {

	private LinkedList<Buzzword> buzzwords;
	private int limit;
	private int start;
	
	public FizzBuzz(int n, LinkedList<Buzzword> buzzwords) {
		this.buzzwords = buzzwords;
		this.limit = n;
		this.start = 0;
	}
	
	public FizzBuzz(int start, int end, LinkedList<Buzzword> buzzwords) {
		this.buzzwords = buzzwords;
		this.limit = end;
		this.start = start;
	}
	
	private String getLine(int x) {
		String line = new String();
		line = "";
		for (Buzzword word : this.buzzwords) {
			if(x % word.getX() == 0) {
				line = line.concat(word.getWord());
			}
		}
		if (line.equals("")) {
			line = line.concat(Integer.toString(x));
		}
		return line;
	}
	
	public void run() {
		for (int i = this.start; i <= this.limit; i++) {
			System.out.println(getLine(i));
		}
	}
	
	public LinkedList<String> getOutput() {
		LinkedList<String> output = new LinkedList<String>();
		for (int i = this.start; i <= this.limit; i++) {
			output.add(getLine(i));
		}
		return output;
	}
}
