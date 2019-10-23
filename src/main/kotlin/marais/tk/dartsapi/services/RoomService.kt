package marais.tk.dartsapi.services

import marais.tk.dartsapi.entities.Player
import marais.tk.dartsapi.entities.Room
import marais.tk.dartsapi.repositories.IPlayerRepository
import marais.tk.dartsapi.repositories.IRoomRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class RoomService {

    @Autowired
    lateinit var roomRepository: IRoomRepository

    @Autowired
    lateinit var playerRepository: IPlayerRepository

    fun findAll(userId: String) : List<Room> = roomRepository.findByUserId(userId)

    fun findOne(roomId: Long) : Room = roomRepository.findById(roomId).get()

    fun update(room: Room) : Room {
        for(player in room.players) {
            player.room = room
            playerRepository.save(player)
        }
        return roomRepository.save(room)
    }

    fun deleteOne(roomId: Long) : Room {
        val room = roomRepository.findById(roomId).get()
        roomRepository.deleteById(roomId)
        return room
    }

    fun addRoom(name: String, userId: String) : Room = roomRepository.save(Room(name = name, userId = userId))

    fun addUser(roomId: Long, name: String) : Room {
        val room = roomRepository.findById(roomId).get()
        val player = Player(name = name, room = room)
        playerRepository.save(player)
        room.players.add(player)
        return room
    }

    fun deleteUser(roomId: Long, playerId: Long) : Room {
        val room = roomRepository.findById(roomId).get()
        playerRepository.deleteById(playerId)
        room.players.removeIf { t -> t.playerId == playerId }
        roomRepository.save(room)
        return room
    }
}