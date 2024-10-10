package com.accountsystem.accountsystem.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accountsystem.accountsystem.entities.Transaction;
import com.accountsystem.accountsystem.exceptions.InsufficientBalanceException;
import com.accountsystem.accountsystem.services.TransactionServiceImpl;

@RestController
@RequestMapping("/movimientos")
public class TransactionController {

	@Autowired
    private TransactionServiceImpl transactionService;

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
    	return new ResponseEntity<>(transactionService.getAllTransactions(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable("id") Long id) {
    	Optional<Transaction> Transaction = transactionService.getTransactionById(id);
        if(Transaction.isPresent()) {
            return new ResponseEntity<>(Transaction.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> createTransaction(@RequestBody Transaction Transaction) {
    	try {
            Transaction savedTransaction = transactionService.createTransaction(Transaction);
            return new ResponseEntity<>(savedTransaction, HttpStatus.OK);

        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>("Data integrity violation: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (TransactionSystemException e) {
            return new ResponseEntity<>("Transaction system exception: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTransaction(@PathVariable("id") Long id, @RequestBody Transaction TransactionDetails) {
    	try {
            Transaction updatedTransaction = transactionService.updateTransaction(id, TransactionDetails);
            return new ResponseEntity<>(updatedTransaction, HttpStatus.OK);

        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>("Data integrity violation: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (TransactionSystemException e) {
            return new ResponseEntity<>("Transaction system exception: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable("id") Long id) {
        transactionService.deleteTransaction(id);
    }
    
    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<String> handleInsufficientBalanceException(InsufficientBalanceException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    
}
