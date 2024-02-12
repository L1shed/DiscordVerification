package me.lished.discordverification.managers

import discord4j.core.DiscordClient
import discord4j.core.GatewayDiscordClient
import discord4j.core.event.domain.interaction.ChatInputInteractionEvent
import discord4j.core.`object`.command.ApplicationCommandOption
import discord4j.discordjson.json.ApplicationCommandOptionData
import discord4j.discordjson.json.ApplicationCommandRequest

object DiscordBot {
    fun startBot(token: String) {
        val client: GatewayDiscordClient? = DiscordClient.create(token)
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
                    val player = VerificationManager.getPlayerByCode(event.getOption("code").toString().toInt())
                    if (player != null) {
                        event.reply("verified")
                            .withEphemeral(true)
                            .subscribe()
                    } else {
                        event.reply("not")
                            .withEphemeral(true)
                            .subscribe()
                    }
                }
            }
    }
}