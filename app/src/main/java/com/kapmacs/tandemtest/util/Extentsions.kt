package com.kapmacs.tandemtest.util

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

fun scopeIO(exHandler: CoroutineExceptionHandler? = null) = CoroutineScope(
    SupervisorJob() + Dispatchers.IO + (
        exHandler ?: CoroutineExceptionHandler { _, throwable ->
            throwable.printStackTrace()
        }
        )
)
