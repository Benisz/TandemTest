package com.kapmacs.tandemtest.model.repo

import com.kapmacs.tandemtest.util.scopeIO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel

open class BaseRepository : CoroutineScope by scopeIO() {
    fun clearJobs() {
        this.cancel()
    }
}
