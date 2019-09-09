package by.kovalchuk.builder;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(DataProviderRunner.class)
public class BuilderFactoryTest {

    private static final String USER = "users";
    private static final String PERSON = "persons";
    private static final Class USER_BUILDER = UserBuilder.class;
    private static final Class PERSON_BUILDER = PersonBuilder.class;

    @Test
    @UseDataProvider("dataForBuilderCreator")
    public void shouldCreateAndReturnAppropriateBuilder(Class Builer, String
            BuilderName) {
        Builder builder = BuilderFactory.create(BuilderName);
        Class<? extends Builder> builderClass = builder.getClass();
        assertEquals(Builer, builderClass);
    }

    @DataProvider
    public static Object[][] dataForBuilderCreator() {
        return new Object[][]{
                {USER_BUILDER,USER},
                {PERSON_BUILDER, PERSON},
        };
    }
}
