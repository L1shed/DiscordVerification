package me.lished.discordverification.commands

import me.lished.discordverification.managers.VerificationManager
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.event.ClickEvent
import net.kyori.adventure.text.event.HoverEvent
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class VerifyCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        val player = sender as Player
        var code = VerificationManager.generateVerificationCode()
//        val expirationDate = Date(System.currentTimeMillis() + 120 * 1000)

        if (VerificationManager.verificationCode.containsKey(player)) {
            code = VerificationManager.verificationCode[player]!!
        }

        VerificationManager.verificationCode[player] = code
//        VerificationManager.expiration[code] = expirationDate

        player.sendMessage(Component.text("Your verification code is: $code")
            .clickEvent(ClickEvent.copyToClipboard(code.toString()))
            .hoverEvent(HoverEvent.showText(Component.text("Click to Copy"))))

        return true
    }
}
