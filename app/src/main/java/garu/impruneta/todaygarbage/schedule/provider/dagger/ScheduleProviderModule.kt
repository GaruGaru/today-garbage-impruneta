package garu.impruneta.todaygarbage.schedule.provider.dagger

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import garu.impruneta.todaygarbage.schedule.provider.RemoteConfigScheduleProvider
import garu.impruneta.todaygarbage.schedule.provider.ScheduleProvider
import javax.inject.Named
import javax.inject.Singleton

@Module
class ScheduleProviderModule {


    @Named("schedule_expiration")
    @Provides
    @Singleton
    fun provideScheduleExpiration(): Long = 1000 * 60 * 60 * 24


    @Provides
    @Singleton
    fun provideScheduleProvider(
            gson: Gson,
            @Named("schedule_expiration") expiration: Long
    ): ScheduleProvider = RemoteConfigScheduleProvider(gson, expiration)

}
