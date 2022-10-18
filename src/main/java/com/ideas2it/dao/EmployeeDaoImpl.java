package com.ideas2it.dao;

import com.ideas2it.model.Employee;
import com.ideas2it.model.EmployeeProject;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;


/**
 * This class implements the employee DAO 
 * Has created, update read and display methods
 * It manages the employee data
 *
 * @author Nithish K
 * @verison 1.0
 * @since 14.09.2022
 */
public class EmployeeDaoImpl implements EmployeeDao {
    private final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
 
    @Override
    public String addEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        String employeeId = null;
            
        try {
            Transaction transaction = session.beginTransaction();
            employeeId = (String) session.save(employee); 
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println(e); 
        } finally {
            session.close();
        }
        return employeeId;
    }

    @Override
    public String generateEmployeeId() {
        String prefixId = "IT";
        String sequenceCount = "";
        int employeeCount = 100;
        String lastEmployeeId = getLastEmployeeId();
        String employeeId;

        if (lastEmployeeId != null) {
            for (int i = 2; i < lastEmployeeId.length(); i++) {
                sequenceCount += lastEmployeeId.charAt(i);
            }
            employeeCount = Integer.parseInt(sequenceCount);
        }
        employeeId = prefixId + ++employeeCount;
        return employeeId;
    }

    @Override
    public String getLastEmployeeId() {
        Session session = sessionFactory.openSession();
        String lastId = " ";
        try {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("SELECT MAX(employeeId) FROM Employee");
            lastId = (String)query.getSingleResult();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return lastId;
    }

    @Override
    public Employee getEmployeeById(String employeeId) throws HibernateException, NoResultException {
        Session session = sessionFactory.openSession();
        Employee employee = null;
        try {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Employee WHERE employeeId = :employeeId AND deleted = 0");
            query.setParameter("employeeId", employeeId);
            employee = (Employee) query.getSingleResult();
            transaction.commit();
        } catch (HibernateException e) {
            throw new HibernateException(e);
        } catch (NoResultException e) {
            throw new NoResultException("Employee Not Found");
        } finally {
            session.close();
        }
        return employee; 
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        boolean isEmployeeUpdated = false;
        try {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
            isEmployeeUpdated = true;
        } catch (HibernateException e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return isEmployeeUpdated;
    }

    @Override
    public int removeEmployee(String employeeId) {
        Session session = sessionFactory.openSession();
        int updatedRow = 0;
        try {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("UPDATE Employee SET deleted = 1 WHERE employeeId = :employeeId");
            query.setParameter("employeeId",employeeId);
            updatedRow = query.executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return updatedRow;
    }

    @Override
    public List<Employee> getEmployees() {
        Session session = sessionFactory.openSession();
        List<Employee> employees = new ArrayList<>();
        try {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Employee WHERE deleted = 0");
            employees = query.getResultList();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return employees;
    }

    @Override
    public boolean assignProject(Employee employee, EmployeeProject project) {
        Session session = sessionFactory.openSession();
        boolean isAdded = false;    
        List<EmployeeProject> projects = new ArrayList<>();
        projects.add(project);

        try {
            Transaction transaction = session.beginTransaction();
            employee.setEmployeeProjects(projects);
            session.saveOrUpdate(employee);
            transaction.commit();
            isAdded = true;
        } catch (HibernateException e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return isAdded;
    }

    @Override
    public List<Object[]> getEmployeeDetails(String employeeId) {
       List<Object[]> employeeInformation = null;
        Session session = sessionFactory.openSession();

        try {
            String employeeInfo =  "FROM Employee e "
                                  //+"INNER JOIN LeaveRecord l ON l.employee = :employeeId "
                                  +"INNER JOIN EmployeeProject p ON p.projectId = "
                                  +"(SELECT p.id FROM p.employees em WHERE em.employeeId = :employeeId)"
                                  +"WHERE e.employeeId = :employeeId ";
            Query query = session.createQuery(employeeInfo);
            query.setParameter("employeeId",employeeId);
            employeeInformation = query.getResultList();
        } catch (HibernateException e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return employeeInformation;
    }
}
