package com.example.espressotest.uitests.screenObjects

import android.app.Instrumentation
import android.os.SystemClock
import android.view.MotionEvent
import androidx.test.platform.app.InstrumentationRegistry
import com.example.espressotest.R
import com.example.espressotest.ui.list.ListActivity
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KTextView


object HomeScreen: KScreen<HomeScreen>() {
    override val layoutId: Int = R.layout.activity_list
    override val viewClass: Class<*> = ListActivity::class.java

    private var title = KTextView{withText("EspressoTest")}
    private val user1 = KTextView{withText("User 1")}
    private val user20 = KTextView{withText("User 20")}

    fun isDisplaying(){
        title.isDisplayed()
    }

    fun scrollToBottom(){
        swiper(1000,500,0)
        user20.isDisplayed()
    }

    fun scrollToTop(){
        swiper(500,1000,0)
        user1.isDisplayed()
    }
    fun swiper(start: Int, end: Int, delay: Int) {
        val downTime: Long = SystemClock.uptimeMillis()
        var eventTime: Long = SystemClock.uptimeMillis()
        val inst: Instrumentation = InstrumentationRegistry.getInstrumentation()
        var event = MotionEvent.obtain(downTime, eventTime, MotionEvent.ACTION_DOWN, 500f, start.toFloat(), 0)
        inst.sendPointerSync(event)
        eventTime = SystemClock.uptimeMillis() + delay
        event = MotionEvent.obtain(downTime, eventTime, MotionEvent.ACTION_MOVE, 500f, end.toFloat(), 0)
        inst.sendPointerSync(event)
        event = MotionEvent.obtain(downTime, eventTime, MotionEvent.ACTION_UP, 500f, end.toFloat(), 0)
        inst.sendPointerSync(event)
        SystemClock.sleep(2000) //The wait is important to scroll
    }
}