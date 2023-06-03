import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		int c = s.nextInt();
		s.close();
		
		if (a >=1 && a<=100 && b>=1 && b<=100 && c>=1 && c<=100){
			if(a < b){
				if(b<c){
					System.out.println(b);
				}else if(a>c){
					System.out.println(a);
				}else{
					System.out.println(c);
				}
			}
			else{
				if(b>c){
					System.out.println(b);
				}else if(a<c){
					System.out.println(a);
				}else{
					System.out.println(c);
				}
			}
			
		}
	
	}
}