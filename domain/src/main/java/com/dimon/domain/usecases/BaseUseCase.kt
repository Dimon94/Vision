package com.dimon.domain.usecases

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseUseCase : Disposable, UseCase {
    private val disposable = CompositeDisposable()

    override fun isDisposed() = disposable.isDisposed
    override fun dispose() = disposable.dispose()

    protected fun disposeAndExecute(disposableSubscriber: Disposable) {
        this.disposable.delete(disposableSubscriber)
        this.disposable.add(disposableSubscriber)
    }

    protected fun execute(disposableSubscriber: Disposable) {
        this.disposable.add(disposableSubscriber)
    }
}