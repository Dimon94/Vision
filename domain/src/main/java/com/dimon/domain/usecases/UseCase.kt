package com.dimon.domain.usecases

import io.reactivex.*

interface UseCase {
    fun buildObservable(): Observable<*>? = null
    fun buildSinge(): Single<*>? = null
    fun buildFlowable(): Flowable<*>? = null
    fun buildMaybe(): Maybe<*>? = null
    fun buildCompletable(): Completable? = null
}