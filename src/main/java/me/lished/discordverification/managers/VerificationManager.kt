package me.lished.discordverification.managers
import discord4j.core.event.domain.interaction.ChatInputInteractionEvent
import discord4j.core.`object`.entity.Message
import org.bukkit.entity.Player
import reactor.core.publisher.Mono
import java.util.*


//data class VerificationData(val code: String, val expiration: Date)

object VerificationManager {

    val verificationCode: MutableMap<Player, Int> = HashMap()
//    val expiration: MutableMap<String, Date> = HashMap()

    fun generateVerificationCode(): Int {
        return (100000..999999).random()
    }

    fun getPlayerByCode(code: Int): Player? {
        for ((player, playerCode) in verificationCode) {
            if (playerCode == code) {
                return player
            }
        }
        return null
    }

    fun checkCode(code: Int, event: ChatInputInteractionEvent): Mono<Message> {
        getPlayerByCode(code)
        return event.createFollowup("This took awhile!")
    }

}
