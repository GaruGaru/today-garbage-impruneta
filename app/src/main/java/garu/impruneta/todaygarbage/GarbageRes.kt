package garu.impruneta.todaygarbage

data class GarbageRes(
        val textRes: Int,
        val iconRes: Int,
        val colorPrimaryRes: Int,
        val colorPrimaryDarkRes: Int,
        val colorBackground: Int,
        val textColor: Int = R.color.base_white
)