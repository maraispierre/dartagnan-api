package marais.tk.dartsapi.services

import marais.tk.dartsapi.dtos.Player
import marais.tk.dartsapi.dtos.Room
import org.springframework.stereotype.Component

@Component
class RoomService {

    fun findAll() : List<Room> {
        val roomFamily = Room(1, "Famille", listOf())
        val roomFriends = Room(2, "Amis", listOf())
        val rooms = listOf<Room>(roomFamily, roomFriends)
        return rooms
    }

    fun findOne() = Room(1, "Ma room", listOf(Player("Léa")))

    fun addRoom() = Room(1, "Ma room", listOf())

    fun addUser() = Room(1, "Ma room", listOf())
}