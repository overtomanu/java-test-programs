

public class Divisible2And3And5 {
	public static void main(String[] args) {
		int i=1,num=1;
		while(i<=1000)
		{
			if(num%2==0 && num%3==0 && num%5==0)
			{
				System.out.println(num);
				i++;
			}
			num++;
		}
	}

}
