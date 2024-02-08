package me.lished.discordverification

import me.jakejmattson.discordkt.commands.commands
import me.jakejmattson.discordkt.dsl.bot
import me.lished.discordverification.commands.VerifyCommand
import org.bukkit.plugin.java.JavaPlugin

class DiscordVerification : JavaPlugin() {
    override fun onEnable() {
        getCommand("verify")?.setExecutor(VerifyCommand())
        saveConfig() // or saveDefaultConfig() i'm brainfucking brainfucked

        val token = ""
        bot(token) {
            prefix { "+" }
        }
    }

    fun demo() = commands("testouille") {
        slash("Verify", "A VVV command.") {
            execute {
                respond("Verify!")
            }
        }
    }
}
