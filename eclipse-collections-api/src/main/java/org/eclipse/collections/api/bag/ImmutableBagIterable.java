/*******************************************************************************
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *******************************************************************************/

package org.eclipse.collections.api.bag;

import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.predicate.Predicate;
import org.eclipse.collections.api.block.predicate.Predicate2;
import org.eclipse.collections.api.block.predicate.primitive.IntPredicate;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.collection.ImmutableCollection;
import org.eclipse.collections.api.map.MutableMapIterable;
import org.eclipse.collections.api.multimap.bag.ImmutableBagIterableMultimap;
import org.eclipse.collections.api.partition.bag.PartitionImmutableBagIterable;
import org.eclipse.collections.api.set.ImmutableSetIterable;
import org.eclipse.collections.api.tuple.Pair;

public interface ImmutableBagIterable<T> extends Bag<T>, ImmutableCollection<T>
{
    ImmutableBagIterable<T> tap(Procedure<? super T> procedure);

    ImmutableBagIterable<T> select(Predicate<? super T> predicate);

    <P> ImmutableBagIterable<T> selectWith(Predicate2<? super T, ? super P> predicate, P parameter);

    ImmutableBagIterable<T> reject(Predicate<? super T> predicate);

    <P> ImmutableBagIterable<T> rejectWith(Predicate2<? super T, ? super P> predicate, P parameter);

    PartitionImmutableBagIterable<T> partition(Predicate<? super T> predicate);

    <P> PartitionImmutableBagIterable<T> partitionWith(Predicate2<? super T, ? super P> predicate, P parameter);

    <S> ImmutableBagIterable<S> selectInstancesOf(Class<S> clazz);

    <V> ImmutableBagIterableMultimap<V, T> groupBy(Function<? super T, ? extends V> function);

    <V> ImmutableBagIterableMultimap<V, T> groupByEach(Function<? super T, ? extends Iterable<V>> function);

    ImmutableSetIterable<Pair<T, Integer>> zipWithIndex();

    ImmutableBagIterable<T> selectByOccurrences(IntPredicate predicate);

    MutableMapIterable<T, Integer> toMapOfItemToCount();
}