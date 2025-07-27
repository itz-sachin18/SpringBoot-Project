//package com.example.Expense_Tracker.controller;
//
//import java.math.BigDecimal;
//import java.security.KeyStore.Entry.Attribute;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.example.Expense_Tracker.model.Expense;
//import com.example.Expense_Tracker.service.ExpenseService;
//
//import ch.qos.logback.core.model.Model;
//
//public class ExpenseController {
//
//	@Autowired
//	private ExpenseService expenseService;
//	
//    @GetMapping("/")
//    public String viewHomePage(Model model) {
//    	List<Expense> expenses = expenseService.getAllexpense();
//    	BigDecimal totalAmount = expenses.stream().map(Expense::getAmount).reduce(BigDecimal.ZERO,BigDecimal::add);
//        model.addAttribute(attributeName:"expenses",expenses);
//        model.addAttribute(attributeName:"Total Amounts",totalAmount);
//        return index;
//    }
//
//
//	{
//    	public String showAddExpensepage(Model model) {
//    		Expense expense = new Expense();
//    		model.addAttribute(attributeName:"expenses",expense);
//    		return "add-expense";
//    	}
//    	
//     @PostMapping("/saveExpense")
//     public String saveExpense(@ModelAttribute("expense")Expenses expense,Model model) {
//    	 expenseService.saveExpense(expense);
//    	 return "redirect:/";
//     }
//    	
//     @GetMapping("editExpense/{id}"){
//    	 public String showUpdateExpensePage(@PathVariable("id")long id,Model model) {
//    		 Expense expense = expenseService.getExpenseById(id); 
//    		 model.addAttribute(attributeNa:"expense",expense);
//    		 return "update-expense";
//    	 }
//     
//    	
//     @PostMapping("/updateExpense/{id}")
//     
//     public String updateExpense(@PathVariable("id")long id,@ModelAttribute("expense")Expense expense) {
//    	Expense existingExpense = expenseService.getExpenseById(id);
//        existingExpense.setDescription(expense.getDescription());
//        existingExpense.setAmount(expense.getAmount());
//        expenseService.saveExpense(existingExpense);
//        return "redirect:/";
//     }
//    	
//    @GetMapping("/deleteExpense/{id}")
//    
//    public  String deleteExpense(@PathVariable("id") long id) {
//    	expenseService.deleteExpenseById(id);
//    	return "redirect:/";
//    }
//    	
//    	
//     
//    
//    
//}


package com.example.Expense_Tracker.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Expense_Tracker.model.Expense;
import com.example.Expense_Tracker.service.ExpenseService;

@Controller
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Expense> expenses = expenseService.getAllexpense();
        BigDecimal totalAmount = expenses.stream()
                .map(Expense::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        model.addAttribute("expenses", expenses);
        model.addAttribute("totalAmount", totalAmount);
        return "index";
    }

    @GetMapping("/addExpense")
    public String showAddExpensePage(Model model) {
        Expense expense = new Expense();
        model.addAttribute("expense", expense);
        return "add-expense";
    }

    @PostMapping("/saveExpense")
    public String saveExpense(@ModelAttribute("expense") Expense expense, Model model) {
        expenseService.saveExpense(expense);
        return "redirect:/";
    }

    @GetMapping("/editExpense/{id}")
    public String showUpdateExpensePage(@PathVariable("id") long id, Model model) {
        Expense expense = expenseService.getExpenseById(id);
        model.addAttribute("expense", expense);
        return "update-expense";
    }

    @PostMapping("/updateExpense/{id}")
    public String updateExpense(@PathVariable("id") long id, @ModelAttribute("expense") Expense expense) {
        Expense existingExpense = expenseService.getExpenseById(id);
        existingExpense.setDescription(expense.getDescription());
        existingExpense.setAmount(expense.getAmount());
        expenseService.saveExpense(existingExpense);
        return "redirect:/";
    }

    @GetMapping("/deleteExpense/{id}")
    public String deleteExpense(@PathVariable("id") long id) {
        expenseService.deleteExpenseById(id);
        return "redirect:/";
    }
}
