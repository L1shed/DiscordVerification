package me.lished.discordverification.commands

import me.lished.discordverification.managers.VerificationData
import me.lished.discordverification.managers.VerificationManager
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.event.ClickEvent
import net.kyori.adventure.text.event.HoverEvent
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import java.util.*

class VerifyCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        val player = sender as Player

        if (VerificationManager.verificationCodes.containsKey(player)) {
            player.sendMessage("already code")
            return false
        }

        val code = VerificationManager.generateVerificationCode()
        val expirationDate = Date(System.currentTimeMillis() + 120000) // 2 minutes
        val verificationData = VerificationData(code, expirationDate)
        VerificationManager.verificationCodes[player] = verificationData

        player.sendMessage(Component.text("Your verification code is: $code")
            .clickEvent(ClickEvent.copyToClipboard(code))
            .hoverEvent(HoverEvent.showText(Component.text("Click to Copy"))))

        return true
    }
}
