package marais.tk.dartsapi.repositories

import marais.tk.dartsapi.entities.Room
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IRoomRepository : JpaRepository<Room, Long> {

    fun findByUserId(userId: String) : List<Room>
}