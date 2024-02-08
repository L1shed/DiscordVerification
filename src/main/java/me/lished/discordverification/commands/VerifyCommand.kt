package me.lished.discordverification.commands

import me.lished.discordverification.datas.VerificationData
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
        val code = VerificationManager.generateVerificationCode()
        val expirationDate = Date(System.currentTimeMillis() + 300000)
        val verificationData = VerificationData(player, code, expirationDate)
        VerificationManager.verificationCodes.add(verificationData)

        sender.sendMessage(Component.text("Your verification code is: $code")
            .clickEvent(ClickEvent.copyToClipboard(code))
            .hoverEvent(HoverEvent.showText(Component.text("Click to Copy"))))

        return false
    }
}
