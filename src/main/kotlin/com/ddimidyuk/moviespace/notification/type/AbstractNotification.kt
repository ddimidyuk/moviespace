package com.ddimidyuk.moviespace.notification.type

abstract class AbstractNotification(
    open val recipientEmail: String
) {
    abstract fun templateName(): String
    abstract fun subject(): String
    abstract fun modelMap(): Map<String, String>
}