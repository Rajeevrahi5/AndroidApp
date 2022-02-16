package com.example.espressotest.uitests.tests.scenarios

import com.example.espressotest.uitests.screenObjects.HomeScreen
import com.example.espressotest.uitests.screenObjects.LoginScreen
import com.kaspersky.kaspresso.testcases.api.scenario.BaseScenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext

class LoginWithEmailScenario<ScenarioData>(emailID: String, password: String): BaseScenario<ScenarioData>() {
    override val steps: TestContext<ScenarioData>.() -> Unit = {

        step("Enter email and password and press login button") {
            LoginScreen {
                isDisplaying()
                enterEmail(emailID)
                enterPassword(password)
                clicSignIn()
                Thread.sleep(2000)
            }
        }

        step("Check login is successful"){
            HomeScreen{
                isDisplaying()
            }
        }
    }
}