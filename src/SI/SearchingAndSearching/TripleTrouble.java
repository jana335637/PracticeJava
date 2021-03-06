package SI.SearchingAndSearching;

import java.util.Scanner;

/**
 * Created by pillutja on 8/26/2018.
 */
public class TripleTrouble {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        int testCases = in.nextInt();
        for (int i = 0; i < testCases; i++) {
            tripleTrouble();
        }
    }

    private static void tripleTrouble() {
        int arraySize = in.nextInt();
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i]=in.nextInt();
        }
        mergeSort(array,0,arraySize-1);
        int i=0;
        while(i<arraySize){
         if((i==(arraySize-1))||array[i]!=array[i+1]){
             System.out.println(array[i]);
             break;
         }
         else
         {
             i+=3;
         }
        }
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