package Interfaces;
import java.util.LinkedList;
import java.util.Scanner;

import FizzBuzzCore.Buzzword;
import FizzBuzzCore.FizzBuzz;


public class TextInterface {

	public static void main(String[] args) {
		Scanner inputscan = new Scanner(System.in);
		System.out.println("input limit, or start and end value separated by space");
		int start = 0;
		int end = 0;
		String input = inputscan.nextLine();
		if (input.matches("[-]?[0-9]+ [-]?[0-9]+")) {
			start = Integer.parseInt(input.split(" ")[0]);
			end = Integer.parseInt(input.split(" ")[1]);
		}
		
		else if (input.matches("[-]?[0-9]+")) {
			start = 0;
			end = Integer.parseInt(input);
		}
		
		else {
			inputscan.close();
			throw new IllegalArgumentException("no");
		}
		if (start > end) {
			inputscan.close();
			throw new IllegalArgumentException("start > end");
		}
		
		System.out.println("input rules in desired order, alphanumeric word and positive integer separated by underscore, rules separated by comma, e.g.:");
		System.out.println("Fizz_5,Buzz_7,asdg67g_4");
		input = inputscan.nextLine();
		if (!input.matches("([a-zA-Z0-9]+[_][0-9]+)([,]([a-zA-Z0-9]+[_][0-9]+))*")) {
			inputscan.close();
			throw new IllegalArgumentException("bad rules");
		}
		LinkedList<Buzzword> buzzwords = new LinkedList<Buzzword>();
		String[] rules = input.split(",");
		for (int i = 0; i < rules.length; i++) {
			buzzwords.add(new Buzzword(Integer.parseInt(rules[i].split("_")[1]), rules[i].split("_")[0]));
		}
		FizzBuzz instance = new FizzBuzz(start, end, buzzwords);
		instance.run();
		inputscan.close();
	}

}
