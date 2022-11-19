package org.mdeveloperz.common.datasource.bases

abstract class DataToDomainMapper<DATA, DOMAIN> {
    abstract fun toDomain(data: DATA): DOMAIN
}