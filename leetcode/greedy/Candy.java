public class Candy {
    public int candy(int[] ratings) {
         int n=ratings.length;
        int [] candies=new int[n];
        Arrays.fill(candies,1);
        //why two pass: because updating the number of candies of neighbours in both direction will generate a need for checking elements in the whole array leading to complexity of O(n^2)
        for(int i=1;i<n;i++)
        {
            if(ratings[i]>ratings[i-1])
               candies[i]=candies[i-1]+1;
        }
        for(int i=n-2;i>=0;i--)
        {
            if(ratings[i]>ratings[i+1])
                candies[i]=Math.max(candies[i],candies[i+1]+1);
        }
        return Arrays.stream(candies).sum();
    }
}