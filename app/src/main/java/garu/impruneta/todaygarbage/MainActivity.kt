package garu.impruneta.todaygarbage

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import dagger.android.AndroidInjection
import garu.impruneta.todaygarbage.viewmodel.GarbageScheduleViewModel
import garu.impruneta.todaygarbage.viewmodel.GarbageScheduleViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: GarbageScheduleViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel().getSchedule().observe(this, Observer {
            images_container.removeAllViews()
            garbage_text.text = ""



            it!!.map { GarbageResource.of(it)!! }.forEach {
                addGarbageIcon(it)
                garbage_text.append(getString(it.textRes) + "\n")

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    updateUITheme(it)
                }
            }
        })


        viewModel().fetch()

    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun updateUITheme(res: GarbageRes) {

        garbage_text.setTextColor(ContextCompat.getColor(this@MainActivity, res.textColor))

        window?.apply {
            //navigationBarColor = ContextCompat.getColor(this@MainActivity, R.color.colorPrimary)
            statusBarColor = ContextCompat.getColor(this@MainActivity, res.colorPrimaryDarkRes)
        }

        supportActionBar?.apply {
            setBackgroundDrawable(getColorDrawable(res.colorPrimaryRes))
        }

        background_container.setBackgroundColor(ContextCompat.getColor(this@MainActivity, res.colorBackground))

    }


    fun refresh(view: View) {
        viewModel().fetch()
    }

    private fun viewModel() = ViewModelProviders
            .of(this, viewModelFactory)
            .get(GarbageScheduleViewModel::class.java)

    private fun addGarbageIcon(garbageRes: GarbageRes) {

        val imageView = ImageView(this).apply { setImageResource(garbageRes.iconRes) }

        val layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ).apply { weight = 1f }

        images_container.addView(imageView, layoutParams)
    }

    private fun getColorDrawable(id: Int): ColorDrawable = ColorDrawable(ContextCompat.getColor(this, id))


}
