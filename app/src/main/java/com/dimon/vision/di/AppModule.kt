package com.dimon.vision.di

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.text.format.DateFormat
import com.dimon.vision.VisionApplication
import com.dimon.vision.util.AppRxSchedulers
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.threeten.bp.ZoneId
import org.threeten.bp.format.DateTimeFormatter
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [AppModuleBinds::class])
class AppModule {
    @Provides
    fun provideContext(application: VisionApplication): Context = application.applicationContext

    @Singleton
    @Provides
    fun provideRxSchedulers(): AppRxSchedulers = AppRxSchedulers(
            io = Schedulers.io(),
            computation = Schedulers.computation(),
            main = AndroidSchedulers.mainThread()
    )

    @Named("app")
    @Provides
    @Singleton
    fun provideAppPreferences(application: VisionApplication): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(application)
    }

    @Singleton
    @Provides
    fun provideMediumDateFormatter(application: VisionApplication): DateTimeFormatter {
        val dateF = DateFormat.getMediumDateFormat(application) as SimpleDateFormat
        return DateTimeFormatter.ofPattern(dateF.toPattern())
                .withLocale(Locale.getDefault())
                .withZone(ZoneId.systemDefault())
    }

    @Singleton
    @Provides
    fun provideDateTimeFormatter(application: VisionApplication): DateTimeFormatter {
        val dateF = DateFormat.getMediumDateFormat(application) as SimpleDateFormat
        val timeF = DateFormat.getTimeFormat(application) as SimpleDateFormat
        return DateTimeFormatter.ofPattern("${dateF.toPattern()} ${timeF.toPattern()}")
                .withLocale(Locale.getDefault())
                .withZone(ZoneId.systemDefault())
    }

    @Singleton
    @Provides
    fun provideShortDateFormatter(application: VisionApplication): DateTimeFormatter {
        val dateF = DateFormat.getDateFormat(application) as SimpleDateFormat
        return DateTimeFormatter.ofPattern(dateF.toPattern())
                .withLocale(Locale.getDefault())
                .withZone(ZoneId.systemDefault())
    }
}