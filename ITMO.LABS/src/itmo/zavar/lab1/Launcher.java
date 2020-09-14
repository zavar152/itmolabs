package itmo.zavar.lab1;

public class Launcher {

	private static short d[];
	private static float x[];
	private static double b[][] = new double[15][15];
	
	public static final String ANSI_RESET = "\u001B[0m";
	
	public static final String COLORS[] = {"\u001B[31m", "\u001B[33m", "\u001B[32m", "\u001B[36m", "\u001B[34m", "\u001B[35m", "\u001B[31m", "\u001B[33m", "\u001B[32m", "\u001B[36m", "\u001B[34m", "\u001B[35m", "\u001B[31m", "\u001B[33m", "\u001B[32m"};
	
	private static int type = 0;
	
	public static void main(String[] args) 
	{
		/*
		 * Detecting linux
		 */
		String os = System.getProperty("os.name").toLowerCase();
		if(os.indexOf("win") >= 0)
		{
			type = 1;
		}
		
		/*
		 * Borders
		 */
		short l = 6;
		short r = 20;
		/*
		 * Init array "d"
		 */
		d = new short[r-l+1];
		/*
		 * Fill in the array "d"
		 */
		for(int i = 0; i < d.length; i++)
		{
			d[i] = (short) (r-i);
		}
		/*
		 * Init array "x"
		 */
		x = new float[15];
		
		/*
		 * Counting array "x" [-12.0; 13.0]
		 */
		for(int i = 0; i < x.length; i++)
		{
			x[i] = (float) rnd(7);//(float) ((Math.random()*25) - 12);
		}
		
		/*
		 * Fill in the two-d array  
		 */
		for(int i = 0; i < 15; i++)
		{
			for(int j = 0; j < 15; j++)
			{
				if(d[i] == 10)
				{
					b[i][j] = Math.cos(Math.pow(Math.pow(1/3 - x[j], x[j]), Math.asin((x[j] + 0.5)/25)/3));
				}
				else if(d[i] == 7 || d[i] == 9 || d[i] == 11 || d[i] == 12 || d[i] == 13 || d[i] == 14 || d[i] == 16)
				{
					b[i][j] = Math.pow((0.25 - Math.pow(Math.atan((x[j] + 0.5)/25), Math.PI*Math.pow(Math.E, x[j])))/Math.PI, 3);
				}
				else
				{
					b[i][j] = (Math.atan(Math.pow((x[j] + 0.5)/25, 4)))/6;
				}
				//Output
				if(type == 0)
				System.out.printf(COLORS[j] + "%7.4f" + "   " + ANSI_RESET, b[i][j]);//Linux
				else
				System.out.printf("%7.4f" + "   ", b[i][j]);//Windows
			}
			System.out.println();
			offset();
		}
	}
	
	private static void offset()
	{
		String b = COLORS[3];
		for(int y = 0; y < 14; y++)
		{
			COLORS[y] = COLORS[y + 1];
		}
		COLORS[COLORS.length-1] = b;
	}

	private static double rnd(int precision)
	{
		return (double)((int)(Math.random()*(25*Math.pow(10, precision) + 1)) - 12*Math.pow(10, precision))/Math.pow(10, precision);
	}
}
