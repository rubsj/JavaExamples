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
           


