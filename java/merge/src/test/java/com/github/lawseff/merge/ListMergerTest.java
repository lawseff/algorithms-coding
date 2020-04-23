package com.github.lawseff.merge;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(DataProviderRunner.class)
public class ListMergerTest {

    @DataProvider
    public static Object[][] dataProviderMergeSortedLists() {
        return new Object[][] {
                {
                    mutableList(-3, 1, 2, 3, 5),
                    Collections.singletonList(4),
                    List.of(-3, 1, 2, 3, 4, 5)
                },
                {
                    mutableList(1, 5),
                    List.of(-256, 256),
                    List.of(-256, 1, 5, 256)
                },
                {
                    mutableList(1, 2, 3, 4, 5),
                    List.of(1, 2, 3, 4, 5),
                    List.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5)
                },
                {
                    Collections.emptyList(),
                    Collections.emptyList(),
                    Collections.emptyList()
                },
                {
                    mutableList(1, 3, 5),
                    List.of(2, 6, 8),
                    List.of(1, 2, 3, 5, 6, 8)
                },
                {
                    mutableList(1, 3, 5, 11, 22, 41),
                    List.of(2, 6, 8, 8, 11, 12),
                    List.of(1, 2, 3, 5, 6, 8, 8, 11, 11, 12, 22, 41),
                }
        };
    }

    @Test
    @UseDataProvider("dataProviderMergeSortedLists")
    public void mergeSortedLists(List<Integer> first, List<Integer> second, List<Integer> expected) {
        // given
        ListMerger merger = new ListMerger();

        // when
        merger.mergeSortedLists(first, second);

        // then
        Assert.assertEquals(expected, first);
    }

    private static List<Integer> mutableList(int... values) {
        return Arrays.stream(values)
                .boxed()
                .collect(Collectors.toList());
    }

}
