package me.lished.discordverification

import discord4j.core.DiscordClient
import discord4j.core.GatewayDiscordClient
import discord4j.core.event.domain.interaction.ChatInputInteractionEvent
import discord4j.core.`object`.command.ApplicationCommandOption
import discord4j.discordjson.json.ApplicationCommandOptionData
import discord4j.discordjson.json.ApplicationCommandRequest
import me.lished.discordverification.commands.VerifyCommand
import org.bukkit.plugin.java.JavaPlugin
import org.reactivestreams.Publisher
import java.util.function.Function


class DiscordVerification : JavaPlugin() {
    override fun onEnable() {
        getCommand("verify")?.setExecutor(VerifyCommand())
        saveConfig()

        val client: GatewayDiscordClient? = DiscordClient.create(config.getString("token")!!)
            .login()
            .block()

        val verifyCmdRequest: ApplicationCommandRequest = ApplicationCommandRequest.builder()
            .name("verify")
            .description("Verify your Minecraft account")
            .addOption(
                ApplicationCommandOptionData.builder()
                    .name("code")
                    .description("The code you got in the chat")
                    .type(ApplicationCommandOption.Type.INTEGER.value)
                    .required(true)
                    .build()
            ).build()

        client!!.on(ChatInputInteractionEvent::class.java)
            .subscribe { event ->
                if (event.commandName == "verify") {
                    event.reply("d")
                        .subscribe()
                }
            }

    }
}


