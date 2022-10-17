package com.msy.enerjisaabonelik.di.models

data class Result (
    var isSuccess: Boolean?,
    var message: Any?,
    var explanation: Any?,
    var errorCode: Any? = null,
    var resultObject: List<ResultObject>? = null,
    var jobID: Any? = null,
    var params: Params? = null,
    var requestContextID: String?,
)