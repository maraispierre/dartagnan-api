package marais.tk.dartsapi.entities

import javax.persistence.*

@Entity
@Table(name ="Players")
data class Player (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val player_id: Long = 0,
        val name: String = ""
)