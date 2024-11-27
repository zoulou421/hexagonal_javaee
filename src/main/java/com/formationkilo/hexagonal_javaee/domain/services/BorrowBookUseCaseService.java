package com.formationkilo.hexagonal_javaee.domain.services;

import com.formationkilo.hexagonal_javaee.domain.ports.IBorrowBookUseCase;

public class BorrowBookUseCaseService implements IBorrowBookUseCase{
	//L'implémentation du cas d'utilisation se trouve dans le service de votre domaine 

	@Override
	public void borrowBook(String bookId, String userId) throws Exception {
		// TODO Auto-generated method stub
		 if (bookId == null || userId == null) {
	            throw new IllegalArgumentException("Book ID and User ID cannot be null");
	     }
		 // Logique métier (exemple simple)
	     System.out.println("Book " + bookId + " borrowed by user " + userId);
	}
	
}
