package garu.impruneta.todaygarbage.viewmodel.dagger

import dagger.Module
import dagger.Provides
import garu.impruneta.todaygarbage.schedule.calculator.GarbageScheduleCalculator
import garu.impruneta.todaygarbage.schedule.provider.ScheduleProvider
import garu.impruneta.todaygarbage.viewmodel.GarbageScheduleViewModelFactory
import javax.inject.Singleton

@Module
class GarbageScheduleViewModelModule {

    @Singleton
    @Provides
    fun provideGarbageViewModelFactory(provider: ScheduleProvider, calculator: GarbageScheduleCalculator): GarbageScheduleViewModelFactory {
        return GarbageScheduleViewModelFactory(
                provider = provider,
                calculator = calculator
        )
    }

}