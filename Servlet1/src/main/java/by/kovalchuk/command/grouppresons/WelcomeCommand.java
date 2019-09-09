package by.kovalchuk.command.grouppresons;

import by.kovalchuk.command.Command;
import by.kovalchuk.command.CommandResult;
import by.kovalchuk.exception.IncorrectDataException;
import by.kovalchuk.exception.ServiceException;
import by.kovalchuk.model.Person;
import by.kovalchuk.service.PersonService;
import by.kovalchuk.util.pages.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static by.kovalchuk.command.grouppresons.constant.GroupConstant.LISTGROUP;


public class WelcomeCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response)
            throws ServiceException, IncorrectDataException {

        PersonService personService = new PersonService();
        List<Person> clients = personService.findAll();
        if (!clients.isEmpty()) {
            request.getSession().setAttribute(LISTGROUP, clients);
        }
        return new CommandResult(Page.WELCOME_PAGE.getPage(), false);
    }
}

