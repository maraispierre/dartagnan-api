package marais.tk.dartsapi.controllers

import marais.tk.dartsapi.entities.Room
import marais.tk.dartsapi.services.RoomService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class RoomController {

    @Autowired
    lateinit var roomService: RoomService

    @GetMapping("/rooms")
    fun findAll() = roomService.findAll()

    @GetMapping("/room")
    fun findOne(@RequestParam() id: Long) = roomService.findOne(id)

    @PostMapping("/room")
    fun addRoom(@RequestParam() room: Room) = roomService.addRoom(room)

    @PutMapping( "/room")
    fun addUser() = roomService.addUser()
}