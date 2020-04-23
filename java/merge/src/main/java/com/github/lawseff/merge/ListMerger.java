package com.github.lawseff.merge;

import java.util.List;

public class ListMerger {

    /**
     * Merges the second list elements into the first list while maintaining the sort order.
     * @param first sorted list
     * @param second sorted list
     * @param <T> any comparable type
     */
    public <T extends Comparable<T>> void mergeSortedLists(List<T> first, List<T> second) {
        int begin = 0;
        for (T value : second) {
            int index = findIndexToInsert(first, begin, value);
            first.add(index, value);
            begin = index + 1; // because the second list is sorted as well
        }
    }

    private <T extends Comparable<T>> int findIndexToInsert(List<T> list, int begin, T value) {
        int l = begin, r = list.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (list.get(m).compareTo(value) > 0) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

}
