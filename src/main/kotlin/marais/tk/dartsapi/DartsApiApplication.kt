package marais.tk.dartsapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DartsApiApplication

fun main(args: Array<String>) {
	runApplication<DartsApiApplication>(*args)
}