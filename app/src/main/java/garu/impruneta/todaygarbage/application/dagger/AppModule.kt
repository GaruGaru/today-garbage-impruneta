package garu.impruneta.todaygarbage.application.dagger

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import garu.impruneta.todaygarbage.MainActivity
import garu.impruneta.todaygarbage.application.TodayGarbageApp

@Module
abstract class AppModule {

    @Module
    object AModule {
        @JvmStatic
        @Provides
        fun provideContext(application: TodayGarbageApp): Context {
            return application.applicationContext
        }
    }


    @ContributesAndroidInjector
    abstract fun contributeActivityInjector(): MainActivity

}