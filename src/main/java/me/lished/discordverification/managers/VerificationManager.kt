package me.lished.discordverification.managers
import org.bukkit.entity.Player
import java.util.*
import kotlin.collections.HashMap

//data class VerificationData(val code: String, val expiration: Date)

object VerificationManager {

    val verificationCode: MutableMap<Player, Int> = HashMap()
//    val expiration: MutableMap<String, Date> = HashMap()

    fun generateVerificationCode(): Int {
        return (100000..999999).random()
    }
}
