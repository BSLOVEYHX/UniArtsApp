package com.zysc.uniartsapp.network.exception


class ResultException(var errCode: String?, var msg: String?) : Exception(msg)
