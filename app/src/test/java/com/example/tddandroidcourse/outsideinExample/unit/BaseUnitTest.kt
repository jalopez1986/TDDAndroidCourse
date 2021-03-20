package com.example.tddandroidcourse.outsideinExample.unit

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.tddandroidcourse.utils.MainCoroutineScopeRule
import org.junit.Rule

open class BaseUnitTest {
    @get:Rule
    var coroutinesRule = MainCoroutineScopeRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
}