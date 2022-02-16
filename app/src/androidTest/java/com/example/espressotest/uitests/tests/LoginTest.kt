package com.example.espressotest.uitests.tests

import androidx.test.core.app.ActivityScenario
import com.example.espressotest.ui.login.LoginActivity
import com.example.espressotest.uitests.screenObjects.HomeScreen
import com.example.espressotest.uitests.screenObjects.LoginScreen
import com.example.espressotest.uitests.utilities.BaseTestEspresso
import com.example.espressotest.uitests.utilities.Defaults
import org.junit.Before
import org.junit.Test

class LoginTest: BaseTestEspresso() {
    private lateinit var userName: String
    private lateinit var password: String

    @Before
    fun setup(){
        ActivityScenario.launch(LoginActivity::class.java)
        userName = Defaults.userName.value
        password = Defaults.password.value
    }

    @Test
    fun loginOnEspressoTest() = run{
        step("Enter Email ID on Login screen"){
            LoginScreen{
                isDisplaying()
                enterEmail(userName)
            }
        }

        step("Enter Password on Login screen"){
            LoginScreen{
                isDisplaying()
                enterPassword(password)
            }
        }

        step("Click SignIn Button on Login screen"){
            LoginScreen{
                isDisplaying()
                clicSignIn()
            }
        }

        step("Check login is successful"){
            HomeScreen{
                isDisplaying()
            }
        }
    }
}