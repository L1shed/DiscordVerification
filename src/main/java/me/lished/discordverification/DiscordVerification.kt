package me.lished.discordverification

import me.jakejmattson.discordkt.arguments.IntegerArg
import me.jakejmattson.discordkt.commands.commands
import me.jakejmattson.discordkt.dsl.bot
import me.lished.discordverification.commands.VerifyCommand
import me.lished.discordverification.managers.DiscordBotManager
import me.lished.discordverification.managers.VerificationManager
import org.bukkit.plugin.java.JavaPlugin

class DiscordVerification : JavaPlugin() {
    override fun onEnable() {
        getCommand("verify")?.setExecutor(VerifyCommand())
        saveConfig() // or saveDefaultConfig() i'm brainfucking brainfucked

        DiscordBotManager.startBot(config.getString("token"))

//        bot(config.getString("token")) {
//            prefix { "+" }
//        }
    }

//    fun verify() = commands("security") {
//        slash("Verify", "Verify with this command.") {
//            execute(IntegerArg("Code")) {
//                val player = VerificationManager.getPlayerByCode(args.first)
//                player?.sendMessage("You got verified: $author")
//                respond("Verified")
//            }
//        }
//    }
}


