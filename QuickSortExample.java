

class QuickSortExample{
    public static void Quicksort(int[] arr, int low , int high){
        if(low<high){
            int pi=partition(arr , low ,high);

            Quicksort(arr, low, pi-1);
            Quicksort(arr, pi+1, high);
        }
    }

    public static int  partition(int[] arr, int low , int high){
        int pivot=arr[high];
        int i=low-1;

        for(int j=low;j<high;j++){
            if(arr[j]<pivot){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }

        int temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;

        return i+1;
    }


    public static void main(String[] args) {
        int[] arr={10,20,4,23,346,34};
        int n=arr.length;

        System.out.print("Original Array\n");
        for (int num:arr){
            System.out.print(num+" ");
        }
        Quicksort(arr, 0, n-1);
        System.out.print("\nAfter sorting\n");
        for(int num:arr){
            System.out.print(num+" ");
        }
    }
}