package marais.tk.dartsapi.entities

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
@Table(name ="Players")
data class Player (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val playerId: Long = 0,

        val name: String = "",

        var numberGame: Long = 0,

        var numberWonGame: Long = 0,

        var totalScore: Long = 0,

        var totalRounds: Long = 0,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "roomId")
        @JsonBackReference
        var room: Room? = null
)