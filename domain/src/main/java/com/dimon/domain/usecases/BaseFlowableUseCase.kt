package com.dimon.domain.usecases

import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber

abstract class BaseFlowableUseCase : BaseUseCase() {
    abstract override fun buildFlowable(): Flowable<*>

    fun disposeAndExecuteObservable(observer: DisposableSubscriber<Any>) {
        disposeAndExecute(buildFlowable()
            .doOnSubscribe { observer.onSubscribe(it) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { observer.onNext(it) },
                { observer.onError(it) },
                { observer.onComplete() }
            )
        )
    }

    fun executeObservable(observer: DisposableSubscriber<Any>) {
        execute(buildFlowable()
            .doOnSubscribe { observer.onSubscribe(it) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { observer.onNext(it) },
                { observer.onError(it) },
                { observer.onComplete() }
            )
        )
    }
}