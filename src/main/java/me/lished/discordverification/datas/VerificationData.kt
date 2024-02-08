package me.lished.discordverification.datas

import org.bukkit.entity.Player
import java.util.Date

data class VerificationData(val player: Player, val code: String, val expiration: Date)

