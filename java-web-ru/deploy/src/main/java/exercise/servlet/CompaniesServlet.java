package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.stream.Collectors;
import static exercise.Data.getCompanies;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        // BEGIN
        List<String> companies = getCompanies();
        PrintWriter out = response.getWriter();

        String search = request.getParameter("search");
        
        boolean isFound = false;

        if (search == null || search.equals("")) {
            companies.forEach(out::println);
        } else {
            for (String company : companies) {
                if (company.contains(search)) {
                    out.println(company);
                    isFound = true;
                }
            }
            if (!isFound) {
                out.println("Companies not found");
            }
        }
        // END
    }
}
