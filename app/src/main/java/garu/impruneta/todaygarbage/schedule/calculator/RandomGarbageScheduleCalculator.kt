package garu.impruneta.todaygarbage.schedule.calculator


import garu.impruneta.todaygarbage.schedule.data.GarbageSchedule
import garu.impruneta.todaygarbage.schedule.data.GarbageType
import java.util.*

class RandomGarbageScheduleCalculator : GarbageScheduleCalculator {

    private val random = Random()

    override fun provideSchedule(epoch: Long, garbageSchedule: GarbageSchedule): List<GarbageType> {
        val values = GarbageType.values()
        return listOf(values[random.nextInt(values.size)])
    }

}