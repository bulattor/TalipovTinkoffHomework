package ru.tinkoff.fintech.task9

import org.hibernate.cfg.Configuration
import org.springframework.stereotype.Service
import java.io.File

@Service
class StudentService() {

    fun get(id: Int): Student{
        val sessionFactory = makeSessionFactory()
        sessionFactory.openSession().use {
            return it.get(Student::class.java, id)
        }
    }

    fun post(student: Student){
        val sessionFactory = makeSessionFactory()
        sessionFactory.openSession().use {
            val t = it.beginTransaction()
            it.persist(student)
            t.commit()
        }
    }
}
fun makeSessionFactory() = Configuration().configure(File("src/main/resources/hibernate.cfg.xml")).addAnnotatedClass(Student::class.java).buildSessionFactory()