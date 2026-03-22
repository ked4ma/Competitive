package com.github.ked4ma.competitive.common.models.tree.segment.type

typealias X = Long
typealias M = Long
typealias FX = (X, X) -> X
typealias FA = (X, M) -> X
typealias FM = (M, M) -> M
typealias FP = (M, Int) -> M

typealias Op<S> = (S, S) -> S
typealias Mapping<S, F> = (S, F) -> S
typealias Composition<F> = (F, F) -> F
typealias Propagation<F> = (F, Int) -> F
