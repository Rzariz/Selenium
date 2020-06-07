
public class invertedPyramid {

	public static void main(String[] args) {
		
		int k=1;
		int i;
		for(i=1; i<=4; i++)
		{
			for(int j=4; j>4-i; j--)
			{
				System.out.print(k+"  ");
				k++;
			}
			System.out.println("");
		}

	}

}
