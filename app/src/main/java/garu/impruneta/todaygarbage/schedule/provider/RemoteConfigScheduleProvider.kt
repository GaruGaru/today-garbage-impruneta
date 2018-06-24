package garu.impruneta.todaygarbage.schedule.provider

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.gson.Gson
import garu.impruneta.todaygarbage.R
import garu.impruneta.todaygarbage.schedule.data.GarbageSchedule
import kotlin.coroutines.experimental.suspendCoroutine

class RemoteConfigScheduleProvider(private val gson: Gson, private val expiration: Long) : ScheduleProvider {

    companion object {
        const val SCHEDULE_KEY = "garbage_schedule"
    }

    override fun provide(): GarbageSchedule {

        val remoteConfig = FirebaseRemoteConfig.getInstance()

        remoteConfig.setDefaults(R.xml.firebase_default_config)

        val jsonSchedule = remoteConfig.getString(SCHEDULE_KEY)

        return gson.fromJson(jsonSchedule, GarbageSchedule::class.java)

    }

    override suspend fun refresh() {
        suspendCoroutine<Boolean> { c ->
            val remoteConfig = FirebaseRemoteConfig.getInstance()
            remoteConfig.fetch(this.expiration).addOnCompleteListener {
                remoteConfig.activateFetched()
                c.resume(it.isComplete)
            }
        }
    }


}
