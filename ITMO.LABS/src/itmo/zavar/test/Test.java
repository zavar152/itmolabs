package itmo.zavar.test;

public class Test 
{
	public static void main(String[] args) {
		int a = (int)(Math.random()*2.1)+1;
		while(true)
		{
			System.out.println(a);
			a = (int)(Math.random()*2.1)+1;
		}
		//System.out.println(a);
	}
}
