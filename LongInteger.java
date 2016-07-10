public class LongInteger {

	
	
	
	//private SimpleList list = new SLLSimpleList();
	private SimpleList list = new ArraySimpleList();

	 private boolean isNegative = false;
	 int flag=0,length=0;
	 UtilityOperations up1=new UtilityOperations();
	 char sign= '+';
	 

	 public void list(){
			
			Position x;
			if(list.size()>1){
				x = list.last();
			
			System.out.print(x.getValue());
			System.out.print(" ");
			while(list.before(x)!= null){
				if(!list.isFirst(x))
				System.out.print(String.format("%04d",list.before(x).getValue()));
				System.out.print(" ");
				x = list.before(x);
			}
			System.out.println();
			}
			else if(list.size() == 1){
				x = list.first();
				System.out.print(x.getValue());
				System.out.println();
			}
		}
	 
	 public LongInteger(String s) {
		String s1 = "";
		if(s.startsWith("-")){
			sign='-';
			flag=1;
			this.setSign();
			s = s.substring(1,s.length());
		}
		
		while(s.length()>4){   
				s1 = s.substring(Math.max(0, s.length()-4));
				
				list.insertLast(Integer.parseInt(s1));
				
				s = s.substring(0, s.length()-4);
		}
			if(s.length() <= 4){
				
				list.insertLast(Integer.parseInt(s));
				
		}
	}
	
	
	public LongInteger() {

	}


	
	public void output() {

		
		Position p;
		if(list.size()>1){
			p = list.last();
		
		if(this.getSign()){
			System.out.print("-");
		}
		
		System.out.print(String.format("%04d",p.getValue()));
		while(list.before(p)!=null){
			System.out.print(String.format("%04d",list.before(p).getValue()));
		
			p = list.before(p);
		}
		
	}
		else if(list.size() == 1){
			if(this.getSign()){
				System.out.print("-");
			}
			p = list.first();
			System.out.print(p.getValue());
			System.out.println();
		}
	}

	public void setSign(){
		this.isNegative = true;
	}
	public boolean getSign() {
		return isNegative;
	}

	public int getDigitCount() {
		
		Position temp = list.last();
		if(list.size() == 1){
			temp = list.first();
		}
		int init = (int)(Math.log10(temp.getValue())+1);
		return init + (list.size() - 1)*4;
	}

	/*
	public boolean equalTo(LongInteger i) 
    {
    	
        if(this.sign!=i.sign)
        	return false;
        	else if(i.getDigitCount() == this.getDigitCount() && i.sign==this.sign) {
    			SLLNode a1 = (SLLNode) list.first();
    			SLLNode a2 = (SLLNode) i.list.first();
    			
    			for (int j = 0; j < list.size(); j++) {
    				if (a1.getValue() > a2.getValue())
    				{
    					return false;
    				}
    				else if (a1.getValue()<a2.getValue())
    					{
    					return false;
    					}
    			}
    			
    				return true;
        	}
        	else
        	{
        		return false;
        	}
        
    }
	
	*/
	
	
	
	public boolean equalTo(LongInteger i) {
		if(this.getSign() != i.getSign()){
			return false;
		}
		if(this.getDigitCount()!= i.getDigitCount()){
			return false;
		}
		
		Position a1 = this.list.last();
		
		Position a2 = i.list.last();

		
		for(int max=1; max<this.list.size();max++){
			if(a1.getValue() == a2.getValue()){
				a1 = this.list.before(a1);
				a2 = i.list.before(a2);
			}
			else{
				return false;
			}

		}
		if(a1.getValue() == a2.getValue())
			return true;
		else
			return false;
	}

	

	
	public boolean lessThan(LongInteger i) {
		if(this.getSign() != i.getSign()){
			if(this.getSign() == true && i.getSign() == false)
				return true;
		}
		if(this.getSign() != true && i.getSign() != true){
			if(this.getDigitCount()!= i.getDigitCount()){
				if(this.getDigitCount()<i.getDigitCount())
					return true;
				if(this.getDigitCount()>i.getDigitCount())
					return false;
			}
			
			Position a1 = this.list.last();
			
			Position a2 = i.list.last();

			
				for(int max=1; max<this.list.size();max++){
				if(a1.getValue() < a2.getValue()){
					return true;
				}
				if(a1.getValue() > a2.getValue()){
					return false;
				}
				if(a1.getValue() == a2.getValue()){
					a1 = this.list.before(a1);
					a2 = i.list.before(a2);
				}
			}
			if(a1.getValue() < a2.getValue())
				return true;

		}
		if(this.getSign() == true && i.getSign() == true){
			if(this.getDigitCount()!= i.getDigitCount()){
				if(this.getDigitCount()>i.getDigitCount())
					return true;
				if(this.getDigitCount()<i.getDigitCount())
					return false;
			}
			
			Position a1 = this.list.last();;
			
			Position a2 = i.list.last();

			
				for(int max=1; max<this.list.size();max++){
				if(a1.getValue() > a2.getValue()){
					return true;
				}
				if(a1.getValue() < a2.getValue()){
					return false;
				}
				if(a1.getValue() == a2.getValue()){
					a1 = this.list.before(a1);
					a2 = i.list.before(a2);
				}
			}
			if(a1.getValue() > a2.getValue())
				return true;
		}
		return false;
	} 

	/*
public boolean lessThan(LongInteger i) 
    {
    	if(this.sign=='+'&&i.sign=='-')
    		return false;
    	else if(this.sign=='-'&& i.sign=='+'){
        	return true;
        }	
    	else if(this.sign=='-' && i.sign=='-'&& this.list.size() > i.list.size()){
    			return true;
    	}
    	else if(this.sign=='+' && i.sign=='+'&& this.list.size() > i.list.size()){
			return false;
	}
    	else if(this.sign=='+' && i.sign=='+'&& this.list.size() < i.list.size()){
			return true;
	}
    	
    	else if(i.getDigitCount() == this.getDigitCount() && i.sign==this.sign) {
			Position  a1 = this.list.first();
			Position a2 = i.list.first();
			
			for (int j = 0; j < list.size(); j++) {
				if (a1.getValue() >= a2.getValue())
					return false;
				else {
					a1 = this.list.before(a1);
					a2 = i.list.before(a2);
				}
			}
			return true;
    	}
			else{
    		return false;
			}	
    	
    }
	
	*/
	
	
	public boolean greaterThan(LongInteger i) {
		if(this.getSign() != i.getSign()){
			if(this.getSign() == false && i.getSign() == true)
				return true;
		}
		if(this.getSign() != true && i.getSign() != true){
			if(this.getDigitCount()!= i.getDigitCount()){
				if(this.getDigitCount()>i.getDigitCount())
					return true;
				if(this.getDigitCount()<i.getDigitCount())
					return false;
			}
			
			Position a1 = this.list.last();;
			
			Position a2 = i.list.last();

			
				for(int max=1; max<this.list.size();max++){
				if(a1.getValue() > a2.getValue()){
					return true;
				}
				if(a1.getValue() < a2.getValue()){
					return false;
				}
				if(a1.getValue() == a2.getValue()){
					a1 = this.list.before(a1);
					a2 = i.list.before(a2);
				}
			}
			if(a1.getValue() > a2.getValue()){
				return true;
			}
			return false;
		}
		if(this.getSign() == true && i.getSign() == true){
			if(this.getDigitCount()!= i.getDigitCount()){
				if(this.getDigitCount()<i.getDigitCount())
					return true;
				if(this.getDigitCount()>i.getDigitCount())
					return false;
			}
			
			Position a1 = this.list.last();;
			
			Position a2 = i.list.last();
			
			
				for(int max=1; max<this.list.size();max++){
				if(a1.getValue() < a2.getValue()){
					return true;
				}
				if(a1.getValue() > a2.getValue()){
					return false;
				}
				if(a1.getValue() == a2.getValue()){
					a1 = this.list.before(a1);
					a2 = i.list.before(a2);
				}
			}
			if(a1.getValue() < a2.getValue())
				return true;
		}
		return false;
	}
	
	
/*
 public boolean greaterThan(LongInteger i) 
    {
        if(this.sign=='+'&&i.sign=='-')
        {
        	return true;
        }
        else if(this.sign=='-'&& i.sign=='+'){
        	return false;
        }	
        else if(this.sign=='-' && i.sign=='-'&& this.list.size() > i.list.size()){
			return false;
        }
        else if(this.sign=='-' && i.sign=='-'&& this.list.size() < i.list.size()){
			return true
					;
        }
        
        else if(this.sign=='+' && i.sign=='+'&& this.list.size() > i.list.size()){
		return true;
        }
        
        else if(this.list.size() > i.list.size()){
        		
        		return true;
        	}
        		else if(sign == i.sign && i.getDigitCount() == this.getDigitCount()) {
    				SLLNode a1 = (SLLNode) list.first();
    				SLLNode a2 = (SLLNode) i.list.first();
    				for (int j = 0; j < list.size(); j++) {
    					if (a1.getValue() <= a2.getValue())
    						return false;
    					else {
    						a1 = a1.getNext();
    						a2 = a2.getNext();
    					}
    				}
        		return true;
        		}
        
        		return false;
    }
	
	*/
	

	
	public LongInteger add(LongInteger i) {
    	int size1;
    	int addition;
    	int carry=0;
    	LongInteger additionres = new LongInteger();
       if(this.getSign()==i.getSign()){ if(this.getSign())additionres.setSign();
    	   Position p = this.list.first();
    	   Position q = i.list.first();
    	   if(this.list.size()>i.list.size())size1 = i.list.size();
    	   else size1 = this.list.size();
    	   for(int j=1;j<=size1;j++){
    		   addition = p.getValue()+q.getValue()+carry;
    		carry=0;
    		if(UtilityOperations.overflow(addition)!=0)carry=1;
    		additionres.list.insertLast(UtilityOperations.underflow(addition));
    		if(j!=size1){
    		p = this.list.after(p);
    		q = i.list.after(q);
    			}    			
    	   }
    	   if(this.list.size()!=i.list.size()){
    		   if(this.getDigitCount()>i.getDigitCount()){
    			   size1=this.list.size()-size1;
    			   p = this.list.after(p);
    			   for(int j=1;j<=size1;j++){
    				   addition = p.getValue()+carry;
    		    		carry=0;
    		    		if(UtilityOperations.overflow(addition)!=0)carry=1;
    		    		additionres.list.insertLast(UtilityOperations.underflow(addition));
    		    		if(j!=size1){
    		    		p = this.list.after(p);
    		    			}    			
    			   }
    			   if(carry==1)additionres.list.insertLast(UtilityOperations.underflow(carry));
    		   }
    		   else {
    			   size1=i.list.size()-size1;
    			  q = i.list.after(q);
    			   for(int j=1;j<=size1;j++){
    				   addition = q.getValue()+carry;
    				   carry=0;
    		    		if(UtilityOperations.overflow(addition)!=0)carry=1;
    		    		additionres.list.insertLast(UtilityOperations.underflow(addition));
    		    		if(j!=size1){
    		    		q = i.list.after(q);
    		    			}    			
    				   }
    			   if(carry==1)additionres.list.insertLast(UtilityOperations.underflow(carry));   
    		   }    	   }
    	   else if(carry==1)additionres.list.insertLast(carry);
    	   }
       else{
    	   i.isNegative = !i.getSign();
    	  additionres = this.subtract(i);
    	   i.isNegative = !i.getSign();
       }
       return additionres;
    	   
    }
    
	
	
	


	   //Multiplication	 
		
		    public LongInteger multiply(LongInteger i) {
		    	int val=0;
		    	LongInteger finallist = new LongInteger();
		    	if(this.getSign()!=i.getSign())finallist.setSign();
		    	if(this.getDigitCount()<i.getDigitCount()){
		    		LongInteger temp = new LongInteger();
		    		temp.list = this.list;
		    		this.list = i.list;
		    		i.list = temp.list;
		    		val=1;
		    	}
		    	Position m = this.list.first();
		    	Position n = i.list.first();
		    	Position s1 = m;
		    	Position s2 = n;
		    	int overflow=0;
		    	int extraoverflow = 0; 
		    	int underflow = 0;
		    	int multiplication=0;
		    	int j= this.list.size()+ i.list.size();
		    	int preflow = 0;
		    	for(int p=1; p<=j-1;p++){
		    		for(int q=1; q<=p;q++){	
		    			multiplication = m.getValue()*n.getValue();
		    			overflow = overflow + UtilityOperations.overflow(multiplication);
		    			underflow = underflow + UtilityOperations.underflow(multiplication);
		    			if(!i.list.isLast(n)){
		    				m = this.list.before(m);
		    				n = i.list.after(n);
		    				}
		    			else{
		    				q = p+1;
		    				}
		    		}
		    		if(!this.list.isLast(s1)){
		    			n = i.list.first();
		    			m = this.list.after(s1);
		    			s1 = m;
		    		}
		    		else {
		    			if(i.list.isLast(s2)){
		    				p = j+1;
		    				}
		    			else{
		    			n = i.list.after(s2);
		    			s2 = n;
		    			m = s1;
		    			}
		    		}
		    		underflow  = preflow + underflow;
		    		finallist.list.insertLast(UtilityOperations.underflow(underflow));
		    		extraoverflow = overflow + UtilityOperations.overflow(underflow);
		    		preflow = extraoverflow;
		    		overflow = 0;
		    		underflow = 0;
		    		extraoverflow = 0;
		    		} 
		    	while(preflow>0){
		    		finallist.list.insertLast(UtilityOperations.underflow(preflow));preflow = preflow/10000;
		    	}
		    	if(val==1){
		    		LongInteger temp = new LongInteger();
		    		temp.list = this.list;
		    		this.list = i.list;
		    		i.list = temp.list;
		    		val=0;
		    	}   	
		        return finallist;
		    }
		    	
		
			//Power
		    public LongInteger power(int p) {
		    LongInteger powerresult  =new LongInteger(); 
		    if(p%2!=0 && this.getSign())powerresult.setSign();  
		    if(p>=5){
		    	powerresult = this.multiply(this);
		    	powerresult = powerresult.multiply(powerresult);
		    	powerresult = powerresult.multiply(this);	
		    }  if(p>=10){powerresult = powerresult.multiply(powerresult);
		       if(p==20){powerresult = powerresult.multiply(powerresult);}
			   if(p==30){powerresult = powerresult.multiply(powerresult).multiply(powerresult);}	
		    }   
		  return powerresult;
		    	
		    	
		    }
		    
		    
	    //Subtraction
	    public LongInteger subtract(LongInteger i) {
	    	int m;
	    	int subtraction=0;
	    	int borrow=0;
	    	int val=0;
	    	LongInteger subresult = new LongInteger();
	    	if((!this.getSign()&& i.getSign()) || (this.getSign()&&!i.getSign())){
	    		i.isNegative = !i.getSign();
	    		subresult = this.add(i);
	    	}
	    	else {
	    		if(this.getDigitCount()==i.getDigitCount()){
	    				if(this.lessThan(i))subresult.setSign();
	    				}
	    		i.isNegative = !i.getSign();
	    		if(this.getDigitCount()!=i.getDigitCount()){
	    			if(this.getDigitCount()>i.getDigitCount()){
	    			if(this.getSign())subresult.setSign();
	    			}
	    		else{
	    			if(i.getSign())subresult.setSign();}}	
	    		if(this.list.size()>i.list.size())m = i.list.size();
	     	   else m = this.list.size();
	    		if(this.getDigitCount()<i.getDigitCount()){
	        		LongInteger c = new LongInteger();
	        		c.list = this.list;
	        		this.list = i.list;
	        		i.list = c.list;  
	        		val=1;
	        	}
	    		else if(this.getDigitCount()==i.getDigitCount()){
	        		if(this.greaterThan(i)){
	    			LongInteger c = new LongInteger();
	        		c.list = this.list;
	        		this.list = i.list;
	        		i.list = c.list;  
	        		val=1;
	        		}}
	    		Position p = this.list.first();
	     	   Position q = i.list.first();
	    		for(int j=1;j<=m;j++){
	    			if(p.getValue()<q.getValue() && !this.list.isLast(p))
	    			{if(borrow==1){subtraction = (p.getValue()-1)+10000;borrow=1;} 
	    				if(borrow==0){subtraction = p.getValue() + 10000;borrow = 1;}
	    			}else {if(borrow==1){subtraction = (p.getValue()-1)+10000;}
	    				else subtraction  = p.getValue();
	    				borrow = 0;}
	    			subtraction = subtraction - q.getValue();
	    			subresult.list.insertLast(UtilityOperations.underflow(subtraction));
	    			if(j!=m){
	    				p = this.list.after(p);
			    		q = i.list.after(q);
			    			} }
	    		if(this.list.size()!=i.list.size()){
	     		   if(this.getDigitCount()>i.getDigitCount()){
	     			   m=this.list.size()-m;
	     			   p = this.list.after(p);
	     			   for(int j=1;j<=m;j++){if(borrow==1){subtraction = p.getValue()-1;borrow=0;}   
	     				  else subtraction =p.getValue();
	     				 subresult.list.insertLast(UtilityOperations.underflow(subtraction));
	     		    		if(j!=m){p = this.list.after(p);} }}
	     		   else {m=i.list.size()-m; q = i.list.after(q);
	     			   for(int j=1;j<=m;j++){
	     				  subresult.list.insertLast(UtilityOperations.underflow(q.getValue()));
	     		    		if(j!=m){
	     		    		q = i.list.after(q);
	     		    			}  } }	}
	    }
	   if(val==1){
	    		LongInteger c = new LongInteger();
	    		c.list = this.list;
	    		this.list = i.list;
	    		i.list = c.list; 
	    		val=0; 		
	    	}
	    	i.isNegative = !i.getSign();
	  return subresult;
	}
	    
	    /*  public LongInteger subtract(LongInteger i) 
	    {
		   int size1=this.list.size();
		   int size2=i.list.size();
		   int num1=this.list.last().getValue();
		   int num2=i.list.last().getValue();
		   Position td1=this.list.last();
		   Position td2=i.list.last();
		   LongInteger result=new LongInteger();
		   int sub,test;
		   test = size1>size2?size1:size2;
		   
		   if(this.getSign()==true && i.getSign()==true)
		   {
			   result=this.add(i);
		   }
		   else
		   {
			   while(size2>0 || size1>0)
			   {
				   sub=Math.abs(num2-num1);
				   result.list.insertFirst(sub);
				
				   
				   td1=this.list.before(td1,size1);
				   size1-=1;
				   if(size1<=0)
					   num1=0;
				   else
					   num1=td1.getValue();
				   
				   td2=i.list.before(td2,size2);
				   size2-=1;
				   if(size2<=0)
					   num2=0;
				   else
					   num2=td2.getValue();
				   
			   }
			   size1=this.list.size();
			   size2=i.list.size();
			   
			   if(test==size1)
			   {
				   if(this.getSign())
					   System.out.print("-");
			   }
			   else
				   if(test==size2)
				   {
					   if(i.getSign())
						   System.out.print("-");
				   }
		   }
		  return result; 
	    } */
	    

	    

	
}
