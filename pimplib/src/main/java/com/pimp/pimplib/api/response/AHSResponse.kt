package com.pimp.pimplib.api.response

import java.util.*

data class Realm(
        val url: String,
        val lastModified: Date
)

data class Result(
        val files: Array<Realm>
)