# DAM
Finding empirical evidence to classify execution time of mergesort

To classify the execution time of mergesort, we had to test it on arrays differing in size from small to very large. We wrote a helper function that generated 
an array of a desired length that held random integers. We then ran mergesort many times on each of these arrays, timing how long it took to finish all of these tests and then dividing by the number of tests to get an average runtime. We timed mergesort by using System.nanoTime(): we recorded the current time in nanoseconds, and then the time after running all the tests, and the difference would be the time elapsed. This was repeated for arrays of varying length until we had all of our data.

While we expected our runtime to be O(nlogn), the resulting line graph of our data looks linear. This could be attributed to mistakes in testing or in writing our testing code. However, mergesort definitely appears to be faster than O(n*n).
https://docs.google.com/document/d/1_Momxw-oz2LG1Fxo1e8EEzTLNLJoobzw9Xoo4Aa08NA/pub