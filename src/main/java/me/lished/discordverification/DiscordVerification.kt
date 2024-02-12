package me.lished.discordverification

import me.lished.discordverification.commands.VerifyCommand
import me.lished.discordverification.managers.DiscordBot
import org.bukkit.plugin.java.JavaPlugin


class DiscordVerification : JavaPlugin() {
    override fun onEnable() {
        getCommand("verify")?.setExecutor(VerifyCommand())
        saveConfig()

        DiscordBot.startBot(config.getString("token")!!)

    }
}


