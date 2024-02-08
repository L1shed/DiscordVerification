package me.lished.discordverification.managers

import me.lished.discordverification.datas.VerificationData
import org.bukkit.entity.Player

object VerificationManager {

    val verificationCodes: MutableMap<Player, VerificationData> = HashMap()

    fun generateVerificationCode(): String {
        return (100000..999999).random().toString()
    }
}
