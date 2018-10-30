package com.dimon.vision.di

import com.dimon.vision.VisionApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class
])
interface AppComponent : AndroidInjector<VisionApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<VisionApplication>()
}