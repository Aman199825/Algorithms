class CarPoooling {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips,(a,b)->a[1]-b[1]);
        PriorityQueue<int []> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        for(int [] arr:trips)
        {
            while(!pq.isEmpty() && pq.peek()[2]<=arr[1])
            {
                capacity+=pq.poll()[0];
            }
            capacity-=arr[0];
            if(capacity<0)
                return false;
            pq.add(arr);
           // capacity
        }
        return true;
    }
}