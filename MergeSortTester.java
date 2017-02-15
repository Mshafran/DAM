//Team DAM
//Daniel Regassa, Andrew Qu, Mark Shafran
//APCS2 pd05
//HW07 -- What Does The Data Say?
//2017-02-15

/*======================================
  class MergeSortTester

  ALGORITHM:
    The algorithm involves two functions, merge() and sort(). 
  merge() takes two SORTED integer arrays and returns a sorted integer array that holds all the elements from the inputted arrays. merge() works by creating an integer array with the combined length of the inputted arrays. It then looks at the first elements of the inputted arrays, "moving" the lower one to the new array, although in reality, the inputted arrays are unchanged. When the end of either inputted array is reached, the rest of the other array is added to the new array instead, and the new array is outputted.
  sort() takes an integer array and returns a sorted version. If the input array holds just one element, it is returned. Otherwise, it creates two new arrays, each holding half of the input array. It then merges the sort()ed version of both arrays. Eventually, the input array will be halved down to single-element arrays. These are then put back together with merge(), so they get sorted at the same time. After a ton of merging, you have a sorted version of the input array.

  BIG-OH CLASSIFICATION OF ALGORITHM:
  O(nlogn)

  Mean execution times for dataset of size n:
  Batch size: <# of times each dataset size was run>
  n=1       time: 
  n=10      time: 
  n=100     time: 
  ...
  n=<huge>  time: 

  ANALYSIS:
  <INSERT YOUR RESULTS ANALYSIS HERE>
  ======================================*/

public class MergeSortTester
{
    /*====================================================
                        MergeSort
      ==================================================*/

   /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b ) 
    {
	int x = a.length + b.length;
	int[] out = new int[x];
	int y = 0;
	int z = 0;
	int i = 0;
	while(y < a.length && z < b.length){
	    if(a[y] < b[z]){
		out[i] = a[y];
		y += 1;
	    }
	    else{
		out[i] = b[z];
		z += 1;
	    }
	    i += 1;
	}
	if(y >= a.length)
	    while(z < b.length){
		out[i] = b[z];
		z += 1;
		i += 1;
	    }
	else
	    while(y < a.length){
		out[i] = a[y];
		y += 1;
		i += 1;
	    }
	return out;
    }//end merge()


    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr ) 
    {
	if(arr.length == 1)
	    return arr;
	else{
	    int a = arr.length / 2;
	    int b = arr.length / 2;
	    if (arr.length % 2 == 1) //odd number of elements
		b += 1; //one array will be longer
	    int[] uno = new int[a];
	    int[] dos = new int[b];	    
	   
	    for(int i = 0;i < uno.length;i++)//fill with first half of elements
		uno[i] = arr[i];
	    for(int x = 0;x < dos.length;x++)//fill with second half
		dos[x] = arr[x + a];//start from where first loop left off
	    return merge(sort(uno),sort(dos));
	}
    }//end sort()

    /*====================================================
                     End MergeSort
      ==================================================*/


    /******************************
     * execution time analysis 
     * <INSERT YOUR DESCRIPTION HERE OF 
     *  YOUR APPARATUS FOR GENERATING EXECUTION 
     *  TIME DATA...>
     ******************************/

    public static int[] randomArr( int n ) {
	int[] retArr = new int[n];
	for (int x=0; x < retArr.length ; x++) {
	    retArr[x] = (int) (Math.random()*1000000000000000000000000);
	}
	return retArr;
    }
    
    public static long mergeTime( int[] arr, int trials ) {
	int x = 0;
	long timeNow = System.nanotime();
	while (x< trials) {
	    sort(arr);
	    x++;
	}
	long timeElapsed = System.nanotime() - timeNow;
	long avgTime = timeElapsed /((long)( trials));
	return avgTime;
    }
	
    public static void main( String[] args ) 
    {
	int[] arr1 = randomArr( 1 );
	long size1 = mergeTime( arr1, 1000000000);
	System.out.println("This is the avg time for mergeSort of array of size 1: " + size1);
	//STILL HAVE TO REPEAT STUFF ABOVE WITH A BUNCH OF OTHER VALUES FOR RANDOMARR, PRIMARILY 10, 100, 1000, 10000000, 10000000000000, ETC
	
	
    }//end main

}//end class
