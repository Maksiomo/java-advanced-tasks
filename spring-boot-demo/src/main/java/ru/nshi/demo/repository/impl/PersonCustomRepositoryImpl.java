package ru.nshi.demo.repository.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;
import ru.nshi.demo.model.domain.Person;
import ru.nshi.demo.repository.PersonCustomRepository;

import javax.persistence.EntityManager;
import java.util.Collections;

/**
 * @author rassafel
 */
@RequiredArgsConstructor
@Slf4j
@Repository
@Transactional
public class PersonCustomRepositoryImpl implements PersonCustomRepository {
    private final EntityManager entityManager;
    private final PlatformTransactionManager transactionManager;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Person> findByAge(Integer age) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        // Custom query logic
        transactionTemplate.execute(status -> null);
        return Collections.emptyList();
    }
}
