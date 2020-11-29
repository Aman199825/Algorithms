class MergeInBetweenLinkedLists{
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode hold1=list1,hold2=list1;
        if(list1==null)
            return null;
        int i=0;
        for(int j=0;j<a-1;j++)
        {
            hold1=hold1.next;
        }
        for(;i<a;i++)
        {
            //hold1=hold1.next;
            hold2=hold2.next;
        }
        for(;i<=b;i++)
        {
            System.out.println(hold2.val);
            if(hold2.next==null)
            {
                hold2=null;
                break;
            }
            hold2=hold2.next;
            
        }
        while(list2!=null)
        {
            System.out.println("here");
          hold1.next=new ListNode(list2.val);
            hold1=hold1.next;
            list2=list2.next;
        }
        System.out.println(hold2.val);
        hold1.next=hold2;
        return list1;
    }
}