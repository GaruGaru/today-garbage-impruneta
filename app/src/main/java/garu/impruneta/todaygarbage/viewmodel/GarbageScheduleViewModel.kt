package garu.impruneta.todaygarbage.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import garu.impruneta.todaygarbage.schedule.provider.ScheduleProvider
import garu.impruneta.todaygarbage.schedule.calculator.GarbageScheduleCalculator
import garu.impruneta.todaygarbage.schedule.data.GarbageType
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

class GarbageScheduleViewModel(
        private val scheduleProvider: ScheduleProvider,
        private val scheduleCalculator: GarbageScheduleCalculator
) : ViewModel() {

    private val scheduleLiveData = MutableLiveData<List<GarbageType>>()

    fun getSchedule(): LiveData<List<GarbageType>> = scheduleLiveData

    fun fetch(time: Long = System.currentTimeMillis()) {
        launch {
            val scheduleRaw = scheduleProvider.provide()
            val schedule = scheduleCalculator.provideSchedule(time, scheduleRaw)
            launch(UI) {
                scheduleLiveData.value = schedule
            }
            scheduleProvider.refresh()
        }

    }


}