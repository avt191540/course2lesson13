package pro.sky.course2lesson13.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.course2lesson13.EmployeeBook;

import static org.mockito.Mockito.*;
import static pro.sky.course2lesson13.constants.EmployeeBookConstants.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest {
    private final EmployeeBook employeeBookMock = mock(EmployeeBook.class);
    @InjectMocks
    private EmployeeServiceImpl out;

@Test
    public void shouldCallEmployeeBookMethodWhenAddEmployeeWhoIsNotExists() {
        when(employeeBookMock.addEmployee(EMPLOYEE_WHO_IS_NOT_EXIST))
                .thenReturn(EMPLOYEE_WHO_IS_ADDED_TO_BOOK);
        Assertions.assertEquals(EMPLOYEE_WHO_IS_ADDED_TO_BOOK.toString(),
                out.addEmployeeToBook(FIRST_NAME_NOT_EXIST_ADD, LAST_NAME_NOT_EXIST_ADD, DEPARTMENT_ADD, SALARY_ADD));
        verify(employeeBookMock, times(1)).addEmployee(EMPLOYEE_WHO_IS_NOT_EXIST);
    }
    @Test
    public void shouldCallEmployeeBookMethodWhenAddEmployeeWhoIsNotExistsWithLoverCaseName() {
        when(employeeBookMock.addEmployee(EMPLOYEE_WHO_IS_NOT_EXIST))
                .thenReturn(EMPLOYEE_WHO_IS_ADDED_TO_BOOK);
        Assertions.assertEquals(EMPLOYEE_WHO_IS_ADDED_TO_BOOK.toString(),
                out.addEmployeeToBook(FIRST_NAME_NOT_EXIST_ADD_WITH_LOWER_CASE, LAST_NAME_NOT_EXIST_ADD_WITH_LOWER_CASE, DEPARTMENT_ADD, SALARY_ADD));
        verify(employeeBookMock, times(1)).addEmployee(EMPLOYEE_WHO_IS_NOT_EXIST);
    }

//    @BeforeEach
//    public void initOut() {
//        out = new EmployeeServiceImpl(employeeBookMock);
//    }
}
