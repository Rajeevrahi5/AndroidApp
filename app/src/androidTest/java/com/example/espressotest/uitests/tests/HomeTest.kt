package com.example.espressotest.uitests.tests

import androidx.test.core.app.ActivityScenario
import com.example.espressotest.ui.login.LoginActivity
import com.example.espressotest.uitests.screenObjects.HomeScreen
import com.example.espressotest.uitests.tests.scenarios.LoginWithEmailScenario
import com.example.espressotest.uitests.utilities.BaseTestEspresso
import com.example.espressotest.uitests.utilities.Defaults
import org.junit.Before
import org.junit.Test

class HomeTest: BaseTestEspresso() {
    private lateinit var userName: String
    private lateinit var password: String

    @Before
    fun setup() = run{
        ActivityScenario.launch(LoginActivity::class.java)
        userName = Defaults.userName.value
        password = Defaults.password.value
        step("Perform login with Email") {
            scenario(LoginWithEmailScenario(userName, password))
        }
    }

    @Test
    fun scrollUpAndDownTest() = run{
        step("Scroll to the bottom of the screen"){
            HomeScreen{
                isDisplaying()
                scrollToBottom()
            }
        }

        step("Scroll to the top of the screen"){
            HomeScreen{
                isDisplaying()
                scrollToTop()
            }
        }
    }
}