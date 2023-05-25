package exercise.repository;

import exercise.model.QUser;
import exercise.model.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
// Зависимости для дополнительного задания
//import org.springframework.data.querydsl.QuerydslPredicateExecutor;
//import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
//import org.springframework.data.querydsl.binding.QuerydslBindings;
//import com.querydsl.core.types.dsl.StringPath;


import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends
        // Наследуем репозиторий от этих классов
        JpaRepository<User, Long>,
        QuerydslPredicateExecutor<User>,
        QuerydslBinderCustomizer<QUser> {

    // Чтобы не возникала ошибка, нужно переопределить в репозитории метод customize
    // Если не нужно ничего кастомизировать, метод оставляем пустым
    // Класс QUser автоматически генерируется при компиляции, если добавить нужные зависимости
    // и процессоры аннотаций. Изучите зависимости в файле build.gradle
    @Override
    default void customize(QuerydslBindings bindings, QUser user) {
    }
}

// Дополнительная задача
// Если решите сделать дополнительную задачу, измените существующий репозиторий для работы с Querydsl предикатами
// BEGIN

// END
