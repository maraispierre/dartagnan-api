package marais.tk.dartsapi.services

import marais.tk.dartsapi.entities.Player
import marais.tk.dartsapi.entities.Room
import marais.tk.dartsapi.repositories.IRoomRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Component
class RoomService {

    @Autowired
    lateinit var roomRepository: IRoomRepository

    fun findAll() : MutableIterable<Room> = roomRepository.findAll()

    fun findOne(id: Long) = roomRepository.findById(id)

    fun addRoom(room: Room) = roomRepository.save(room)

    fun addUser() = Room(1, "Ma room")
}