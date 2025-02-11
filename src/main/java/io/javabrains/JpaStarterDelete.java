package io.javabrains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaStarterDelete {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager =  entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Employee employee= entityManager.find(Employee.class, 1);
//        EmailGroup group= entityManager.find(EmailGroup.class, 8);


        entityManager.remove(employee);



        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
