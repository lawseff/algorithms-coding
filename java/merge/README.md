## Problem
There are two sorted lists. Merge the second list into the first while maintaining the sort order.

## Solution
Adding the second list elements consistently at the specific position, which can be found by using binary search based algorithm. 

[ListMerger](src/main/java/com/github/lawseff/merge/ListMerger.java)

[ListMergerTest](src/test/java/com/github/lawseff/merge/ListMergerTest.java)

## Complexity
**O(n log n)**