package com.ddimidyuk.moviespace.notification.type

class RegistrationConfirmationNotification(
    override val recipientEmail: String,
    private val name: String,
    private val confirmationLink: String
): AbstractNotification(recipientEmail) {

    override fun templateName() = "registration_confirm.ftlh"

    override fun subject() = "[MovieSpace] Complete your registration"

    override fun modelMap() = mapOf(
        "name" to name,
        "confirmationLink" to confirmationLink
    )

}