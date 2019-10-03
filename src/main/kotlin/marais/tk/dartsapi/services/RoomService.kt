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

    fun findOne(id: Long) : Room = roomRepository.findById(id).get()

    fun deleteOne(id: Long) : Room {
        val room = roomRepository.findById(id).get()
        roomRepository.deleteById(id)
        return room
    }

    fun addRoom(name: String, userId: String) : Room = roomRepository.save(Room(name = name, userId = userId))

    fun addUser(id: Long, name: String) : Room {
        val room = roomRepository.findById(id).get()
        val player = Player(name = name, room = room)
        playerRepository.save(player)
        room.players.add(player)
        return room
    }

    fun deleteUser(idRoom: Long, idPlayer: Long) : Room {
        val room = roomRepository.findById(idRoom).get()
        playerRepository.deleteById(idPlayer)
        room.players.removeIf { t -> t.player_id == idPlayer }
        roomRepository.save(room)
        return room
    }
}