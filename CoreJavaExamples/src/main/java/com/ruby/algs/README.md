### Union Find Algorithms
#### Concepts
 - union–find data type is also known as the disjoint-sets data type
 - The union–find data type models connectivity among a set of n sites, named 0 through n–1
 - The is-connected-to relation must be an equivalence relation:
   * Reflexive : p is connected to  p
   * Symmetric : if p is connected to q then q is connected to p
   * transitive : if p is connected to q and q is connected to r then p is connected to r
 - An equivalence relation partitions the sites into equivalence classes or components
 - two sites are in the same component if and only if they are connected.
 - Both sites and components are identified with integers between 0 and n-1
 - Initially, there are n components, with each site in its own component.
 - The component identifier of a component (also known as the root, canonical element, leader, or set representative) is one of the sites in the component
 - two sites have the same component identifier if and only if they are in the same component.
 - union p, q adds  connection between the two sites p ,q if p and q are in different components,then it replaces
 the two component with a new component that is the union of the two
 - find returns the component identifier of the component containing p 
 - connected returns true if p and q both are in the same component false otherwise
 - count returns the number of component
 - The component identifier of a component can change only when the component itself changes during a call to union. it can not change otherwise
 
 | Algorithm | WorstCase time |
 | --- | --- | 
 |Quick Find | MN |
 |Quick Union| MN | 
 |weighted quick union| n + MlogN|
 |QU + path compression | N  + MLogN|
 |Weighted QU + path compression| N+M Lg* N|
 
- m union-find operation on a set of N objects
- lg* mean log to the base 2

### Stacks and Queues
#### Concepts
 - Java generics. Explain why Java prohibits generic array creation.
    * sefew
    
### Sorting
#### Selection Sort
 - The idea of selection sort, is start out with a unsorted array. And in the ith iteration,
   we go through the array to try to find the smallest remaining entry. And then we'll swap that with the first entry 
   in the array and then we know we've got one step done.
   So the basic selection sort method is to, in the ith iteration, find the smallest remaining entry and to the right of i or bigger 
   index than i and then swap that with i.
 - Each time we have to scan through all the remaining entries in order to find the smallest. But then, once we found it, 
   we only have to swap two cards those are both key properties of selection sort.
 - Selections or uses about N^2 / 2 compares and exactly n exchanges.
 - Now, what's interesting about this proposition about selection sort is that, it doesn't matter what order the input is.
   Selection sort is going to use quadratic time because it always has to go through the whole thing to look for the minimum. 
 - And another property is that you can't sort moving less data because selection sort does just a linear number of exchanges. 
   Every item is put in to it's final position with just one exchange. 

#### Insertion Sort
 - Insertion sort is another elementary method that interestingly has quite  different performance characteristics than selection sort.
 - Our pointer still scans from left to right, but now the elements to the left of the pointer, including it, are in order, but the elements to the right
   have not yet been seen at all. So we have to look at the code that's going to maintain that invariant as the pointer increments.
   Move the pointer to the right, it's incremented again. Now the invariant's broken because the element on the pointer is not in sorted order. 
   To put it in sorted order, we have to move from right to left, exchanging it with every larger elements to its left.
 - For insertion sort, what we're going to do is we'll move an index i from left to right  in the i'th iteration, 
   we're going to move a[i] into position among the elements to its left. 
 - we take the idea that everything from i to its left is going to be sorted, and everything from the right we're not going to look at at all.
   So everything to the left of i is in ascending order, everything to the right, we haven't seen it all yet. 
 - we exchange as long as the card immediately to the left is greater. And once we've done that, then we have everything to the left by in ascending order.
 - We don't always have to go all the way back to the beginning.
 - Performance -
   - Our proposition says that insertion sort, to sort randomly ordered array with distinct keys, it'll use about one quarter N squared compares, 
   and about the same number, one quarter N squared exchanges, on the average. 
   - Since N squared over 4 versus N squared over 2, insertion sort's going to be about twice as fast as selection sort.
   - Best case  - If the array happens to be already sorted, all insertion sort does is really validate that each element has got smaller elements 
     to its left. So it does no exchanges. It gets the sorting job done with just N minus 1 compares.  
     it's much, much faster than selection sort, linear instead of quadratic. 
   - Worst case - if the array is in descending order and has no duplicates, then every element goes all the way back. 
     It makes n squared over 2 compares and n squared over 2 exchanges.  
     it's slower than selection sort, because it uses about the same number of compares, but it uses many more exchanges. 
     Same kind of dynamic characteristic as selection sort, except, for every step, it's not just comparing, it's also exchanging, 
     which makes it even slower in practice.
   - Average Case - An inversion is just a pair of keys that are out of order in the array. 
     we define an array to be partially sorted if its number of inversions is linear, if it's less than some constant times N. 
     And what's interesting about insertion sort is that it runs in linear time for partially sorted arrays. 
     And the proof is, the number of comparisons and the number of exchanges is equal to the number of exchanges equal to the number of inversions, 
     and there's an extra compare for every element except the first. 



