package bg.jug.website.sessions;

import bg.jug.website.entities.User;
import bg.jug.website.users.LoggedIn;

import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.annotation.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author Ivan St. Ivanov
 */
@Controller
@Path("/session")
public class SessionController {

    @Inject
    private SessionManager sessionManager;

    @Inject
    @LoggedIn
    private User currentUser;

    @Inject
    private Models models;

    @GET
    public String showAllSessions() {
        models.put("submissions", sessionManager.getAllSessions());
        return "sessions.jsp";
    }

    @GET
    @Path("/currentUser")
    public String showAllSessionsForCurrentUser() {
        models.put("submissions", sessionManager.getSessionsForUser(currentUser));
        return "sessions.jsp";
    }

}
