package me.lished.discordverification

import me.jakejmattson.discordkt.arguments.IntegerArg
import me.jakejmattson.discordkt.commands.commands
import me.jakejmattson.discordkt.dsl.bot
import me.lished.discordverification.commands.VerifyCommand
import me.lished.discordverification.managers.VerificationManager
import org.bukkit.plugin.java.JavaPlugin

class DiscordVerification : JavaPlugin() {
    override fun onEnable() {
        getCommand("verify")?.setExecutor(VerifyCommand())
        saveConfig() // or saveDefaultConfig() i'm brainfucking brainfucked

        bot(config.getString("token")) {
            prefix { "+" }
        }
    }

    fun demo() = commands("testouille") {
        slash("Verify", "A Verify command.") {
            execute(IntegerArg("Code")) {
                val code = args.toString()

                respond("Verified")
            }
        }
    }
}


