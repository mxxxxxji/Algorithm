import java.io.*;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
         	int k = scan.nextInt();	
		int size = 1;
		int count = 0;
		int size2 = 0;	
		
		while(size < k) {
			size = size * 2;
			size2 = size;
		}
		// K크기의 초콜릿을 얻기 위해서는 그와 같거나 큰 초콜릿이 필요하다.
        // 2제곱근으로 증가한다고 하니 2씩 곱해주어 가장작은
        // 초콜릿 크기를 구한다.
        
        
		while(k > 0) {
			if(k>=size) {
				k-=size;
			}else {
				size /= 2;
				count++;
			}
		}
		//최소 초콜릿의 크기가 K보다 클경우 반으로 쪼개고
        //count를 하나씩 더해준다.
        //K 가 0보다 작아지면 해당 반복문을 중단한다.
        
        
		System.out.println(size2+" " + count);

    }

}