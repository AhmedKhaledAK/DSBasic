package akopensource.variousalgorithms;

// the maximum sub-array problem

import akopensource.tuples.Triplet;

public class MaxSubArray {

    private int leftIndex, rightIndex, maxSum;
    int [] subArray, orgArray;

    public MaxSubArray(int [] ar){
        orgArray = ar;
    }


    public Triplet findMaxSubArray(int [] ar, int low, int high){
        if(low == high) {
            leftIndex = low;
            rightIndex = high;
            maxSum=ar[low];
            return new Triplet(low, high, ar[low]);
        }
        else {
            int mid = (low+high)/2;
            Triplet leftTriplet = findMaxSubArray(ar,low,mid);
            Triplet rightTriplet = findMaxSubArray(ar,mid+1,high);
            Triplet midCrossTriplet = findMaxCrossingArray(ar,low,mid,high);

            if( (Integer) leftTriplet.getThirdElem() >= (Integer) rightTriplet.getThirdElem()
                    && (Integer) leftTriplet.getThirdElem() >= (Integer) midCrossTriplet.getThirdElem()) {
                leftIndex = (Integer) leftTriplet.getFirstElem();
                rightIndex = (Integer) leftTriplet.getSecondElem();
                maxSum= (Integer) leftTriplet.getThirdElem();
                return leftTriplet;
            }
            else if((Integer) rightTriplet.getThirdElem() >= (Integer) leftTriplet.getThirdElem()
                    && (Integer) rightTriplet.getThirdElem() >= (Integer) midCrossTriplet.getThirdElem()) {
                leftIndex = (Integer) rightTriplet.getFirstElem();
                rightIndex = (Integer) rightTriplet.getSecondElem();
                maxSum= (Integer) rightTriplet.getThirdElem();
                return rightTriplet;
            }
            else {
                leftIndex = (Integer) midCrossTriplet.getFirstElem();
                rightIndex = (Integer) midCrossTriplet.getSecondElem();
                maxSum= (Integer) midCrossTriplet.getThirdElem();
                return midCrossTriplet;
            }
        }
    }

    private Triplet findMaxCrossingArray(int[] ar, int low, int mid, int high) {
        int maxi=-1, maxj=-1, leftsum = Integer.MIN_VALUE, rightsum = Integer.MIN_VALUE, sum=0;
        for (int i = mid; i >= low; i--){
            sum+=ar[i];
            if(sum > leftsum){
                leftsum = sum;
                maxi = i;
            }
        }
        sum =0;
        for (int j = mid+1; j <= high; j++){
            sum+=ar[j];
            if(sum > rightsum){
                rightsum = sum;
                maxj = j;
            }
        }
        return new Triplet(maxi,maxj,leftsum+rightsum);
    }

    public int [] getMaxSubArray(){
        this.subArray = new int[rightIndex-leftIndex+1];

        int j = 0;
        for(int i =leftIndex; i <= rightIndex; i++)
            this.subArray[j++] = this.orgArray[i];

        return this.subArray;
    }

}
