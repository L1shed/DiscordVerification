package me.lished.discordverification.managers

import me.lished.discordverification.datas.VerificationData

object VerificationManager {

    val verificationCodes: MutableList<VerificationData> = mutableListOf()

    fun generateVerificationCode(): String {
        return (100000..999999).random().toString()
    }
}
