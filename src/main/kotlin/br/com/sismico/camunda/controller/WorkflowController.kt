package br.com.sismico.camunda.controller

import org.camunda.bpm.dmn.engine.DmnDecisionTableResult
import org.camunda.bpm.engine.DecisionService
import org.camunda.bpm.engine.ProcessEngine
import org.camunda.bpm.engine.variable.Variables
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
class WorkflowController(
    val processEngine: ProcessEngine
) {
    @GetMapping("/")
    fun helloWorld() = "Hello World"

    @GetMapping("/{param}")
    fun dmn(@PathVariable param: Int): String? {
        val decisionService: DecisionService = processEngine.decisionService

        val variables = Variables.createVariables()
            .putValue("values", param)

        val dishDecisionResult: DmnDecisionTableResult = decisionService.evaluateDecisionTableByKey("mydmn", variables)
        val desiredDish = dishDecisionResult.getSingleEntry<String>()
        return desiredDish
    }

    @GetMapping("/process")
    fun process(): String? {
        val runtime = processEngine.runtimeService
        val instance = runtime
            .createProcessInstanceById("myProcess")
            .executeWithVariablesInReturn()
        return "OK"
    }
}
