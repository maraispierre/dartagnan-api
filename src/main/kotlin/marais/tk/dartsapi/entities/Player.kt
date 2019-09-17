package marais.tk.dartsapi.entities

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
@Table(name ="Players")
data class Player (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val player_id: Long = 0,

        val name: String = "",

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "room_id")
        @JsonBackReference
        val room: Room? = null
)