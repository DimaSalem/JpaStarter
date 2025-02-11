package io.javabrains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class JpaStarterRead {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager =  entityManagerFactory.createEntityManager();

        System.out.println("********* Before fetching Employee");
        Employee employee1 = entityManager.find(Employee.class, 1);
        System.out.println("********* Before accessing PayStubs");

        System.out.println(employee1.getPayStub());

//        AccessCard card = entityManager.find(AccessCard.class, 3);
//        System.out.println(card.getOwner().getName());




//        entityManager.close();
//        entityManagerFactory.close();

    }

}
