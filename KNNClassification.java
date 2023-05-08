package Assesment;

import java.util.*;

import Assesment.*;

public class KNNClassification  {

    
    public static void secmeniSiniflandır(int x,int y) {
    	
    	//x kordinatı Politik Görüşü , y ise Yaşı ifade etmektedir.
    	//Yaş ve politik görüşe dayanarak kararsız seçmenin hangi partiye oy vereceğinin tahmini hedeflenmektedir.
    	
    	ArrayList<Secmen> veriSeti = new ArrayList<Secmen>();
    	
    	
    	// Elde varsayılan Secmenleri ekleme işlemi
    	veriSeti.add(new Secmen(10, 20, "A"));
    	veriSeti.add(new Secmen(20, 33, "A"));
    	veriSeti.add(new Secmen(22, 40, "A"));
    	veriSeti.add(new Secmen(23, 55, "A"));
    	veriSeti.add(new Secmen(21, 66, "A"));
    	veriSeti.add(new Secmen(16, 71, "A"));
    	veriSeti.add(new Secmen(-10, 78, "B"));
    	veriSeti.add(new Secmen(-20, 52, "B"));
    	veriSeti.add(new Secmen(-25, 24, "B"));
    	veriSeti.add(new Secmen(-2, 28, "B"));
    	veriSeti.add(new Secmen(-1, 30, "B"));

    	
    	Secmen test = new Secmen(x, y);
        String result = classify(veriSeti, test, 3);
        System.out.println("Kararsız seçmenin muhtemelen vereceği oy  = " + result);
        
	}

    public static String classify(ArrayList<Secmen> dataset, Secmen test, int k) {
        ArrayList<SecmenUzaklik> Uzakliks = new ArrayList<SecmenUzaklik>();
        for (Secmen Secmen : dataset) {
            double Uzaklik = Math.sqrt(Math.pow(Secmen.x - test.x, 2) + Math.pow(Secmen.y - test.y, 2));
            Uzakliks.add(new SecmenUzaklik(Secmen, Uzaklik));
        }
        Collections.sort(Uzakliks);

        HashMap<String, Integer> classCounts = new HashMap<String, Integer>();
        for (int i = 0; i < k; i++) {
            String SecmenClass = Uzakliks.get(i).Secmen.SecmenClass;
            int count = classCounts.getOrDefault(SecmenClass, 0);
            classCounts.put(SecmenClass, count + 1);
        }

        int maxCount = 0;
        String result = "";
        for (Map.Entry<String, Integer> entry : classCounts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }
    
    
    




}
