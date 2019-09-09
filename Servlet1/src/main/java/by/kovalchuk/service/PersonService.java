package by.kovalchuk.service;

import by.kovalchuk.exception.RepositoryException;
import by.kovalchuk.exception.ServiceException;
import by.kovalchuk.model.Person;
import by.kovalchuk.repository.PersonRepository;
import by.kovalchuk.repository.RepositoryCreator;

import java.util.List;


public class PersonService {

    public List<Person> findAll() throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            PersonRepository personRepository = repositoryCreator.getPersonRepository();
            return personRepository.findAll();
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void save(Person person) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            PersonRepository personRepository = repositoryCreator.getPersonRepository();
            personRepository.save(person);
        } catch (RepositoryException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }
}

