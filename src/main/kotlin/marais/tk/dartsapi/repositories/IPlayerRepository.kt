package marais.tk.dartsapi.repositories

import marais.tk.dartsapi.entities.Player
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface IPlayerRepository : CrudRepository<Player, Long>{
}