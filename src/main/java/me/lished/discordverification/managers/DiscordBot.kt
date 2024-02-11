package me.lished.discordverification.managers

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit

class DiscordBot : ListenerAdapter() {
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        Bukkit.broadcast(Component.text("VERIFIEIISISDIFHRFHRJ"))
        val player = VerificationManager.getPlayerByCode(event.getOption("verify")!!.asInt)
        if(player != null) {
            player.sendMessage("you are verified")
        }
    }
}