package marais.tk.dartsapi.entities

import javax.persistence.*

@Entity
@Table(name ="Rooms")
data class Room (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val room_id: Long=0,
        val name: String=""
)