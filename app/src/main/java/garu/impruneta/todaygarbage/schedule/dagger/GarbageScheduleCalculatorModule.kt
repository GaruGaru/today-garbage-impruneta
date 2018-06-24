package garu.impruneta.todaygarbage.schedule.dagger

import dagger.Module
import dagger.Provides
import garu.impruneta.todaygarbage.schedule.calculator.DefaultGarbageScheduleCalculator
import garu.impruneta.todaygarbage.schedule.calculator.GarbageScheduleCalculator
import javax.inject.Named
import javax.inject.Singleton

@Module
class GarbageScheduleCalculatorModule {

    @Provides
    @Singleton
    fun provideGarbageScheduleCalculator(@Named("debug") debug: Boolean): GarbageScheduleCalculator {
        return DefaultGarbageScheduleCalculator()
        // return if (!debug) {
        //     DefaultGarbageScheduleCalculator()
        // } else {
        //     RandomGarbageScheduleCalculator()
        // }
    }

}