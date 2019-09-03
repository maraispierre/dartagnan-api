package marais.tk.dartsapi.repositories

import marais.tk.dartsapi.entities.Room
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface IRoomRepository : CrudRepository<Room, Long>{
}