package list;

public class ArrayListTimer {
    
    public static double run(int maxSize, int capacityIncrement){
        CapacityArrayList arrayList1 = new CapacityArrayList<String>(2, capacityIncrement);
        Stopwatch happyStopwatch = new Stopwatch();
        System.gc();
        happyStopwatch.start();
        while (arrayList1.size() <= maxSize){
            arrayList1.add("Hee hee ha ha");
        }
        System.out.println(happyStopwatch.elapsedTime());
        return happyStopwatch.elapsedTime();
    }

    public static CapacityArrayList<Double> trial(int maxSize, CapacityArrayList<Integer> capacityIncrements){
        CapacityArrayList arrayHooray = new CapacityArrayList<Double>(maxSize);
        for (int i = 0; i < capacityIncrements.size(); i++) {
            arrayHooray.add(run(maxSize, CapacityIncrements[i]));
        }  
    return arrayHooray;
    
    }

   
   
     public static void main(String[] args) {
//         System.out.println(run(10, 2));
//         CapacityArrayList <Integer> capInc = new CapacityArrayList<Integer>(1000, 10);
//         System.out.println(trial(1000, capInc));
        System.out.println("main print");
        
//     }
}
}