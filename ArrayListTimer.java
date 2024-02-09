package list;

import javax.swing.SortingFocusTraversalPolicy;

public class ArrayListTimer {
    
    public static double run(int maxSize, int capacityIncrement){
        CapacityArrayList arrayList1 = new CapacityArrayList<String>(2, capacityIncrement);
        Stopwatch happyStopwatch = new Stopwatch();
        System.gc();
        happyStopwatch.start();
        while (arrayList1.size() <= maxSize){
            arrayList1.add("Hee hee ha ha");
        }
        return happyStopwatch.elapsedTime();
    }

    public static CapacityArrayList<Double> trial(int maxSize, CapacityArrayList<Integer> capacityIncrements){
        CapacityArrayList arrayHooray = new CapacityArrayList<Double>(capacityIncrements.size());
        for (int i = 0; i < capacityIncrements.size(); i++) {
            arrayHooray.add(run(maxSize, capacityIncrements.get(i)));
        }  
    return arrayHooray;
    
    }

   
   
     public static void main(String[] args) {
        System.out.println(run(10, 2));
        CapacityArrayList <Integer> capInc = new CapacityArrayList<Integer>(3);
        capInc.add(1);
        capInc.add(10);
        capInc.add(0);


        System.out.format("%8s | %12s | %12s | %12s%n", "size", "linear (1)", "linear (10)", "double");
        System.out.format("%8s | %12s | %12s | %12s%n", "--------", "------------", "------------", "------------");
        for (int magnitude = 1000; magnitude <= 256000; magnitude *= 2){
            CapacityArrayList <Double> goose = trial(magnitude, capInc);
            System.out.format("%8d | %12f | %12f | %12f%n", magnitude, goose.get(0), goose.get(1), goose.get(2));
        }
        }
}
