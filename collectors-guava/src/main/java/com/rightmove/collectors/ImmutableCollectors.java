package com.rightmove.collectors;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class ImmutableCollectors {


    public static <T, C extends Collection<T>, I extends ImmutableCollection<T>> Collector<T, C, I> toCollection(final Supplier<C> stagingCollectionFactory,
                                                                                                                 final Function<C, I> finisher) {
        return Collector.of(stagingCollectionFactory,
                Collection::add,
                BinaryOperators.mergeCollections(),
                finisher);
    }

    public static <T> Collector<T, ?, ImmutableList<T>> toList() {
        return toCollection(ArrayList::new, ImmutableList::copyOf);
    }

    public static <T> Collector<T, ?, ImmutableSet<T>> toSet() {
        return toCollection(HashSet::new, ImmutableSet::copyOf);
    }

}
