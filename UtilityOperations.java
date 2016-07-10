
public class UtilityOperations {
    
    public static int overflow(int t) {
        t = t/10000;
        return t%10000;
    }
    
    public static int underflow(int t) {
        return t%10000;
        
    }
        
    public static int digits(int t) {
        int a=0;
    	while(t!=0){
    		a++;
    		t=t/10;
    	}
    	return a;
    }
    
}
