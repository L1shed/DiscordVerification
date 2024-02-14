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
//                    event.deferReply().then(VerificationManager.checkCode(event))
                    val player = VerificationManager.getPlayerByCode(event.getOption("code").flatMap { it.value }
                        .map { it.asLong().toInt() }
                        .orElse(1))
                    if (player != null) event.reply("verified").withEphemeral(true).subscribe()
                    event.reply("pulledn").withEphemeral(true).subscribe()
                }
            }
    }
}