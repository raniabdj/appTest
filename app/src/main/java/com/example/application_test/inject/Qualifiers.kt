package com.example.application_test.inject

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ForAppVersion

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ForDebugMode