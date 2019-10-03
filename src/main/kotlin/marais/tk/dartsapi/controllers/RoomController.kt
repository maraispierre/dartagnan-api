package marais.tk.dartsapi.controllers

import marais.tk.dartsapi.services.RoomService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class RoomController {

    @Autowired
    lateinit var roomService: RoomService

    @GetMapping("/rooms")
    fun findAll() = roomService.findAll()

    @GetMapping("/room/{idRoom}")
    fun findOne(@PathVariable("idRoom") id: Long) = roomService.findOne(id)

    @DeleteMapping("/room/{idRoom}")
    fun deleteOne(@PathVariable("idRoom") id: Long) = roomService.deleteOne(id)

    @PostMapping("/room")
    fun addRoom(@RequestBody body: Map<String, String>) = body["name"]?.let { roomService.addRoom(it) }

    @PostMapping( "/room/{idRoom}/player")
    fun addUser(@PathVariable("idRoom") id: Long,  @RequestBody body: Map<String, String>) = body["name"]?.let { roomService.addUser(id, it) }

    @DeleteMapping( "/room/{idRoom}/player/{idPlayer}")
    fun deleteUser(@PathVariable("idRoom") idRoom: Long, @PathVariable("idPlayer") idPlayer: Long) = roomService.deleteUser(idRoom = idRoom, idPlayer = idPlayer)
}