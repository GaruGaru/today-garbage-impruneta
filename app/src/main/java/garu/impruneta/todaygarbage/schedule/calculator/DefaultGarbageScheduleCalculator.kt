package garu.impruneta.todaygarbage.schedule.calculator


import garu.impruneta.todaygarbage.schedule.data.GarbageSchedule
import garu.impruneta.todaygarbage.schedule.data.GarbageType
import java.util.*

class DefaultGarbageScheduleCalculator : GarbageScheduleCalculator {

    override fun provideSchedule(epoch: Long, garbageSchedule: GarbageSchedule): List<GarbageType> {

        val calendar = Calendar.getInstance().apply { timeInMillis = epoch }

        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)

        val additionalKey = this.additionalKey(calendar)

        val garbageList = if (garbageSchedule.additionalSchedule.containsKey(additionalKey))
            garbageSchedule.additionalSchedule[additionalKey]!!
        else
            garbageSchedule.defaultSchedule[dayOfWeek]!!

        return if (garbageList.isNotEmpty())
            garbageList
        else
            listOf(GarbageType.NONE)

    }

    private fun additionalKey(calendar: Calendar): String {
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)
        return "$dayOfMonth-$month-$year"
    }

}
