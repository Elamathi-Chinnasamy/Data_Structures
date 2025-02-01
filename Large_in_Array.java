import java.util.Scanner;
public class Main
{
	public static void main(String[] args) 
	{
	    int a[] = {1,11,22,3,2,5,6,10,8};
	    int large = a[0];
	    for(int i=0; i<a.length; i++)
	    {
	            if(a[i]>large)
	            {
	                large = a[i];
	            }
	            
	    }
	    System.out.println("Largest: "+large);
	}
}