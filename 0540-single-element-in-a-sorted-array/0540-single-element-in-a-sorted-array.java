class Solution {
    public int singleNonDuplicate(int[] nums) {
       int n = nums.length;
        int s=0;
        int e=n-1;

        while (s<=e){
            int mid=s+(e-s)/2;
            //single element 
            if (s==e){
                return nums[s];
            }
            //non single element array
            //check whether mid element is a answer or not 
            int currentvalue=nums[mid];

            int prevalue=-1;
            if (mid-1>=0){
                prevalue=nums[mid-1];
                
            }
            int nextvalue=-1;
            if (mid+1<n){
                nextvalue = nums [mid+1];
            }

            if (currentvalue != prevalue && currentvalue!=nextvalue){
                //iska mtlb currentvalue answer hai
                return currentvalue;
            }
            if (currentvalue!= prevalue && currentvalue==nextvalue){
               int startingindexofpair=mid;
               if((startingindexofpair & 1)==1){
                //startingindex->odd wala case
                //answe will be on left side
                e=mid-1;
               } 
               else {
                 //startingindex->even wala case
                //answe will be on right side
                s=mid+1;
               }
            }
            else if (currentvalue==prevalue && currentvalue!=nextvalue){
                int endingindexofpair=mid;
                if ((endingindexofpair & 1)==1){
                    //endingindex -> odd hai 
                    //move to right
                    s=mid+1;
                }
                else {
                     //endingindex -> even hai 
                    //move to left
                    e=mid-1;

                }
            }
        

        }
        return -1;

        
    }
}