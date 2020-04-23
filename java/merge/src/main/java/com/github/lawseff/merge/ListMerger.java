package com.github.lawseff.merge;

import java.util.List;

public class ListMerger {

    public <T extends Comparable<T>> void mergeSortedLists(List<T> first, List<T> second) {
        int begin = 0;
        for (T value : second) {
            int index = findIndexToInsert(first, begin, value);
            first.add(index, value);
            begin = index + 1;
        }
    }

    private <T extends Comparable<T>> int findIndexToInsert(List<T> list, int begin, T value) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (isBiggerThanLast(list, value)) {
            return size;
        }
        int l = begin;
        int r = size - 1;
        int m = 0;
        while (l <= r) {
            m = (l + r) / 2;
            int comparisonResult = list.get(m).compareTo(value);
            if (comparisonResult == 0) {
                return m + 1; // adding 1 here because we don't need to overwrite the equal element
            } else if (comparisonResult < 0) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return m;
    }

    private <T extends Comparable<T>> boolean isBiggerThanLast(List<T> list, T value) {
        T last = list.get(list.size() - 1);
        return value.compareTo(last) > 0;
    }

}
