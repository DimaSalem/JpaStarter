package io.javabrains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.Date;

public class JpaStarterWrite {
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


        PayStub payStub1 = new PayStub();
        payStub1.setPayPeriodStart(new Date());
        payStub1.setPayPeriodEnd(new Date());
        payStub1.setSalary(1000);
        payStub1.setEmployee(employee1);
        employee1.addPayStub(payStub1);

        PayStub payStub2 = new PayStub();
        payStub2.setPayPeriodStart(new Date());
        payStub2.setPayPeriodEnd(new Date());
        payStub2.setSalary(2000);
        payStub2.setEmployee(employee1);
        employee1.addPayStub(payStub2);

        EmailGroup group1 = new EmailGroup();
        group1.setName("Company watercooler discussion");
        group1.addMember(employee1);
        group1.addMember((employee2));
        employee1.addEmailSubscription(group1);
        employee2.addEmailSubscription(group1);


        EmailGroup group2 = new EmailGroup();
        group2.setName("Engineering");
        group2.addMember(employee1);
        employee1.addEmailSubscription(group2);



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

        entityManager.persist(payStub1);
        entityManager.persist(payStub2);

        entityManager.persist(group1);
        entityManager.persist(group2);





        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();

    }

}
