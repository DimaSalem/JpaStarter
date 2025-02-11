package io.javabrains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class JpaPresistenceContextDemo {
    public static void main(String[] args) {

        Employee employee1 = new Employee();
        employee1.setName("Maha");
        employee1.setAge(28);
//        employee1.setAccessCardId(3);


        System.out.println("********************* created employee instance");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager =  entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        System.out.println("********************* starting transaction");

        entityManager.persist(employee1);
        Employee employeeFound= entityManager.find(Employee.class, 1);
        System.out.println(employee1);
        System.out.println(employeeFound);

        System.out.println("********************* after persist method called");






        transaction.commit();
        System.out.println("********************* after transaction closed");

        entityManager.close();
        entityManagerFactory.close();

    }

}
