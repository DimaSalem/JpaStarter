package io.javabrains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaStarterUpdate {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager =  entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Employee employee= entityManager.find(Employee.class, 2);
        EmailGroup group= entityManager.find(EmailGroup.class, 8);

        employee.addEmailSubscription(group);
        group.addMember(employee);

        entityManager.persist(employee);
        entityManager.persist(group);



        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
