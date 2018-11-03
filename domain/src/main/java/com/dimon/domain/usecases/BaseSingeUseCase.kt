package com.dimon.domain.usecases

import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

abstract class BaseSingeUseCase : BaseUseCase() {
    abstract override fun buildSinge(): Single<*>

    fun disposeAndExecuteObservable(observer: SingleObserver<Any>) {
        disposeAndExecute(buildSinge()
                .doOnSubscribe { observer.onSubscribe(it) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { observer.onSuccess(it) },
                        { observer.onError(it) }
                )
        )
    }

    fun executeObservable(observer: SingleObserver<Any>) {
        execute(buildSinge()
                .doOnSubscribe { observer.onSubscribe(it) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { observer.onSuccess(it) },
                        { observer.onError(it) }
                ))
    }
}