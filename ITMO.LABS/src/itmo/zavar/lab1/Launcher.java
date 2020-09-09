package itmo.zavar.lab1;

public class Launcher {

	private static long d[];
	private static double x[];
	private static double b[][] = new double[9][13];
	
	private static int chc = 0;
	
	public static void main(String[] args) 
	{
		/*
		 * Borders
		 */
		int l = 4;
		int r = 20;
		/*
		 * Counting even numbers
		 */
		for(int i = l; i <= r; i++)
		{
			if(i % 2 == 0)
			{
				chc++;
			}
		}
		/*
		 * Init array "d"
		 */
		d = new long[chc];
		
		/*
		 * Fill in the array "d" with even numbers
		 */
		for(int i = r; i >= l; i--)
		{
			if(i % 2 == 0)
			{
				chc--;
				d[chc] = i;
			}
		}
		
		/*
		 * Init array "x"
		 */
		x = new double[13];
		
		/*
		 * Counting array "x"
		 */
		for(int i = 0; i < 13; i++)
		{
			x[i] = (Math.random() * 5.0) - 3.0;
		}
		
		/*
		 * Fill in the two-d array  
		 */
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 13; j++)
			{
				if(d[i] == 16)
				{
					b[i][j] = Math.tan(Math.pow(Math.E, x[j] / 0.5));
				}
				else if(d[i] == 4 || d[i] == 8 || d[i] == 18 || d[i] == 20)
				{
					b[i][j] = Math.pow(4 * Math.sin(Math.atan((x[j] - 0.5) / 5)), 2);
				}
				else
				{
					b[i][j] = Math.asin(0.5 * Math.pow(Math.E, Math.cbrt(-Math.abs(x[j]))));
				}
				//Output
				System.out.printf("%.5f" + "   ", b[i][j]);
			}
			System.out.println();
		}
	}

}