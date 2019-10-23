package marais.tk.dartsapi.repositories

import marais.tk.dartsapi.entities.Player
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IPlayerRepository : JpaRepository<Player, Long> {
}