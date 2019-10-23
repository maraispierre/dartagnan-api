package marais.tk.dartsapi.entities

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*
import javax.persistence.FetchType



@Entity
@Table(name ="Rooms")
data class Room (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val roomId: Long=0,

        var name: String="",

        val userId: String="",

        @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER, mappedBy = "room", orphanRemoval = true)
        @JsonManagedReference
        var players: MutableList<Player> = mutableListOf()
)