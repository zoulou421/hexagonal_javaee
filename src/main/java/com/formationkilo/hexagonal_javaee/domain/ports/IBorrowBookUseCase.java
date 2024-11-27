package com.formationkilo.hexagonal_javaee.domain.ports;

public interface IBorrowBookUseCase {
//Dans le domaine, vous définissez un port pour l'action d'emprunter un livre
	void borrowBook(String bookId, String userId) throws Exception;
}
