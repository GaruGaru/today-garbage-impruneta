package garu.impruneta.todaygarbage.application

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import garu.impruneta.todaygarbage.application.dagger.DaggerAppComponent

class TodayGarbageApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }

}