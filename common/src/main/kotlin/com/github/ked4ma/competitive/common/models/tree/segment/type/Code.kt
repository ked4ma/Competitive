package com.github.ked4ma.competitive.common.models.tree.segment.type

typealias X = Long
typealias M = Long
typealias FX = (X, X) -> X
typealias FA = (X, M) -> X
typealias FM = (M, M) -> M
typealias FP = (M, Int) -> M

// RMQ: {a, b -> max(a, b)}
// RmQ: {a, b -> min(a, b)}
typealias Op<S> = (S, S) -> S
// RUQ: {x, m -> m}
// RAQ: {x, m -> x + m}
typealias Mapping<S, F> = (S, F) -> S
// RUQ: {m1, m2 -> m2}
// RAQ: {m1, m2 -> m1 + m2}
typealias Composition<F> = (F, F) -> F
// RAQ: {m, i -> m * i}
//      {m, i -> m} (default)
typealias Propagation<F> = (F, Int) -> F
