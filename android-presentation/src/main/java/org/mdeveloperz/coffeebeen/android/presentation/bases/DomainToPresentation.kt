package org.mdeveloperz.coffeebeen.android.presentation.bases

abstract class DomainToPresentation<DOMAIN, PRESENTATION> {
    abstract fun toPresentation(domain: DOMAIN): PRESENTATION
}