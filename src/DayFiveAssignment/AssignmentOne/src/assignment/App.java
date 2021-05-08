import business.abstracts.EmailConfirmationService;
import business.abstracts.LoginServiceProvider;
import business.abstracts.TokenFactory;
import business.abstracts.UserService;
import business.abstracts.Validator;
import business.adapters.GoogleAuthAdapter;
import business.concretes.CustomEmailService;
import business.concretes.CustomLogger;
import business.concretes.managers.EmailConfirmationManager;
import business.concretes.managers.UserManager;
import business.concretes.validators.EmailValidator;
import business.concretes.validators.NameValidator;
import business.concretes.validators.PasswordValidator;
import business.concretes.validators.UserValidator;
import business.factories.UUIDTokenFactory;
import business.loginServices.DefautLoginManager;
import core.EmailService;
import core.LoggerService;
import dataAccess.abstracts.UserDao;
import dataAccess.concretes.HibernateUserDao;
import entities.concretes.User;

public class App {
    public static void main(String[] args) throws Exception {

        User jane = new User(1, "janedoe@gmail.com", "somestrongpassword", "Jane", "Doe");

        User invalidNameUser = new User(2, "johndoe@gmail.com", "some2strongpass", "Jn", "Doe");

        User invalidEmailUser = new User(3, "jonathandoo@.gmail.com", "doo123doo", "Jonathan", "Doo");

        User invalidPasswordUser = new User(4,"jamesfoo@gmail.com","foo","James","Foo");

        LoggerService logger = new CustomLogger();

        TokenFactory tokenFactory = new UUIDTokenFactory(logger);

        EmailService emailService = new CustomEmailService(logger,tokenFactory);

        Validator<User> userValidator = new UserValidator(new EmailValidator(), new NameValidator(), new PasswordValidator());

        UserDao userDao = new HibernateUserDao(logger);

        UserService userManager = new UserManager(userDao, userValidator, logger, emailService);

        userManager.register(jane);

        userManager.register(invalidEmailUser);

        userManager.register(invalidEmailUser);

        userManager.register(invalidPasswordUser);

        EmailConfirmationService emailConfirmationService = new EmailConfirmationManager(logger, userManager);

        emailConfirmationService.confirmEmail(jane.getConfirmationToken(), jane);

        LoginServiceProvider defaultLoginServiceProvider = new DefautLoginManager(userManager, logger);

        defaultLoginServiceProvider.login(jane);

        LoginServiceProvider googleAuthServiceProvider = new GoogleAuthAdapter(logger);

        googleAuthServiceProvider.login(jane);
        
    }
}
