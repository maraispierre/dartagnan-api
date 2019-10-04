package marais.tk.dartsapi.controllers

import marais.tk.dartsapi.dtos.PlayerDto
import marais.tk.dartsapi.dtos.RoomDto
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
    fun addRoom(@RequestBody roomDto: RoomDto) = roomService.addRoom(roomDto.name, roomDto.userId)

    @PostMapping( "/room/{roomId}/player")
    fun addUser(@PathVariable("roomId") roomId: Long,  @RequestBody playerDto: PlayerDto) =  roomService.addUser(roomId, playerDto.name)

    @DeleteMapping( "/room/{roomId}/player/{playerId}")
    fun deleteUser(@PathVariable("roomId") roomId: Long, @PathVariable("playerId") playerId: Long) = roomService.deleteUser(roomId = roomId, playerId = playerId)
}