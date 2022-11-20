package org.mdeveloperz.coffeebeen.android.presentation.bases

abstract class PresentationToDomainMapper<PRESENTATION, DOMAIN> {
    abstract fun toDomain(presentation: PRESENTATION): DOMAIN
}