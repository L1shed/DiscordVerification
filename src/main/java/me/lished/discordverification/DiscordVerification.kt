package me.lished.discordverification

import me.lished.discordverification.commands.VerifyCommand
import net.dv8tion.jda.api.JDABuilder
import org.bukkit.plugin.java.JavaPlugin

class DiscordVerification : JavaPlugin() {
    override fun onEnable() {
        getCommand("verify")?.setExecutor(VerifyCommand())
        saveConfig()

        val jda = JDABuilder.createDefault(config.getString("token")).build()
    }
}