#### Shell Sort  
- The idea of Shellsort is that Insertion Sort is inefficient because elements really move only one position at the time even when we're kind of know that they have a long way to go. 
  The idea behind Shellsort is that we'll move entries several positions at a time and the way we're going to do it, it's called h-sorting the array.
  So, an h-sorted array is h different inter leaves sorted sub-sequences
- Implement a sorting method that h-sort for decreasing sequences of values of h.
- We just use Insertion Sort but instead of going one back every time we come with a new item, we go h back.
- So the code is the same as insertion, as for Insertion Sort, except that when we go backwards through the array we skip by h instead of just by one. That's how we h-sort an array.
- Now the intuition behind Shellsort and actually the mathematical fact is that if you've got an array that's h-sorted and then you k-sort it for another value k different from h, it's still h-sorted.
- Knuth when he wrote his books in the 60s proposed the increment sequence 3x + 1.
- When we're using in Shellsort of course, we find the largest increment less than our file size and then do the sorts for decreasing values of that increment.
- Performance - we can say that the number of comparison and the worst case is O(N3/2) for the 3x + 1 increments.
  But actually in practice it's much less than that. The problem is nobody knows an accurate model for describing the number of compares taken by Shellsort for any interesting increment sequence.
- why we are interested in this algorithm?
    - It's a simple idea that leads to substantial performance gains. 
    - It's very useful in practice because it's pretty fast except for very huge arrays.
    - It's going to beat even the classical sophisticated methods for medium sized arrays. 
    - And it doesn't take much code.
    - So, It's often used in embedded systems or in hardware sort type systems because there's so little code involved to implement it.
    
#### Merge Sort 
- The idea is very simple. What we're going to do is divide an array into two halves. Recursively, recursively sort each of the halves. And then merge the result. 
- Implementation 1 approach - abstract in-place merge  
    - The method that we're going to use is based on taking an auxiliary array to hold the data. 
    - So the first thing we do is copy everything over to the auxiliary array.
    - Once that's done, what we'll want to do is copy back to the original array to get it in sorted order. 
    - In order to do that, we're going to maintain three indices. I, the current entry in the left half, j, the current entry on the right half and k, the current entry in the sorted result. 
    - so the first thing we do is, take the smaller of the two entries pointed to by i and j, and compare those, and take the smallest one, and move that one to be the next item output. And whichever one is taken, we increment its pointer.
    - Performance
       - it's important to not create the auxiliary array in thee recursive routine because that could lead to extensive cost of extra array creation. 
       - Mergesort uses at most N lg N compares and 6 N lg N array accesses to sort any array of size N.
       - one improvement that we can make is to use insertion sort, and just cut off and use insertion sort which is simple and efficient for small subarrays.
       - The second improvement that we can make that'll improve the performance for cases when the array is partly sorted, is to just stop if it's already sorted. 
       - And that's going to happen in the case where the biggest element in the first half is less or equal to the smallest item in the second half. 
       - The other thing that's possible to do and it's a little mind bending so recommended only for experts. Is to save a little bit of time you don't really have to copy over into the auxiliary array. 
         You can kind of switch the role of the input and the auxiliary array every time you make a recursive call. 
         
