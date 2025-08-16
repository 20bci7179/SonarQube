package org.sample.mavenSample;

public class App
{
	public int addition(int a, int b) {
		System.out.println("Its Priniting");
		return a+b;
	}
	public float division(int a, int b) {
		return a/b;
	}
    public static void main( String[] args )
    {
    	App t1 = new App();
    	t1.addition(2, 10);
    	t1.division(7, 3);
    }
}
