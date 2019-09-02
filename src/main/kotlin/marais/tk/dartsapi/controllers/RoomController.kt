package marais.tk.dartsapi.controllers

import marais.tk.dartsapi.services.RoomService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RoomController {

    @Autowired
    lateinit var roomService: RoomService

    @GetMapping("/rooms")
    fun findAll() = roomService.findAll()

    @GetMapping("/room")
    fun findOne() = roomService.findOne()

    @PostMapping("/room")
    fun addRoom() = roomService.addRoom()

    @PutMapping( "/room")
    fun addUser() = roomService.addUser()
}