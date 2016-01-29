package autorepair;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class ClientController {

    @Autowired
    private ClientDao clientDao;
 
    @RequestMapping(value="/client")
    public ModelAndView autorepair(HttpServletRequest request) throws UnsupportedEncodingException {

        request.setCharacterEncoding("UTF-8");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        String name = firstName+lastName;
        String telephoneNumber = request.getParameter("telephoneNumber");

        String email = request.getParameter("email");

        if ((name != null) && (email != null))
            clientDao.persist(new Client(firstName,lastName,email,telephoneNumber));
 
        // Prepare the result view (client.jsp):
        return new ModelAndView("client.jsp", "clientDao", clientDao);
    }
}
