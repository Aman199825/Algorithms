class FrontMiddleBackQueue {
      List<Integer> list=null;
    public FrontMiddleBackQueue() {
        list=new ArrayList<>();
    }
    
    public void pushFront(int val) {
        list.add(0,val);
    }
    
    public void pushMiddle(int val) {
        int size=list.size();
           if(size==0)
           {
               list.add(val);
               return;
           }
        if(size==1)
        {
            list.add(0,val);
            return;
        }
           if(size==2)
           {
               list.add(1,val);
               return;
           }
            if(size%2==0)
            {
                list.add((size/2),val);
                return;
            }
        list.add(size/2,val);
    }
    
    public void pushBack(int val) {
        
        list.add(val);
    }
    
    public int popFront() {
        if(list.isEmpty())
            return -1;
       return list.remove(0);
    }
    
    public int popMiddle() {
      if(list.isEmpty())
            return -1;
        
            int size=list.size();
         
           /*if(size==1)
           {
               return list.remove(1);
           }*/
          if(size==2)
           {
               return list.remove(0);
              
           }
       if(size%2==0)
            {
                
                return list.remove((size/2-1));
            }
        return list.remove(size/2);
       
    }
    
    public int popBack() {
        if(list.isEmpty())
            return -1;
        return list.remove(list.size()-1);
    }
}