/*
 * Copyright (c) 2003, 2010, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package java.lang;

import java.util.Iterator;

/**
 * Implementing this interface allows an object to be the target of
 * the "foreach" statement.
 * 实现这个接口允许对象成为 "foreach" 语句的目标。 
 * @param <T> the type of elements returned by the iterator
 *
 * @since 1.5
 */
public interface Iterable<T> {

    /**
     * Returns an iterator over a set of elements of type T.
     * 返回一个在一组 T 类型的元素上进行迭代的迭代器。 
     * @return an Iterator.
     */
    Iterator<T> iterator();
}
