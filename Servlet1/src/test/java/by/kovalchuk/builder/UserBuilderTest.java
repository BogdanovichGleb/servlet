package by.kovalchuk.builder;

import by.kovalchuk.exception.RepositoryException;
import by.kovalchuk.model.User;
import by.kovalchuk.repository.dbconstants.UserTableConstants;
import by.kovalchuk.util.HashPassword;
import org.junit.Before;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserBuilderTest {

    private static final Integer ID = 1;
    private static final String LOGIN = "admin";
    private static final byte [] PASSWORD = HashPassword.getHash("admin");


    private User EXPECTED_USER = null;

    @Before
    public void initExpectedUser(){
        EXPECTED_USER = new User(
                ID,
                LOGIN,
                PASSWORD
        );
    }

    //@Ignore
    @Test
    public void shouldBuildAndReturnUserWithParameters() throws SQLException,
            RepositoryException {
        // Arrange
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.getInt(UserTableConstants.ID.getFieldName())).thenReturn(ID);
        when(resultSet.getString(UserTableConstants.LOGIN.getFieldName())).thenReturn(LOGIN);
        when(resultSet.getBytes(UserTableConstants.PASSWORD.getFieldName())).thenReturn(PASSWORD);
        // Act
        UserBuilder userBuilder = new UserBuilder();
        User actualUser = userBuilder.build(resultSet);
        //Assert
        assertEquals(EXPECTED_USER, actualUser);
    }
}
