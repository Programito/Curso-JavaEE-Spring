package progra.practica8.com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.Arrays;
import java.util.Collections;

import progra.practica8.com.entities.Fil;
import progra.practica8.com.utils.Utils;

public class ApartadoB {

	public static void main(String[] args) {
		Fil[] fils = new Fil[5];
		for (int i = 0; i < fils.length; i++) {
			fils[i] = new Fil(i);
		}
		ExecutorService exec = Executors.newCachedThreadPool();
		for (Fil fil : fils) {
			exec.execute(fil);
		}
		exec.shutdown();
		try {
			exec.awaitTermination(100, TimeUnit.SECONDS);
			Arrays.sort(fils,Collections.reverseOrder());
			
			for(int i=0;i<fils.length;i++) {
				Utils.getText(fils[i], i+1);
			}
			
			
		} catch (InterruptedException e) {
			System.out.println("Se interrumpió");
		}

	}
	

}
