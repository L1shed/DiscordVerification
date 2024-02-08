package me.lished.discordverification.managers
import org.bukkit.entity.Player
import java.util.*
import kotlin.collections.HashMap

data class VerificationData(val code: String, val expiration: Date)

object VerificationManager {

    val verificationCodes: MutableMap<Player, VerificationData> = HashMap()

    fun generateVerificationCode(): String {
        return (100000..999999).random().toString()
    }
}
