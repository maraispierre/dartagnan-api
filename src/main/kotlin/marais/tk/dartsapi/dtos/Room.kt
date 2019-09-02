package marais.tk.dartsapi.dtos

import marais.tk.dartsapi.dtos.Player

data class Room (
        val id: Long,
        val name: String,
        val players: List<Player>
)