package org.mdeveloperz.mobile.remote.datasource.bases

abstract class DataToRemoteMapper<DATA, REMOTE> {
    abstract fun toRemote(data: DATA): REMOTE
}