package ru.tinkoff.fintech.task9

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.springframework.web.bind.annotation.*

@RestController
class StudentResource(val service: StudentService) {
    @GetMapping("/our-best-student/{studentId}")
    fun getS(@PathVariable studentId: Int) = service.get(studentId)

    @PostMapping("/our-best-student")
    fun postS(@RequestBody student: Student) {
        CoroutineScope(Dispatchers.Default).launch {
            service.post(student)
        }
    }
}