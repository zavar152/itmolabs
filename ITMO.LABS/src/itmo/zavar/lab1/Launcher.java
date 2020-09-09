package itmo.zavar.lab1;

public class Launcher {

	private static long d[];
	private static double x[];
	private static double b[][] = new double[9][13];
	
	private static int chc = 0;
	
	public static void main(String[] args) 
	{
		/*
		 * Границы
		 */
		int l = 4;
		int r = 20;
		/*
		 * Подсчёт кол-ва чётных чисел
		 */
		for(int i = l; i <= r; i++)
		{
			if(i % 2 == 0)
			{
				chc++;
			}
		}
		/*
		 * Инициализация массива
		 */
		d = new long[chc];
		
		/*
		 * Чётные числа
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
		 * Инициализация массива
		 */
		x = new double[13];
		
		/*
		 * Рассчёт массива x
		 */
		for(int i = 0; i < 13; i++)
		{
			x[i] = (Math.random() * 5.0) - 3.0;
		}
		
		/*
		 * Заполнение двумерного массива  
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
				//Вывод
				System.out.printf("%.5f" + "   ", b[i][j]);
			}
			System.out.println();
		}
	}

}
