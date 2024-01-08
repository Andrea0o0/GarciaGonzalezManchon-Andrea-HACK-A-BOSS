package practicalexercises.exercise1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import practicalexercises.exercise1.models.Employee;


public class Exercise1 {

    public static void main(String[] args) {
        Random rand = new Random();
        // NUMBER DECIMALS SALARY:
        int decimalsSalary = 2;
        
        List<Employee> employees = new ArrayList<Employee>();
        
        String[] categoryType = {"Developer","Analyst","Manager"};
        for (int i = 0; i < rand.nextInt(100); i++) {
            double randomSalaryWithAllDecimals = (rand.nextDouble(8801)+1200);
            double powDecimals = Math.pow(10, decimalsSalary);
            employees.add(new Employee("Employee"+i,
                    Math.round(randomSalaryWithAllDecimals*powDecimals)/powDecimals,categoryType[rand.nextInt(categoryType.length)]));
        }
        for (Employee employee : employees) {
            System.out.println(employee);
        }
//        System.out.println(employees.size());

        // SALARY HAS TO BE HIGHER THAN 5000
        List<Employee> salaryEmployees = employees.stream()
                .filter(employee -> employee.getSalary() > 5000)
                .collect(Collectors.toList());
//        salaryEmployees.forEach(employee -> System.out.println(employee));
        
        // OPTION 1
        // FILTER EMPLOYEES BY CATEGORY WITHOUT KNOWING HOW MANY CATEGORIES ARE without stream directly
        Map<String,List<Employee>> categoryEmployee = new HashMap<>();
        for (Employee employee : employees) {
            String categoryActualEmployee = employee.getCategory();
            List<Employee> addingExisting = new ArrayList<>();
            if(categoryEmployee.containsKey(categoryActualEmployee)){
                categoryEmployee.get(categoryActualEmployee).forEach(eachEmployee -> addingExisting.add(eachEmployee));
                addingExisting.add(employee);
            } else {
                addingExisting.add(employee);
            }
            categoryEmployee.put(categoryActualEmployee, addingExisting);
        }
        
        Map<String,Double> averageSalary = new HashMap<>();
        for (Map.Entry<String, List<Employee>> entry : categoryEmployee.entrySet()) {
            double employeesCategorySalary = entry.getValue().stream()
                    .collect(Collectors.averagingDouble(Employee::getSalary));
            averageSalary.put(entry.getKey(), employeesCategorySalary);
        }
        System.out.println(averageSalary);
        // ** FINAL OPTION 1 **
        
        
        // OPTION 2
        Map<String, Double> averageSalaryByCategoryStreamDirect = employees.stream()
        // Agrups and classify employees by different category inside MAP
                .collect(Collectors.groupingBy(Employee::getCategory,
                        // This method Allows calculting the average in double for each category based on salary parameter Collectors
                        Collectors.averagingDouble(Employee::getSalary)
                ));
//        System.out.println(averageSalaryByCategoryStreamDirect);

        // HIGHEST SALARY WITH OPTIONALS
        Employee highestSalaryy = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .findFirst()
                .orElseThrow();
        
        System.out.println("Highest salary employee is from " + highestSalaryy.getName() + " works as a " + highestSalaryy.getCategory() + " and the salary is " + highestSalaryy.getSalary());

    }
}
