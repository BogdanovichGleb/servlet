package by.kovalchuk.builder;

public class BuilderFactory {

    private static final String USER = "users";
    private static final String PERSON = "persons";
    private static final String MESSAGE= "Unknown Builder name!";

    public static Builder create(String builderName) {

        switch (builderName) {
            case USER: {
                return new UserBuilder();
            }

            case PERSON: {
                return new PersonBuilder();
            }

            default:

                throw new IllegalArgumentException(MESSAGE);

        }

    }
}
