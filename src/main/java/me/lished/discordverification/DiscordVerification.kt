package me.lished.discordverification

import me.lished.discordverification.commands.VerifyCommand
import me.lished.discordverification.datas.VerificationData
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class DiscordVerification : JavaPlugin() {
    override fun onEnable() {
        getCommand("verify")?.setExecutor(VerifyCommand())
        saveConfig() // or saveDefaultConfig() i'm brainfucking brainfucked
    }
}
