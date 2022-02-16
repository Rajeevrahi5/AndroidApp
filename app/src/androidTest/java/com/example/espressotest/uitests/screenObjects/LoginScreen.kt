package com.example.espressotest.uitests.screenObjects

import com.example.espressotest.R
import com.example.espressotest.ui.login.LoginActivity
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText

object LoginScreen : KScreen<LoginScreen>() {
    override val layoutId: Int = R.layout.activity_login
    override val viewClass: Class<*> = LoginActivity::class.java

    private val emailID = KEditText {withId(R.id.username)}
    private val password = KEditText {withId(R.id.password)}
    private val signIn = KEditText {withId(R.id.login)}

    fun isDisplaying(){
        emailID.isDisplayed()
        password.isDisplayed()
        signIn.isDisplayed()
    }

    fun enterEmail(email:String){
        emailID.click()
        emailID.typeText(email)
    }

    fun enterPassword(passWord:String){
        password.click()
        password.typeText(passWord)
    }

    fun clicSignIn(){
        signIn.click()
        Thread.sleep(2000)
    }
}