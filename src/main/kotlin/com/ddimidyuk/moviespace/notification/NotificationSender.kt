package com.ddimidyuk.moviespace.notification

import com.ddimidyuk.moviespace.notification.type.AbstractNotification
import freemarker.template.Configuration
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service
import java.io.StringWriter


@Service
class NotificationSender(
    private val freemarkerConfiguration: Configuration,
    private val emailSender: JavaMailSender
) {
    companion object {
        const val FROM_ADDRESS = "noreply@moviespace.com"
    }

    fun sendNotification(notification: AbstractNotification) {
        val message = emailSender.createMimeMessage()
        val helper = MimeMessageHelper(message, true, "UTF-8")
        helper.run {
            setFrom(FROM_ADDRESS, "MovieSpace")
            setTo(notification.recipientEmail)
            setSubject(notification.subject())
            setText(createEmailContent(notification), true)
        }
        emailSender.send(message)
    }

    private fun createEmailContent(notification: AbstractNotification): String {
        val stringWriter = StringWriter()
        freemarkerConfiguration.getTemplate(notification.templateName())
            .process(notification.modelMap(), stringWriter)
        return stringWriter.buffer.toString()
    }
}