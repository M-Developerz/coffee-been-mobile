package org.mdeveloperz.mobile.remote.datasource.bases

abstract class RemoteToDataMapper<REMOTE, DATA> {
    abstract fun toData(remote: REMOTE): DATA
}