package progra.practica8.com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import progra.practica8.com.entities.Caixer;

public class ApartadoA {

	public static void main(String[] args) {
		Caixer[] caixers= new Caixer[3];
		for(int i=0;i<caixers.length;i++) {
			caixers[i]=new Caixer();
		}
		ExecutorService exec = Executors.newCachedThreadPool();
		for (Caixer caixer : caixers) {
//			caixer = new Caixer();
//			System.out.println(caixer.getPersones());
//			System.out.println(caixer.getTemps());
			exec.execute(caixer);
		}
		exec.shutdown();
		try {
			exec.awaitTermination(100, TimeUnit.SECONDS);
			System.out.println(caixers[0]);
			System.out.println(caixers[1]);
			System.out.println(caixers[2]);
		} catch (InterruptedException e) {
			System.out.println("Se interrumpió");
		}
		
	}

}
