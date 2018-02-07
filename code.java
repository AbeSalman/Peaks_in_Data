package as_peaks_in_data;
/**
 *
 * @author iCloud
 */
public class AS_Peaks_in_Data {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //given data array to scan through and find peaks// 
        
        float [] x = {0.2f, 0.5f, 0.1f, 0.15f, 0.2f, 0.13f, 0.3f, 0.25f, 0.3f, 0.3f,

                      0.7f, 0.2f, 0.45f, 0.15f, 0.2f, 0.85f, 0.3f, 0.65f, 0.2f, 0.1f};
        
       
        // print the given array data above up to its forth decimal point// 
        
        int peakCount = 0; 
        
        System.out.print("Data array: ");    
    
        for (int i = 0; i<x.length; i++) { /*loop PLUS statements to allocate space and print array in two rows*/  
            
            if (i%10==0) { 
                System.out.println();
            }
            System.out.printf("%.4f ", x[i]);
        } 
        System.out.println("\n");
        
        
        //test each element of the array if it was peak or not// 
        
        for (int i=1; i<x.length-1; i++) { /*loop PLUS statements to seek and find peaks*/ 
            
            if(x[i]>x[i-1]*2.0 && x[i]>x[i+1]*2.0) { 
                
                peakCount++; 
            }
        }
        
        int [] peaks = new int [peakCount]; 
        
        int index = 0; 
        
        for (int i = 1; i<x.length-1; i++) { 
            
            if (x[i]>x[i-1]*2.0 && x[i]>x[i+1]*2.0){ 
                
                peaks [index++] = i; 
            }
        }    
        
        
        //determine & print peak elements along with their indexes in non-decending order// 
        
        System.out.println(peakCount + " Peaks found: "); 
        
        for (int i=0; i<peakCount; i++){ /*loop and statments to store result and print them*/ 
        
            System.out.println(peaks[i] + "  " + x[peaks[i]]);
            
        }  
        
        //Extra credit code to sort founded peaks in descending order according to their magnitudes//
        
        System.out.println("\n");
        System.out.println("Sorted peaks: "); 

	for (int i=0; i<peakCount; i++) {   /*loops & statements to find smallest element*/
	    float currentMin = x[peaks[i]];
	    int minIndex = i;

	    for (int j=i+1; j < peakCount; j++) {
		if (x[peaks[j]] < currentMin) {
		    currentMin = x[peaks[j]];
		    minIndex = j;
		}
	    }
	    if (minIndex != i) {            /*statements to swap smallest element with initiated swapper*/ 
		int swap; 
                swap = peaks[i]; 
                peaks[i] = peaks[minIndex];  
                peaks[minIndex] = swap;
	    }
	}

	for (int i=0; i<peakCount; i++) {
	    System.out.println(peaks[i] + "  " + x[peaks[i]]);

        }
    } 
}   