- Implementation 2 approach - Bottom Up approach
    - No need of recursion
    - Merge logic same as in previous approach, and role reversal can not be done so copy from dest (final) to src (aux) needs to be done in merge method
    - job done in log N passes. Each pass using about N compares for a total cost of about N log N.       
           
#### Quick sort
- the basic idea behind Quicksort is that it does the recursion after it does the work, whereas Mergesort did it before it did the work.
- Steps for sort
  - first randomly shuffle the array.
  - then partition the array, so that's to divide it so that for sum value j the entry a of j is in place in the array.
  - There's no larger entry to the left of j and no smaller entry to the right of j. 
  - then we recursively sort the two parts. Sort the left part, sort the right part. 
  - after those two things are done, the whole thing is sorted. 
- The idea is to arbitrarily choose the first element to be the partitioning element. Since we shuffled the array, that's our random element from the array. 
- And then we're going to maintain an I pointer that moves from left to right, and a J pointer that moves from right to left.
- our method is to move the I pointer from left to right. As long as what we have is less than the partitioning element. 
- move the j pointer from right to left as long as it points to an item that's greater than the partitioning element.
- The partitioning elements in between them and they're in the wrong order. So what we want to do is exchange those. And then move on. 
- So we can just exchange J with our partitioning element.
- Performace
  - It gets the sort done in place.
  - That random shuffle at the beginning is important and needed for guaranteeing performance. 
  - it's simply just faster than Mergesort. 
  - in the best case Quick Sort will divide everything exactly in half. And that makes it kind of like Merge Sort. It's about analog in. 
  - And in the worst case if the random shuffle winds up putting the items exactly in order, then partitioning doesn't, doesn't really do anything except find the smallest, peel off the smallest item. Kind of discover that everything to the 
    right is greater. That's a bad case. But if we shuffled randomly, it's extremely unlikely to happen. 
  - So the worst case quick sort is quadratic. So complexity's going to tell us that it's a quadratic algorithm if that's what its worst case is. 
  - The average case, which is extremely likely for any practical application, is going to be about 1.39 n log n.
  - So that's more compares than Mergesort uses. But Quicksort is much faster, because it doesn't do much corresponding to each compare. 
  - It just does the compare and increment a pointer. Whereas, Mergesort has to move the items into and out of the auxiliary array, which is more expensive.
  - So the random shuffle is a key for good performance in Quicksort. It gives us the guarantee that the worst case is not gonna happen.
  -  Quicksort is not stable cuz partitioning does one of those long range exchanges that might put a key with equal value over a key another key with the same value.
  - This is our fastest sorting algorithm, and there's a few ways to make it even faster
    - First thing is small sub-arrays.Even Quicksort has more overhead than you want for a tiny array, like one of size 
      two or three or four. So can implement it to cut off to insertion sort for small arrays.
    - Also you could just not do anything for small arrays, and then do the insertion sorting in one pass at the end.
    - A second improvement is to, try to estimate the partitioning element to be near the middle, Which on average will be at the middle. 
    - So one thing that we can do is sample the items, and then take a median of the sample. And that's actually not worth the cost for 
      enlarged samples, not usually. But for three it's worthwhile. Slightly reduces the number of compares. Increases the number of exchanges 
      paradoxically, cuz more exchanges are required when the partition is right in the middle. So that'll also improve the running time kby maybe ten%.
  
  #### Priority Queue
  - binary heap is based on the idea of a complete binary tree. 
  - a binary tree is either empty or it's a node with links to left and right binary trees. 
  - A complete binary tree is one that's perfectly balanced,except possibly for the bottom level
  - a complete binary trees to implement priority queues is to first of all associate information with each node. 
  - We'll put our keys in the nodes. And also we're going to represent it with an array. 
  - So when we start putting the keys in the nodes, we're going to impose one more condition that's called heap ordering. i.e.  parent's key is going to be no smaller than its children's key, and that's true for every node in the tree. 
  - The array representation, all we do is we put, we start with indices at 1. It's a little less calculation. That way, we leave a of zero empty. 
  - And then we just take the nodes in level order. So first we put the root, then we put the two nodes on the first level going left from right, and then all the nodes on the third level going from left to right and so forth. 
  - in the actual data structure representation,we don't need any links at all, it's just an array. 
  - The way that we move around the tree is by doing arithmetic on the indices. 
  - Properties of Heap
    - 1 is the largest key. 
    - It's larger than the keys in this two children and they're larger than theirs and so forth, 
    - use the array indices to move through the tree. 
    - children of the node at k are 2k and 2k plus 1
  - swim operation - a node gets promoted to a level where it finally can't be better than its boss,
    - and if we have a node at index k and we know the heap condition is violated there. As long as we're not at the root and k's parent, k over 2 is less than a of k then we just exchange it with its parent and move up. 
  - Sink Operation - a node gets demoted to a level where it finally  better than its subordinate,
    - for a position K,then what we need to worry about is the nodes at 2k and 2k plus one. The first thing to check is find out which one is bigger, it's either 2k or 2k plus one and so set J accordingly. So that's J now is after this statement, is the larger of the two children. And don't forget to check that we're going off the end of the heap. And then if the K is not less than either one of those, then we're done.
  - we have to check whether the heap condition is violated and exchange it with its parent as long as it's smaller. 
  - Adding item in Priority Queue - add item at the end of array and then make it swim to balance the heap
  - Delete item in Priority Queue - swap 1 with last item in array , make the last item null now and make the 1st item sink in the tree
  - Performance
    - add and delete ,both operations are guaranteed to happen in log N time. 
    - advanced data structure called a Fibonacci heap,where inserts are done in constant time and delete max done in log N time, 
    - Key should be immutable
  
  #### Heap Sort
  -view that array as eventually being a max heap. 
  - We have to do first is to rearrange the keys in the array to heap order it.
  - next phase would be to take that heap ordered array and get, get it to be a sorted result in, in place.
  - So the end result would be like that, with, no keys in the heap, but all the keys in the array in sorted order.
  - Part of the array is the heap. Part of the array is the sorted sub array. And eventually we bring it down to the whole thing being sorted.
  - we have the maximum element in the array right at the root, we want that to be at the end so that's what we're going to do and that's what we're going to do is just 
    put it at the end. We exchange the element at the root with the last element. Pull it off the heap and then balance the heap using sink
  - Now the next largest element in the array is now at the root of the heap. We're going to do the same thing, exchange it with the last element in the heap.
  - Performance
    -You can build a heap from N values in linear time. And then, and then lg N more time.
    -in place sort with guaranteed analogs and compares. 
    - in-place sorting algorithm that's guaranteed N lg n? Your answer's going to be Heapsort.    
    -Heapsort is actually not used that much for a couple of reasons.
     -  First thing is the inner loop is longer than Quicksorts. 
     - Like Mergesort there is more things to do in the inner loop. There is that compare are the two children bigger, then compare. So there are two compares that get done at N lg N times. And then there is some that array index arithmetic.
     - That the references to memory are all over the place when it's a huge array, so it's not a good algorithm for a situation where there's caching which is almost everywhere nowadays.\         
     - It doesn't have a local reference, like Quicksort does. It's always refers to something that's nearby something else that I just referred to. So if a big block of things comes into memory, there's no more extra costs, whereas Heapsort is going to look far away from the current place as it goes down the tree and that makes it slower in a lot of situations. 
     - it's not stable, sometimes people choose to use Mergesort in practice because of the stability but Heapsort isnot stable for the usual reason that it does long distance exchanges that might bring items that have equal keys bback out of order. 
     - 

  
 

  

  

