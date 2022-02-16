package com.example.espressotest.uitests.utilities

import androidx.test.espresso.IdlingPolicies
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.runner.RunWith
import java.util.concurrent.TimeUnit

@RunWith(AndroidJUnit4::class)
@LargeTest
open class BaseTestEspresso: TestCase(kaspressoBuilder = Kaspresso.Builder.simple {
    beforeEachTest {
        testLogger.i("Beginning of the Test Case")
        //launch(LoginActivity::class.java)
        IdlingPolicies.setMasterPolicyTimeout(Timeouts.IdlingPolicy.value, TimeUnit.SECONDS)
    }

    afterEachTest {
        testLogger.i("End of the Test Case")
    }
}) {
}
