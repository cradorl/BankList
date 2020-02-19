package com.task.bank.controller;

import com.task.bank.model.entity.Account;
import com.task.bank.model.entity.User;
//import sun.net.smtp.SmtpPrintStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

public class MainController extends HttpServlet {

    private static final String URL_CONNECTION =
            "jdbc:mysql://localhost:3306/bank?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Class.forName(DRIVER_NAME);
            PrintWriter printWriter = resp.getWriter();
            ArrayList<User> userArrayList = new ArrayList<>();
            //ArrayList<Account> accountArrayList = new ArrayList<>();
            try {

                Connection connection = DriverManager.getConnection(URL_CONNECTION, USERNAME, PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from users");
                //ResultSet resultSet2 = statement.executeQuery("select*from accounts");
                printWriter.print("<h1>The Bank List</h1>");

                while (resultSet.next()) {
                    User user = new User();
                    user.setUserId(resultSet.getInt(1));
                    user.setName(resultSet.getString(2));
                    user.setSurname(resultSet.getString(3));
                    userArrayList.add(user);
                }
//                while (resultSet2.next()) {
//                    Account account = new Account();
//                    account.setUserId(resultSet.getInt(3));
//                    account.setAccount(resultSet.getInt(2));
//                    account.setAccount(resultSet.getInt(1));
//                    accountArrayList.add(account);
//                }
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
            resp.setContentType("text/html");
            resp.setContentType("text/html");
            printWriter.print("<html>");
            printWriter.print("<body>");
            printWriter.print("</body>");
            printWriter.print("</html>");

            for (int i = 0; i < userArrayList.size(); i++) {
                printWriter.print("\n<h1>=====================</h1>\n");
                printWriter.print(userArrayList.get(i));
            }
            printWriter.close();
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}

