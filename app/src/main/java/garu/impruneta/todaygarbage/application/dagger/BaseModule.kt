package garu.impruneta.todaygarbage.application.dagger

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import garu.impruneta.todaygarbage.BuildConfig
import javax.inject.Named
import javax.inject.Singleton

@Module
class BaseModule {

    @Singleton
    @Provides
    fun provideGson(): Gson = Gson()

    @Singleton
    @Provides
    @Named("debug")
    fun provideIsDebug() = BuildConfig.DEBUG

}
