package me.lished.discordverification

import me.lished.discordverification.commands.VerifyCommand
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.interactions.commands.OptionType
import net.dv8tion.jda.api.interactions.commands.build.Commands
import org.bukkit.plugin.java.JavaPlugin

class DiscordVerification : JavaPlugin() {
    override fun onEnable() {
        getCommand("verify")?.setExecutor(VerifyCommand())
        saveConfig()

        val jda = JDABuilder.createDefault(config.getString("token"))
            .build()

        jda.updateCommands().addCommands(
            Commands.slash("verify", "Verify to be secure")
                .setGuildOnly(true)
                .addOption(OptionType.INTEGER, "code", "The code you got in Minecraft", true)
        ).queue();
    }
}


