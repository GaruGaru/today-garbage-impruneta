package garu.impruneta.todaygarbage.schedule.provider

import garu.impruneta.todaygarbage.schedule.data.GarbageSchedule


interface ScheduleProvider {

    suspend fun refresh()

    fun provide(): GarbageSchedule

}