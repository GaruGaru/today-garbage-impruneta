package garu.impruneta.todaygarbage

import garu.impruneta.todaygarbage.schedule.data.GarbageType

class GarbageResource {

    companion object {

        private val NONE = GarbageRes(
                textRes = R.string.garbage_none,
                iconRes = R.drawable.ic_garbage_truck,
                colorBackground = R.color.color_none_dark_bg,
                colorPrimaryDarkRes = R.color.color_none_dark,
                colorPrimaryRes = R.color.color_none,
                textColor = R.color.color_none_text
        )

        private val MIXED = GarbageRes(
                textRes = R.string.garbage_mixed,
                iconRes = R.drawable.ic_garbage_mixed,
                colorBackground = R.color.color_mixed_dark_bg,
                colorPrimaryDarkRes = R.color.color_mixed_dark,
                colorPrimaryRes = R.color.color_mixed
        )

        private val PLASTIC = GarbageRes(
                textRes = R.string.garbage_plastic,
                iconRes = R.drawable.ic_garbage_plastic,
                colorBackground = R.color.color_plastic_dark_bg,
                colorPrimaryDarkRes = R.color.color_plastic_dark,
                colorPrimaryRes = R.color.color_plastic
        )

        private val ORGANIC = GarbageRes(
                textRes = R.string.garbage_organic,
                iconRes = R.drawable.ic_garbage_organic,
                colorBackground = R.color.color_organic_dark_bg,
                colorPrimaryDarkRes = R.color.color_organic_dark,
                colorPrimaryRes = R.color.color_organic
        )

        private val PAPER = GarbageRes(
                textRes = R.string.garbage_paper,
                iconRes = R.drawable.ic_garbage_paper,
                colorBackground = R.color.color_paper_dark_bg,
                colorPrimaryDarkRes = R.color.color_paper_dark,
                colorPrimaryRes = R.color.color_paper
        )


        private val resourceMap = mapOf(
                GarbageType.NONE to NONE,
                GarbageType.MIXED to MIXED,
                GarbageType.PLASTIC_GLASS to PLASTIC,
                GarbageType.ORGANIC to ORGANIC,
                GarbageType.PAPER to PAPER
        )

        fun of(garbageType: GarbageType) = resourceMap[garbageType]

    }

}