package com.rightmove.collectors;

import java.util.Collection;
import java.util.Map;
import java.util.function.BinaryOperator;

class BinaryOperators {

    static <T, C extends Collection<T>> BinaryOperator<C> mergeCollections() {
        return (left, right) -> {
            left.addAll(right);
            return left;
        };
    }

    static <K, V, M extends Map<K,V>> BinaryOperator<M> mergeMaps(BinaryOperator<V> mergeFunction) {
        return (left, right) -> {
            for(Map.Entry<K,V> entry : right.entrySet()) {
                left.merge(entry.getKey(), entry.getValue(), mergeFunction);
            }
            return left;
        };
    }

    static <T> BinaryOperator<T> throwingMerger() {
        return (key, value) -> { throw new IllegalStateException(String.format("Duplicate key %s", key)); };
    }
}
