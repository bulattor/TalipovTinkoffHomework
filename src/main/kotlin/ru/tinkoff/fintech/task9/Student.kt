package ru.tinkoff.fintech.task9

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "students")
@Entity
data class Student(
    @Id
    @Column(name = "student_id")
    var studentId: Int? = null,
    @Column(name = "username")
    var username: String? = null,
    @Column(name = "info")
    var info: String? = null,
)