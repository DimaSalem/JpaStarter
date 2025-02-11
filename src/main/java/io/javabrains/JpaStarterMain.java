package io.javabrains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class JpaStarterMain {
    public static void main(String[] args) {

        Employee employee1 = new Employee();
        employee1.setName("Dima");
        employee1.setAge(26);
//        employee1.setAccessCardId(3);

        Employee employee2 = new Employee();
        employee2.setName("Maha");
        employee2.setAge(28);
//        employee2.setAccessCardId(4);

        AccessCard card1 = new AccessCard();
        card1.setActive(true);
        card1.setFirmwareVersion("1.0.0");
        card1.setIssuedDate(new Date());
        card1.setOwner(employee1);
        employee1.setAccessCard(card1);


        AccessCard card2 = new AccessCard();
        card2.setActive(false);
        card2.setFirmwareVersion("1.2.0");
        card2.setIssuedDate(new Date());
        card2.setOwner(employee2);
        employee2.setAccessCard(card2);




        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager =  entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();


//        Employee employee1 = entityManager.find(Employee.class, 1);
//        employee1.setAge(26);

        entityManager.persist(employee1);
//        entityManager.remove(employee1);
        entityManager.persist(employee2);

        entityManager.persist(card1);
        entityManager.persist(card2);




        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();

    }
}
