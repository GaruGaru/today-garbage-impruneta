package garu.impruneta.todaygarbage.schedule.data

import com.google.gson.annotations.SerializedName

data class GarbageSchedule(
        @SerializedName("defaults") val defaultSchedule: Map<Int, List<GarbageType>>,
        @SerializedName("additional")  val additionalSchedule: Map<String, List<GarbageType>>
)

