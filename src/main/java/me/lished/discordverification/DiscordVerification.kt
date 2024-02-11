package me.lished.discordverification

import discord4j.core.DiscordClient
import discord4j.core.GatewayDiscordClient
import discord4j.core.event.ReactiveEventAdapter
import discord4j.core.event.domain.interaction.ChatInputInteractionEvent
import discord4j.core.event.domain.lifecycle.ReadyEvent
import discord4j.core.`object`.command.ApplicationCommandOption
import discord4j.discordjson.json.ApplicationCommandOptionData
import discord4j.discordjson.json.ApplicationCommandRequest
import me.lished.discordverification.commands.VerifyCommand
import org.bukkit.plugin.java.JavaPlugin
import org.reactivestreams.Publisher
import reactor.core.publisher.Mono


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

        client?.on(object : ReactiveEventAdapter() {

            override fun onChatInputInteraction(event: ChatInputInteractionEvent): Publisher<*> {
                if (event.commandName == "random") {
                    return event.reply("caca")
                }
                return Mono.empty<Any>()
            }
        })?.blockLast()
    }
}


