package marais.tk.dartsapi.controllers

import marais.tk.dartsapi.services.RoomService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class RoomController {

    @Autowired
    lateinit var roomService: RoomService

    @GetMapping("/rooms/{userId}")
    fun findAll(@PathVariable("userId") userId: String) = roomService.findAll(userId)

    @GetMapping("/room/{roomId}")
    fun findOne(@PathVariable("roomId") roomId: Long) = roomService.findOne(roomId)

    @DeleteMapping("/room/{roomId}")
    fun deleteOne(@PathVariable("roomId") roomId: Long) = roomService.deleteOne(roomId)

    @PostMapping("/room")
    fun addRoom(@RequestBody body: Map<String, String>) = body["name"]?.let { body["userId"]?.let { it1 -> roomService.addRoom(it, it1) } }

    @PostMapping( "/room/{roomId}/player")
    fun addUser(@PathVariable("roomId") roomId: Long,  @RequestBody body: Map<String, String>) = body["name"]?.let { roomService.addUser(roomId, it) }

    @DeleteMapping( "/room/{roomId}/player/{playerId}")
    fun deleteUser(@PathVariable("roomId") roomId: Long, @PathVariable("playerId") playerId: Long) = roomService.deleteUser(roomId = roomId, playerId = playerId)
}