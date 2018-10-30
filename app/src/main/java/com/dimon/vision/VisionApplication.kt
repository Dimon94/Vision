package com.dimon.vision

import com.dimon.vision.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class VisionApplication :DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }
}