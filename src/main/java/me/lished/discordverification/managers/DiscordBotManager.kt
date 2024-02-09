package me.lished.discordverification.managers

import me.jakejmattson.discordkt.arguments.IntegerArg
import me.jakejmattson.discordkt.commands.commands
import me.jakejmattson.discordkt.dsl.bot

object DiscordBotManager {
    fun startBot(token: String?) {
        bot(token) {
            prefix { "+" }
        }
    }

    fun verify() = commands("security") {
        slash("Verify", "Verify with this command.") {
            execute(IntegerArg("Code")) {
                val player = VerificationManager.getPlayerByCode(args.first)
                player?.sendMessage("You got verified: $author")
                respond("Verified")
            }
        }
    }
}