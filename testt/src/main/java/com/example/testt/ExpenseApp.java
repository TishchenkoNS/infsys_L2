
//Приложение связано с таблицей (expense) расходов студента базы данных student

package com.example.testt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class ExpenseApp implements CommandLineRunner {

    private static Scanner sc;


    @Autowired
    ExpenseRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(ExpenseApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        boolean q = true;
        while(q){
            System.out.println("\nCRUD:\n  1.Create new entry\n  2.Read expense table\n" +
                    "  3.Update table entry\n  4.Delete table entry\n  5.Exit\n");
            sc = new Scanner(System.in);
            int a = sc.nextInt();
            switch (a){
                case 1: {
                    addExpense();
                    break;
                }
                case 2: {
                    printAll();
                    break;
                }
                case 3: {
                    updateExpenseById();
                    break;
                }
                case 4: {
                    deleteExpense();
                    break;
                }
                case 5: {
                    q = false;
                    break;
                }
                default: {
                    System.out.println("ERROR!");
                    break;
                }
            }
        }
    }

    void printAll(){
        Iterable<Expense> iterator = repository.findAll();
        System.out.println("All expense items: ");
        iterator.forEach(item -> System.out.println(item));
    }

    void deleteExpense(){
        sc = new Scanner(System.in);
        System.out.println("Choose id from list above to delete: ");
        long id = sc.nextLong();
        repository.deleteById(id);
    }

    void updateExpenseById(){
        sc = new Scanner(System.in);
        System.out.println("Choose expense id from list above to update: ");
        long id = sc.nextLong();

        sc = new Scanner(System.in);
        System.out.println("name: ");
        String name = sc.nextLine();

        System.out.println("cost: ");
        float amount = sc.nextFloat();
        repository.updateAddress(id,name,amount);
    }

    void addExpense(){
        sc = new Scanner(System.in);

        System.out.println("name: ");
        String name = sc.nextLine();

        System.out.println("cost: ");
        float amount = sc.nextFloat();
        repository.save(new Expense(name, amount));
    }
}
