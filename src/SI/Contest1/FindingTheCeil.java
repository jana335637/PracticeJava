package SI.Contest1;

import java.util.Scanner;

/**
 * Created by pillutja on 8/26/2018.
 */
public class FindingTheCeil {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int arraySize = in.nextInt();
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = in.nextInt();
        }
        mergeSort(array,0,arraySize-1);
        int queriesSize = in.nextInt();
        int[] queries = new int[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
            queries[i] = in.nextInt();
            System.out.println(MBS(array,0,array.length-1,queries[i]));
        }
    }

    private static int MBSIterative(int[] array, int low, int high, int key) {
        while(low<high)
        {
            int mid =low+(high-low)/2;
            if(array[mid]>=key){
                high=mid;
            }
            else
                low=mid+1;
        }
        if(low==array.length-1 && array[low]<key){
                return Integer.MAX_VALUE;
        }
        return array[low];
    }

    private static int MBS(int[] array, int low, int high, int key) {
        int mid=low+(high-low+1)/2;
        if(mid==array.length-1)
        {
            if(array[mid]>key)
                return array[mid];
            else
                return Integer.MAX_VALUE;
        }
        if((array[mid]>=key && mid==0) ||(array[mid]>=key && (mid-1)>=0 && array[mid-1]<key))
            return array[mid];
        if(array[mid]>key)
            return MBS(array,low,mid-1,key);
        return MBS(array,mid,high,key);
    }

    private static void mergeSort(int[] array,int low,int high) {
        int mid= low+(high-low)/2;
        if(low==high)
            return ;
        mergeSort(array,low,mid);
        mergeSort(array,mid+1,high);
        merge(array,low,mid,high);
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int i=low,j=mid+1,k=0;
        while(i<=mid && j<=high)
        {
            if(array[i]<array[j])
            {
                temp[k++]=array[i++];}
            else
            {
                temp[k++]=array[j++];
            }

        }
        while(i<=mid){
            temp[k++]=array[i++];
        }
        while(j<=high) {
            temp[k++]=array[j++];
        }
        for (int l = low; l <= high; l++) {
            array[l]=temp[l-low];
        }
    }
}
