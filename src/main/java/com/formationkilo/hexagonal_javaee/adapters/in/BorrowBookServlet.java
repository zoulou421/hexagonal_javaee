package com.formationkilo.hexagonal_javaee.adapters.in;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.formationkilo.hexagonal_javaee.domain.ports.IBorrowBookUseCase;
import com.formationkilo.hexagonal_javaee.domain.services.BorrowBookUseCaseService;

@WebServlet(name = "BorrowBookServlet", urlPatterns = "/borrow")
public class BorrowBookServlet extends HttpServlet {
	// Utilisation de l'implémentation du port
    private final IBorrowBookUseCase borrowBookUseCase = new BorrowBookUseCaseService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookId = request.getParameter("bookId");
        String userId = "USER123"; // Peut être récupéré d'une session utilisateur ou d'un système d'authentification

        try {
            borrowBookUseCase.borrowBook(bookId, userId);
            // Redirection en cas de succès
            response.sendRedirect("success.jsp");
        } catch (Exception e) {
            // Gestion des erreurs et redirection vers une page d'erreur
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
