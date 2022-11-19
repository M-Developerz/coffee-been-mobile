package org.mdeveloperz.common.datasource.bases

abstract class DomainToDataMapper<DOMAIN, DATA> {
    abstract fun toData(domain: DOMAIN): DATA
}