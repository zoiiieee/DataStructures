
public class SLLSimpleList implements SimpleList<SLLNode> {

    private SLLNode head;
	private SLLNode tail;
	int counter;
    
    public SLLSimpleList() {
        head = null;
        tail = null;
    }
    
    public void insertFirst(int value) 
    {
    	if(isEmpty()){
    		SLLNode node = new SLLNode(value);
    		head = node;
    		tail = node;
    	}
    	else{
        	SLLNode node=new SLLNode(value);
        	node.setNext(head);
        	head=node;
    	}
    	counter++;		
    }
    
    public void insertLast(int value) 
    {
        SLLNode node=new SLLNode(value);
        node.setNext(null);
        if(tail==null)
        {
        	head=node;
        	tail=node;
        }
        else
        {
        	tail.setNext(node);
        	tail=node;
        }
        counter++;  
    }
    
    
    public SLLNode first() 
    {
    	if(isEmpty()){
    		return null;
    	}
    	else{
        return head;
    	}
    }

    public SLLNode last() 
    {
    	if(isEmpty()){
    		return null;
    	}
    	
    	else{
    
    		return tail;
    	}
    	
    }
    
    
    public boolean isFirst(SLLNode p) 
    {
    	if(head == p)
		{
			return true;
		}
		
		else
		{
			return false;	
		}
    }
    
    
    public boolean isLast(SLLNode p) 
    {
    	if(p==tail){
        	return true;
    	}
    	
        	else{
        	return false;
    
        	}
    }
    

    public SLLNode before(SLLNode p) {
    	SLLNode current_node = head;
    			   while(!current_node.equals(tail)){
    			       if(current_node.getNext().equals(p))
    			          return current_node;
    			       else
    			          current_node = current_node.getNext();
    			          }
    			   return null;
    }

    public SLLNode after(SLLNode p) {
        return p.getNext();
    }

    public boolean isEmpty() 
    {
        return head==null;
    }
    
    
    public int size() 
    {
    	//return counter;
    	
    	int size = 0;
 	   for(SLLNode n = head; n != null; n = n.getNext())
 	       size++;     
 	   return size;
 	}
    
    public void setHead(int head){
    	this.head = new SLLNode(head);
    }
    
    public void setTail(int tail){
    	this.tail = new SLLNode(tail);
    }
  
}
