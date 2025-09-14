package com.github.ked4ma.competitive.common.set.multi

import java.util.*

// Provide Set that can have same values in it.
// And values in this set is sorted by comparator.
// So you can get min / max value by first / last (by default).
class MultiSet<T : Comparable<T>>(comparator: Comparator<T> = compareBy { it }) {
    private val map = TreeMap<T, Int>(comparator)
    private var _size = 0
    val size get() = _size

    fun add(element: T) {
        map[element] = map.getOrDefault(element, 0) + 1
        _size++
    }

    fun addAll(elements: Iterable<T>) {
        elements.forEach(::add)
    }

    fun remove(element: T) {
        map[element]?.let {
            if (it == 1) {
                map.remove(element)
            } else {
                map[element] = it - 1
            }
            _size--
        }
    }

    fun count(element: T): Int = map[element] ?: 0

    fun isEmpty(): Boolean = map.isEmpty()

    fun elements(): List<T> = map.flatMap { (key, value) -> List(value) { key } }

    fun first(): T = map.firstKey()
    fun last(): T = map.lastKey()

    fun floor(element: T): T? = map.floorKey(element)
    fun ceiling(element: T): T? = map.ceilingKey(element)

    override fun toString(): String = "MultiSet$map"
}
