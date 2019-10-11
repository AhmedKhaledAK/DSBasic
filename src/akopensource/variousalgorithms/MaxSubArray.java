package akopensource.variousalgorithms;

// the maximum sub-array problem

import akopensource.tuples.Triplet;

public class MaxSubArray {

    private int leftIndex, rightIndex, maxSum;
    private int [] subArray;

    public Triplet findMaxSubArray(int [] ar, int low, int high){
        if(low == high)
            return new Triplet(low, high,ar[low]);
        else {
            int mid = (low+high)/2;
            Triplet leftTriplet = findMaxSubArray(ar,low,mid);
            Triplet rightTriplet = findMaxSubArray(ar,mid+1,high);
            Triplet midCrossTriplet = findMaxCrossingArray(ar,low,mid,high);

            if( (Integer) leftTriplet.getThirdElem() >= (Integer) rightTriplet.getThirdElem()
                    && (Integer) leftTriplet.getThirdElem() >= (Integer) midCrossTriplet.getThirdElem())
                return leftTriplet;
            else if((Integer) rightTriplet.getThirdElem() >= (Integer) leftTriplet.getThirdElem()
                    && (Integer) rightTriplet.getThirdElem() >= (Integer) midCrossTriplet.getThirdElem())
                return rightTriplet;
            else
                return midCrossTriplet;
        }
    }

    private Triplet findMaxCrossingArray(int[] ar, int low, int mid, int high) {
        return null;
    }

}
