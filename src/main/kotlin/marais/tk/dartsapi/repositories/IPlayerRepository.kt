package marais.tk.dartsapi.repositories

import marais.tk.dartsapi.entities.Player
import marais.tk.dartsapi.entities.Room
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface IPlayerRepository : CrudRepository<Player, Long>{
}