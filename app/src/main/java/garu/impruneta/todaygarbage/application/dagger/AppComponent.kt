package garu.impruneta.todaygarbage.application.dagger

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import garu.impruneta.todaygarbage.application.TodayGarbageApp
import garu.impruneta.todaygarbage.schedule.dagger.GarbageScheduleCalculatorModule
import garu.impruneta.todaygarbage.schedule.provider.dagger.ScheduleProviderModule
import garu.impruneta.todaygarbage.viewmodel.dagger.GarbageScheduleViewModelModule
import javax.inject.Singleton

/**
 * Created by garu on 13/01/18.
 */

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    BaseModule::class,
    ScheduleProviderModule::class,
    GarbageScheduleCalculatorModule::class,
    GarbageScheduleViewModelModule::class
])
interface AppComponent : AndroidInjector<TodayGarbageApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: TodayGarbageApp): Builder

        fun build(): AppComponent
    }

}