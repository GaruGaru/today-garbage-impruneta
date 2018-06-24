package garu.impruneta.todaygarbage.schedule.calculator

import garu.impruneta.todaygarbage.schedule.data.GarbageSchedule
import garu.impruneta.todaygarbage.schedule.data.GarbageType


interface GarbageScheduleCalculator {
    fun provideSchedule(epoch: Long,  garbageSchedule: GarbageSchedule): List<GarbageType>
}