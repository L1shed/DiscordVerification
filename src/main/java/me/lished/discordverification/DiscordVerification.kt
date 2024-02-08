package me.lished.discordverification

import me.lished.discordverification.commands.VerifyCommand
import org.bukkit.plugin.java.JavaPlugin

class DiscordVerification : JavaPlugin() {
    override fun onEnable() {
        getCommand("verify")?.setExecutor(VerifyCommand())
    }
}
