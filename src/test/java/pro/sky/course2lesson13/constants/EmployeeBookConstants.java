package pro.sky.course2lesson13.constants;

import pro.sky.course2lesson13.Employee;

public class EmployeeBookConstants {
    public static final Employee EMPLOYEE_WHO_IS_NOT_EXIST =
            new Employee("Vladimir", "Shatrov", 2, 30000);
    public static final String FIRST_NAME_NOT_EXIST_ADD = "Vladimir";
    public static final String FIRST_NAME_NOT_EXIST_ADD_WITH_LOWER_CASE = "vladimir";
    public static final String FIRST_NAME_NOT_EXIST_ADD_WITH_ILLEGAL_CHARACTERS = "Vladimir123";
    public static final String LAST_NAME_NOT_EXIST_ADD = "Shatrov";
    public static final String LAST_NAME_NOT_EXIST_ADD_WITH_LOWER_CASE = "shatrov";
    public static final String LAST_NAME_NOT_EXIST_ADD_WITH_ILLEGAL_CHARACTERS = "Shatrov456";
    public static final int DEPARTMENT_ADD = 2;
    public static final int SALARY_ADD = 30000;
//    public static final Employee EMPLOYEE_WHO_IS_NOT_EXIST_WITH_LOWER_CASE_NAME =
//            new Employee("vladimir", "shatrov", 2, 30000);
//    public static final Employee EMPLOYEE_WHO_IS_NOT_EXIST_WITH_ILLEGAL_CHARACTERS_NAME =
//            new Employee("vladimir123", "shatrov", 2, 30000);
    public static final Employee EMPLOYEE_WHO_IS_ALREADY_EXIST =
            new Employee("Ivan", "Ivanov", 2, 20000);
    public static final Employee EMPLOYEE_WHO_IS_ALREADY_EXIST_WITH_LOWER_CASE_NAME =
            new Employee("ivan", "ivanov", 2, 20000);
    public static final Employee EMPLOYEE_WHO_IS_ALREADY_EXIST_WITH_ILLEGAL_CHARACTERS_NAME =
            new Employee("Ivan57", "Ivanov", 2, 20000);
    public static final Employee EMPLOYEE_WHO_IS_ADDED_TO_BOOK =
            new Employee("Vladimir", "Shatrov", 2, 30000);
    public static final Employee EMPLOYEE_WHO_IS_FOUND_OR_REMOVE_IN_BOOK =
            new Employee("Ivan", "Ivanov", 2, 20000);
    public static final int NUMBER_OF_EMPLOYEES_IN_BOOK = 6;
}
