package garu.impruneta.todaygarbage.viewmodel


import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import garu.impruneta.todaygarbage.schedule.provider.ScheduleProvider
import garu.impruneta.todaygarbage.schedule.calculator.GarbageScheduleCalculator

class GarbageScheduleViewModelFactory(
        private val provider: ScheduleProvider,
        private val calculator: GarbageScheduleCalculator
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GarbageScheduleViewModel(provider, calculator) as T
    }

}
