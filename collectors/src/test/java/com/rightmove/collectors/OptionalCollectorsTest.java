package com.rightmove.collectors;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.expectThrows;

public class OptionalCollectorsTest {

    @Test
    void returnEmptyCollectionWhenAllOptionalsAreEmpty() {
        Stream<Optional<Integer>> optionalStream = Stream.of(Optional.empty(), Optional.empty(), Optional.empty());

        Vector<Integer> result = optionalStream
                .collect(OptionalCollectors.toCollection(Vector::new));

        assertThat(result).isEmpty();
    }

    @Test
    void shouldConvertOptionalStreamToVector() {
        Stream<Optional<Integer>> optionalStream = Stream.of(Optional.of(1), Optional.empty(), Optional.of(2));

        Vector<Integer> result = optionalStream
                .collect(OptionalCollectors.toCollection(Vector::new));

        assertThat(result).hasSize(2)
                .containsExactly(1, 2);
    }

    @Test
    void shouldReturnEmptyListWhenAllOptionalsAreEmpty() {
        Stream<Optional<Integer>> optionalStream = Stream.of(Optional.empty(), Optional.empty(), Optional.empty());

        List<Integer> result = optionalStream
                .collect(OptionalCollectors.toList());

        assertThat(result).isEmpty();
    }

    @Test
    void shouldConvertOptionalStreamToList() {
        Stream<Optional<Integer>> optionalStream = Stream.of(Optional.of(1), Optional.empty(), Optional.of(2));

        List<Integer> result = optionalStream
                .collect(OptionalCollectors.toList());

        assertThat(result).hasSize(2)
                .containsExactly(1, 2);
    }

    @Test
    void shouldReturnEmptySetWhenAllOptionalsAreEmpty() {
        Stream<Optional<Integer>> optionalStream = Stream.of(Optional.empty(), Optional.empty(), Optional.empty());

        Set<Integer> result = optionalStream
                .collect(OptionalCollectors.toSet());

        assertThat(result).isEmpty();
    }

    @Test
    public void shouldConvertOptionalStreamToSet() {
        Stream<Optional<Integer>> optionalStream = Stream.of(Optional.of(1), Optional.empty(), Optional.of(2));

        Set<Integer> result = optionalStream
                .collect(OptionalCollectors.toSet());

        assertThat(result).hasSize(2);
    }

    @Test
    void shouldEmptyMapWhenAllOptionalsAreEmpty() {
        Stream<Optional<Integer>> optionalStream = Stream.of(Optional.empty(), Optional.empty(), Optional.empty());

        Map<Integer, Integer> result = optionalStream
                .collect(OptionalCollectors.toMap(Function.identity(), Function.identity()));

        assertThat(result).isEmpty();
    }

    @Test
    void shouldConvertOptionalStreamToMap() {
        Stream<Optional<Integer>> optionalStream = Stream.of(Optional.of(1), Optional.empty(), Optional.of(2));

        Map<Integer, Integer> result = optionalStream
                .collect(OptionalCollectors.toMap(v -> v-1, v -> v*3));

        assertThat(result).hasSize(2)
                .containsEntry(0, 3)
                .containsEntry(1, 6);
    }

    @Test
    void shouldThrowExceptionIfKeyAlreadyExists() {
        Stream<Optional<Integer>> optionalStream = Stream.of(Optional.of(1), Optional.of(1));

        expectThrows(IllegalStateException.class, () -> optionalStream.collect(OptionalCollectors.toMap(Function.identity(), Function.identity())));
    }

}