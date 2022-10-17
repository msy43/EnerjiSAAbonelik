package com.msy.enerjisaabonelik.di.models


data class Menu(
    var isMaintenance: Boolean?,
    var statusCode: Int?,
    var errorMessage: Any?,
    var errorCode: Any?,
    var validationErrorMessages: Any?,
    var result: Result?,
    var sid: String?,
    var requestId: String?,
    var logUrl: String?,
)