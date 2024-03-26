/*
    Autor: Ivan Spalla Ugalde
    Implementacion de Va de modas...
    Algoritmo utilizado: Quicksort
    Modificacion utilizada: Hacer la mediana entre el primer elemento, el elemento del medio y el ultimo elemento

 */
public class Main {

    static int[] arr;
    static java.util.Scanner in;

    public static boolean casoDePrueba(){

        int i = in.nextInt();
        if (i == 0){
            return false;
        }
        else {
            arr = new int[i];
            for(int j = 0; j < i; j++){
                int n = in.nextInt();
                arr[j] = n;
            }
            return true;
        }
    }
    public static void main(String[] args) {
        in = new java.util.Scanner(System.in);
        while (casoDePrueba()){
            quickSort(arr, 0, (arr.length - 1));
            System.out.println(arr[findNum(arr)]);
        }
    }

    public static int findNum(int[] array){

        int lastNum = array[0];
        int foundNum = 0;
        int count = 1;
        int maxcount = 1;

        for (int i = 1; i < array.length; i++){
            if (array[i] == lastNum) count++;
            else {
                if (count > maxcount){
                    maxcount = count;
                    foundNum = i - count;
                }
                count = 1;
                lastNum = array[i];
            }
        }

        if (count > maxcount){
            foundNum = array.length - count;
        }

        return foundNum;
    }

    //Implementacion de quicksort vista en los apuntes con la modificacion de usar la mediana entre el primer elemento, el ultimo y el del medio
    public static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int split = partition(arr, low, high);

            quickSort(arr, low, split - 1);
            quickSort(arr, split + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high){
        int len = (high + low)/2;
        median(arr, low, len, high);
        int pivot = arr[high];
        int split = low;

        for (int j = low; j <= high - 1; j++){
            if (arr[j] < pivot){
                swap(arr, split, j);
                split++;
            }
        }
        swap(arr, split, high);
        return split;
    }

    public static void median(int[] arr, int low, int mid, int high){
        if (arr[low] > arr[mid]){
            swap(arr, low, mid);
        }
        if (arr[low] > arr[high]){
            swap(arr,low,high);
        }
        else {
            if (arr[mid] < arr[high]){
                swap(arr, mid, high);
            }
        }
    }

    public static void swap(int[] arr, int split, int pivot){
        int aux = arr[pivot];
        arr[pivot] = arr[split];
        arr[split] = aux;
    }
}