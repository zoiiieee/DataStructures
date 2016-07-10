public class ArraySimpleList implements SimpleList<ArrayEntry> {
	
	
	private int n=0;
	
	
	private int arraySize=4;
    
    public ArraySimpleList() {
        n = 0;
        arraySize = 4;
    }
    
    ArrayEntry array1[] = new ArrayEntry[arraySize];
    
    
    public void insertLast(int value) {
if(n==0){    		
    		array1[0] = new ArrayEntry(value,n);
    		n++;    		
    	}
    	else{
    			if(n==arraySize){			
    				ArrayEntry array2[] = new ArrayEntry[arraySize];
    	    		array2= array1;
    				array1= new ArrayEntry[arraySize*2];
    				for(int i = 0;i<arraySize;i++){	
        				array1[i] = array2[i];
        				if(i==array2.length){
        					i = arraySize+1;
        				} 
    				}
    				arraySize = arraySize*2;
    			}
    			array1[n] = new ArrayEntry(value,n);
        		n++;
    	}
    }
    
    public ArrayEntry first() {
    	  		return array1[0];
    }

    public void insertFirst(int value) {
    	if(n==0){    		
		array1[0] = new ArrayEntry(value,n);
    		n++;    		}
    	else{
    		ArrayEntry array2[] = new ArrayEntry[arraySize];
    		array2= array1;
    		if(n==arraySize){
    			array1= new ArrayEntry[arraySize*2];
    			arraySize = arraySize*2;
    			}
    		array1[0] = new ArrayEntry(value,0);
    		System.arraycopy(array2, 0, array1, 0, arraySize);
    		for(int i = 1;i<=arraySize;i++){
    				array1[i] = array2[i];
    				if(i==array2.length){
    					i = arraySize+1;}    			
    		n++;
    		}
    	}
    }
    
    
    
    
    public ArrayEntry last() {
    		return array1[n-1];
    }

    public boolean isFirst(ArrayEntry p) {
    	if(p==array1[0]){
    		return true;
    	}
    	else return false;
    }

    public boolean isLast(ArrayEntry p) {
    	if(p==array1[n-1]){
    		return true;
    	}
    	else return false;
    }

    public ArrayEntry before(ArrayEntry p) {
    	
    	if(p==array1[0]){
    		return null;
    	}
    	
    	else{
    	return array1[p.getIndex()-1];
    	}
    }
    

    public ArrayEntry after(ArrayEntry p) {
    	
    	if(p==array1[n-1]){
    		return null;
    	}
    	else
    	return array1[p.getIndex()+1];
    }

    public boolean isEmpty() {
    	
    	if(n==0)
    		return true;
    	else
    		return false;
 
    }

    public int size() {  
    	return n;
    }
    
}
