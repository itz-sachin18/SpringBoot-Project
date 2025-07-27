package com.example.Expense_Tracker.service;

import java.util.List;

import javax.print.attribute.standard.MediaSize.Other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Expense_Tracker.model.Expense;
import com.example.Expense_Tracker.repository.ExpenseRepository;

@Service
public class ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;
	
	public List<Expense> getAllexpense(){
		return expenseRepository.findAll();  
	}
	
	public void  saveExpense(Expense expense) {
		expenseRepository.save(expense );
	}
	
	public Expense getExpenseById(Long id) {
		return expenseRepository.findById(id).orElse(null);
	} 
	
	public void deleteExpenseById(Long id) {
		expenseRepository.deleteById(id);
	}
	
	
}
 