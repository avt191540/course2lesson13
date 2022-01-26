package pro.sky.course2lesson13.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.course2lesson13.EmployeeBook;
import pro.sky.course2lesson13.EmployeeExistException;
import pro.sky.course2lesson13.EmployeeNotExistException;
import pro.sky.course2lesson13.InvalidInputData;

import static org.mockito.Mockito.*;
import static pro.sky.course2lesson13.constants.EmployeeBookConstants.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest {
    private final EmployeeBook employeeBookMock = mock(EmployeeBook.class);
    @InjectMocks
    private EmployeeServiceImpl out;

@Test
    public void shouldCallEmployeeBookMethodWhenAddEmployeeWhoIsNotExists() {
        when(employeeBookMock.addEmployee(eq(EMPLOYEE_WHO_IS_NOT_EXIST)))
                .thenReturn(EMPLOYEE_WHO_IS_ADDED_TO_BOOK);
        Assertions.assertEquals(EMPLOYEE_WHO_IS_ADDED_TO_BOOK.toString(),
                out.addEmployeeToBook(FIRST_NAME_NOT_EXIST, LAST_NAME_NOT_EXIST,
                        DEPARTMENT_NOT_EXISTS, SALARY_NOT_EXISTS));
        verify(employeeBookMock, times(1)).addEmployee(EMPLOYEE_WHO_IS_NOT_EXIST);
    }
    @Test
    public void shouldCallEmployeeBookMethodWhenAddEmployeeWhoIsNotExistsWithLoverCaseName() {
        when(employeeBookMock.addEmployee(eq(EMPLOYEE_WHO_IS_NOT_EXIST)))
                .thenReturn(EMPLOYEE_WHO_IS_ADDED_TO_BOOK);
        Assertions.assertEquals(EMPLOYEE_WHO_IS_ADDED_TO_BOOK.toString(),
                out.addEmployeeToBook(FIRST_NAME_NOT_EXIST_WITH_LOWER_CASE,
                        LAST_NAME_NOT_EXIST_WITH_LOWER_CASE,
                        DEPARTMENT_NOT_EXISTS, SALARY_NOT_EXISTS));
        verify(employeeBookMock, times(1)).addEmployee(EMPLOYEE_WHO_IS_NOT_EXIST);
    }
    @Test
    public void shouldThrowInvalidInputDataExceptionWhenAddEmployeeWhoIsNotExistsWithIllegalCharacters() {
        when(employeeBookMock.addEmployee(eq(EMPLOYEE_WHO_IS_NOT_EXIST)))
                .thenReturn(EMPLOYEE_WHO_IS_ADDED_TO_BOOK);
        Assertions.assertThrows(InvalidInputData.class, ()->
                out.addEmployeeToBook(FIRST_NAME_NOT_EXIST_WITH_ILLEGAL_CHARACTERS,
                        LAST_NAME_NOT_EXIST_WITH_ILLEGAL_CHARACTERS,
                        DEPARTMENT_NOT_EXISTS, SALARY_NOT_EXISTS));
        verify(employeeBookMock, never()).addEmployee(EMPLOYEE_WHO_IS_NOT_EXIST);
    }
    @Test
    public void shouldThrowEmployeeExistExceptionWhenAddEmployeeWhoIsAlreadyExists() {
        when(employeeBookMock.addEmployee(any()))
                .thenThrow(EmployeeExistException.class);
        Assertions.assertThrows(EmployeeExistException.class, () ->
                out.addEmployeeToBook(FIRST_NAME_ALREADY_EXIST, LAST_NAME_ALREADY_EXIST,
                        DEPARTMENT_ALREADY_EXISTS, SALARY_ALREADY_EXISTS));
        verify(employeeBookMock, times(1)).addEmployee(EMPLOYEE_WHO_IS_ALREADY_EXIST);
    }
    @Test
    public void shouldCallEmployeeBookMethodWhenFindEmployeeWhoIsAlreadyExists() {
        when(employeeBookMock.findEmployee(eq(EMPLOYEE_WHO_IS_ALREADY_EXIST)))
                .thenReturn(EMPLOYEE_WHO_IS_FOUND_OR_REMOVE_IN_BOOK);
        Assertions.assertEquals(EMPLOYEE_WHO_IS_FOUND_OR_REMOVE_IN_BOOK,
                out.findEmployeeInBook(FIRST_NAME_ALREADY_EXIST, LAST_NAME_ALREADY_EXIST,
                        DEPARTMENT_ALREADY_EXISTS, SALARY_ALREADY_EXISTS));
        verify(employeeBookMock, times(1)).findEmployee(EMPLOYEE_WHO_IS_ALREADY_EXIST);
    }
    @Test
    public void shouldCallEmployeeBookMethodWhenFindEmployeeWhoIsAlreadyExistsWithLoverCaseName() {
        when(employeeBookMock.findEmployee(eq(EMPLOYEE_WHO_IS_ALREADY_EXIST)))
                .thenReturn(EMPLOYEE_WHO_IS_FOUND_OR_REMOVE_IN_BOOK);
        Assertions.assertEquals(EMPLOYEE_WHO_IS_FOUND_OR_REMOVE_IN_BOOK,
                out.findEmployeeInBook(FIRST_NAME_ALREADY_EXIST_WITH_LOWER_CASE,
                        LAST_NAME_ALREADY_EXIST_WITH_LOWER_CASE,
                        DEPARTMENT_ALREADY_EXISTS, SALARY_ALREADY_EXISTS));
        verify(employeeBookMock, times(1)).findEmployee(EMPLOYEE_WHO_IS_ALREADY_EXIST);
    }
    @Test
    public void shouldThrowInvalidInputDataExceptionWhenFindEmployeeWhoIsAlreadyExistsWithIllegalCharacters() {
        when(employeeBookMock.findEmployee(eq(EMPLOYEE_WHO_IS_ALREADY_EXIST)))
                .thenReturn(EMPLOYEE_WHO_IS_FOUND_OR_REMOVE_IN_BOOK);
        Assertions.assertThrows(InvalidInputData.class, ()->
                out.findEmployeeInBook(FIRST_NAME_ALREADY_EXIST_WITH_ILLEGAL_CHARACTERS,
                        LAST_NAME_ALREADY_EXIST_WITH_ILLEGAL_CHARACTERS,
                        DEPARTMENT_ALREADY_EXISTS, SALARY_ALREADY_EXISTS));
        verify(employeeBookMock, never()).findEmployee(EMPLOYEE_WHO_IS_ALREADY_EXIST);
    }
    @Test
    public void shouldThrowEmployeeNotExistExceptionWhenFindEmployeeWhoIsNotExists() {
        when(employeeBookMock.findEmployee(any()))
                .thenThrow(EmployeeNotExistException.class);
        Assertions.assertThrows(EmployeeNotExistException.class, () ->
                out.findEmployeeInBook(FIRST_NAME_NOT_EXIST, LAST_NAME_NOT_EXIST,
                        DEPARTMENT_NOT_EXISTS, SALARY_NOT_EXISTS));
        verify(employeeBookMock, times(1)).findEmployee(EMPLOYEE_WHO_IS_NOT_EXIST);
    }
    @Test
    public void shouldCallEmployeeBookMethodWhenRemoveEmployeeWhoIsAlreadyExists() {
        when(employeeBookMock.removeEmployee(eq(EMPLOYEE_WHO_IS_ALREADY_EXIST)))
                .thenReturn(EMPLOYEE_WHO_IS_FOUND_OR_REMOVE_IN_BOOK);
        Assertions.assertEquals(EMPLOYEE_WHO_IS_FOUND_OR_REMOVE_IN_BOOK.toString(),
                out.removeEmployeeFromBook(FIRST_NAME_ALREADY_EXIST, LAST_NAME_ALREADY_EXIST,
                        DEPARTMENT_ALREADY_EXISTS, SALARY_ALREADY_EXISTS));
        verify(employeeBookMock, times(1)).removeEmployee(EMPLOYEE_WHO_IS_ALREADY_EXIST);
    }
    @Test
    public void shouldCallEmployeeBookMethodWhenRemoveEmployeeWhoIsAlreadyExistsWithLoverCaseName() {
        when(employeeBookMock.removeEmployee(eq(EMPLOYEE_WHO_IS_ALREADY_EXIST)))
                .thenReturn(EMPLOYEE_WHO_IS_FOUND_OR_REMOVE_IN_BOOK);
        Assertions.assertEquals(EMPLOYEE_WHO_IS_FOUND_OR_REMOVE_IN_BOOK.toString(),
                out.removeEmployeeFromBook(FIRST_NAME_ALREADY_EXIST_WITH_LOWER_CASE,
                        LAST_NAME_ALREADY_EXIST_WITH_LOWER_CASE,
                        DEPARTMENT_ALREADY_EXISTS, SALARY_ALREADY_EXISTS));
        verify(employeeBookMock, times(1)).removeEmployee(EMPLOYEE_WHO_IS_ALREADY_EXIST);
    }
    @Test
    public void shouldThrowInvalidInputDataExceptionWhenRemoveEmployeeWhoIsAlreadyExistsWithIllegalCharacters() {
        when(employeeBookMock.removeEmployee(eq(EMPLOYEE_WHO_IS_ALREADY_EXIST)))
                .thenReturn(EMPLOYEE_WHO_IS_FOUND_OR_REMOVE_IN_BOOK);
        Assertions.assertThrows(InvalidInputData.class, ()->
                out.removeEmployeeFromBook(FIRST_NAME_ALREADY_EXIST_WITH_ILLEGAL_CHARACTERS,
                        LAST_NAME_ALREADY_EXIST_WITH_ILLEGAL_CHARACTERS,
                        DEPARTMENT_ALREADY_EXISTS, SALARY_ALREADY_EXISTS));
        verify(employeeBookMock, never()).removeEmployee(EMPLOYEE_WHO_IS_ALREADY_EXIST);
    }
    @Test
    public void shouldThrowEmployeeNotExistExceptionWhenRemoveEmployeeWhoIsNotExists() {
        when(employeeBookMock.removeEmployee(any()))
                .thenThrow(EmployeeNotExistException.class);
        Assertions.assertThrows(EmployeeNotExistException.class, () ->
                out.removeEmployeeFromBook(FIRST_NAME_NOT_EXIST, LAST_NAME_NOT_EXIST,
                        DEPARTMENT_NOT_EXISTS, SALARY_NOT_EXISTS));
        verify(employeeBookMock, times(1)).removeEmployee(EMPLOYEE_WHO_IS_NOT_EXIST);
    }



}
