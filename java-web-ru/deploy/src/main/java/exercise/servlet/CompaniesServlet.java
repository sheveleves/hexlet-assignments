package exercise.servlet;

import exercise.Data;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.stream.Collectors;

//import static exercise.Data.getCompanies;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {

        // BEGIN
        List<String> companies = Data.getCompanies();
        PrintWriter pw = response.getWriter();
        String result = "";
        String paramSearch = request.getParameter("search");

        if (request.getQueryString() == null || paramSearch.equals("")) {
            result = String.join("\n", companies);
        } else {
            result = companies.stream()
                    .filter(s -> s.contains(paramSearch))
                    .collect(Collectors.joining("\n"));
        }
        if (result.equals("")) {
            pw.println("Companies not found");
        } else {
            pw.println(result);
        }
        // END
    }
}
