package Assesment;

import java.util.ArrayList;
import java.util.Scanner;

import Assesment.*;


public class operatingSystemAssessment  {
	
	
	
	public static void main(String args[]) {
		
		ArrayList<String> sorular = new ArrayList<String>();
			
		sorularıYukle(sorular); // Arrayliste Seçmene Sorulacak Soruları Yükleme İşlemi
		
		int yas = yasBilgisiniAl(); // Seçmenden Yaş bilgisi alınmıştır. KNN için Y ekseninde kullanılacaktır.
		int politikGorusPuani =   bilgileriAl(sorular); // Seçmenin kriterlerine göre toplam puani hesaplanmıştır. KNN' X ekseninde kullanılacaktır.
		
		
		// Girilen verileri göre A-B partisininden birini seçmek için metoda parametreler geçildi.
		KNNClassification.secmeniSiniflandır(politikGorusPuani, yas);
		
		//System.out.print(politikGorusPuani);
			

	}
	
	
	public static int bilgileriAl(ArrayList<String> sorular) {
		
		Scanner scanner = new Scanner(System.in);
		int toplamPuan;
		
		
		System.out.print("" + sorular.get(0));
		int refahPuani = scanner.nextInt();
		refahPuani = puanCevirici(refahPuani);
		
		
		System.out.print("" + sorular.get(1));
		int ekonomikPuani = scanner.nextInt();
		ekonomikPuani = puanCevirici(ekonomikPuani);
		
		System.out.print("" + sorular.get(2));
		int gorusPuani = scanner.nextInt();
		gorusPuani = puanCevirici(gorusPuani);  


		toplamPuan = refahPuani+ekonomikPuani+gorusPuani;
		
		
		return toplamPuan;
		
		
	}
	
	public static int yasBilgisiniAl() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Yaşınız nedir ?");
		int yas = scanner.nextInt();
		return yas;
		
		
	}
	
	
	public static ArrayList<String> sorularıYukle(ArrayList<String> sorular){
		
		sorular.add("Refah seviyenizden memnun musunuz ? 0 ile 10 arası puanlayınız.");
		sorular.add("Ekonomik gidişattan memnun musunuz ? 0 ile 10 arası puanlayınız. ");
		sorular.add("Kendinizi milliyetçi olarak tanımlar mısınız ? 0 ile 10 arasında puanlayınız." );
		
		return sorular;
	}
	
	
	public static int puanCevirici(int kullaniciPuanlari) {
		
		int cevrilmisPuan;
		
		switch(kullaniciPuanlari) {
		
	    case 0:
	        cevrilmisPuan = -10;
	        break;
	    case 1:
	    	cevrilmisPuan = -8;
	        break;
	    case 2:
	    	cevrilmisPuan = -6;
	        break;
	    case 3:
	    	cevrilmisPuan = -4;
	        break;
	    case 4:
	    	cevrilmisPuan = -2;
	        break;
	    case 5:
	    	cevrilmisPuan = 0;
	        break;
	    case 6:
	    	cevrilmisPuan = 2;
	        break;
	    case 7:
	    	cevrilmisPuan = 4;
	        break;
	    case 8:
	    	cevrilmisPuan = 6;
	        break;
	    case 9:
	    	cevrilmisPuan = 8;
	        break;
	    case 10:
	    	cevrilmisPuan = 10;
	        break;
	    default:
	    	cevrilmisPuan = 0;
	        break;
	}
			
		return cevrilmisPuan;
			
	}

}
