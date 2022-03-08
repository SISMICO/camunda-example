package br.com.sismico.camunda

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CamundaExampleApplication

fun main(args: Array<String>) {
	runApplication<CamundaExampleApplication>(*args)
}
