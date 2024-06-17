// BINARY SEARCH IN JAVA 

import java.util.*;

public class bs{
    static int BS(int[] arr,int x){
        int l=0;
        int h=arr.length-1;

        while(l<=h){
            int mid=(l+h)/2;
            if (arr[mid]==x){
                return mid;
            }
            else if (arr[mid]>x){
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return -1;
    }

    // main 
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("enter the size of array");
        int n=sc.nextInt();
        int arr[] =new int[n];
        System.out.println("Enter the elements of array");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("The Elements of array are");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println( );
        System.out.println("Enter the element to be search");
        int x=sc.nextInt();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int result = BS(arr,x);
        if(result==-1){
            System.out.println("Element not present");
        }
        else{
            System.out.println("Element found at index "+ " "+result);
        }
        sc.close();
    }
}