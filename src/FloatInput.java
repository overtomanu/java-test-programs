

import java.util.Scanner;

public class FloatInput {
	public static void main(String[] args) {
		Scanner Amount = new Scanner(System.in);
		System.out.println("Please enter amount of the item to be bought: ");
	    int s3 = Amount.nextInt();
		Scanner Price = new Scanner(System.in);
	    System.out.println("Please enter item's unit price: ");
	    float s4 = Price.nextFloat();
	    System.out.println("Float is:"+s4);
	}

}
