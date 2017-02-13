// Andrew Qu
// APCS2 pd5
// HW06 -- Step 1: Split, Step 2: ?, Step 3: Sorted!
// 2017-02-13

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm: 
  The algorithm involves two functions, merge() and sort(). 
  merge() takes two SORTED integer arrays and returns a sorted integer array that holds all the elements from the inputted arrays. merge() works by creating an integer array with the combined length of the inputted arrays. It then looks at the first elements of the inputted arrays, "moving" the lower one to the new array, although in reality, the inputted arrays are unchanged. When the end of either inputted array is reached, the rest of the other array is added to the new array instead, and the new array is outputted.
  sort() takes an integer array and returns a sorted version. If the input array holds just one element, it is returned. Otherwise, it creates two new arrays, each holding half of the input array. It then merges the sort()ed version of both arrays. Eventually, the input array will be halved down to single-element arrays. These are then put back together with merge(), so they get sorted at the same time. After a ton of merging, you have a sorted version of the input array.

  ======================================*/

public class MergeSort {

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

    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) { //makes all elements zero
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0; //alters the inputted array
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) {


	int[] arr0 = {0};
	int[] arr1 = {1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,3,4};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {9,42,17,63,0,512,23};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};

	//System.out.println("\nTesting mess-with-array method...");
	//printArray( arr3 );
	//mess(arr3);
	//printArray( arr3 );
	printArray( arr5 );
	printArray( sort( arr5 ) );
	arr5 = sort( arr5 );

	System.out.println("\nMerging arr4 and arr5: ");
	printArray( merge(arr4,arr5) ); //[1,1,2,2,3,3,4,4,]

	System.out.println("\nMerging arr4 and arr6: ");
	printArray( merge(arr4,arr6) );
	printArray( merge(arr4,sort( arr6 )) );

	System.out.println("\nSorting arr4-7...");
	printArray( sort( arr4 ) );
	printArray( sort( arr5 ) );
	printArray( sort( arr6 ) );
	printArray( sort( arr7 ) );
	/*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class MergeSort

