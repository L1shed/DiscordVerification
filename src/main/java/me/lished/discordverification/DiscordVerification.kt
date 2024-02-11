package me.lished.discordverification

import me.lished.discordverification.commands.VerifyCommand
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.hooks.ListenerAdapter
import org.bukkit.plugin.java.JavaPlugin

class DiscordVerification : JavaPlugin() {
    override fun onEnable() {
        getCommand("verify")?.setExecutor(VerifyCommand())
        saveConfig()

        val jda = JDABuilder.createDefault(config.getString("token"))
            .addEventListeners(VerifyCommannd())
            .build()
    }
}

class VerifyCommannd : ListenerAdapter() {
    override fun onSlashCommand(event: SlashCommandEvent) {
        if (event.name == "verify") {
            val arg = event.getOption("number")?.asString
            if (arg != null) {
                try {
                    val number = arg.toInt()
                    // Perform verification with the provided number
                    event.reply("Verification successful for number: $number").queue()
                } catch (e: NumberFormatException) {
                    event.reply("Invalid number format.").queue()
                }
            } else {
                event.reply("Please provide a number.").queue()
            }
        }
    }
}


