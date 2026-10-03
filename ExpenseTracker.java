import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Expense> ex = new ArrayList<>();

        
        int choice = 0;
        while(choice != 6) {
            System.out.println("=== Expense Tracker ===");
            System.out.println("1. Add Expense.");
            System.out.println("2. View all expenses.");
            System.out.println("3. Total Expenses.");
            System.out.println("4. Search By Category.");
            System.out.println("5. Delete Expense.");
            System.out.println("6. Exit");
            System.out.print("Choose -> ");
            choice = sc.nextInt();

            if(choice == 1) {
               addExpense(sc, ex);
            }
            else if(choice == 2) {
               viewExpenses(ex);
            }
            else if(choice == 3) {
                calculateTotal(ex);
            }
            else if(choice == 4) {
                searchExpense(sc,ex);
            }
            else if(choice == 5) {
                deleteIndex(sc,ex);
            }
            else if(choice == 6) {
                System.out.println("Successfully exited from the expense tracker app!!");
                System.out.println("Visit again !! Have a good day..");
            }
            else {
                System.out.println("Enter the appropriate choice.");
            }
        }
        sc.close();
    }

    public static void addExpense(Scanner sc, ArrayList<Expense> ex) {
        System.out.println("Eneter the title of expense->");
        sc.nextLine();
        String title = sc.nextLine();
        System.out.println("Enter the amount of expense ->");
        double amount = sc.nextDouble();

        System.out.println("Enter the category of expense ->");
        sc.nextLine();
        String category = sc.nextLine();

        if(amount <= 0) {
            System.out.println("Amount should be more than 0");
            return;
        }
        
        ex.add(new Expense(title,amount, category));
        System.out.println("Expense added successfully!");
    }
    public static void viewExpenses(ArrayList<Expense> ex) {
        if(ex.isEmpty()) {
            System.out.println("No expenses available.");
            return;
        }
        else {
            for(int i =0 ; i < ex.size();i++) {
                Expense expense = ex.get(i);
                System.out.println(i + "->" +expense.title + "-> " + expense.amount + "->" + expense.category);
            }
        }
    }
    public static void calculateTotal(ArrayList<Expense> ex) {
        if(ex.isEmpty()) {
            System.out.println("No expenses are available");
            return;
        }
        double total = 0;
        for(Expense expense : ex) {
            total += expense.amount;
        }
        System.out.println("Total expense ->" + total);
    }

    public static void searchExpense(Scanner sc, ArrayList<Expense> ex) {
        System.out.println("Enter the category to search ->");
        sc.nextLine();
        String category = sc.nextLine();
        boolean found = false;

        if(ex.isEmpty()) {
            System.out.println("No expense available.");
            return;
        }
        for(int i = 0; i < ex.size(); i++) {
            Expense expense = ex.get(i);
            if(expense.category.equals(category)) {
                System.out.println(i + "-> "+ expense.title + "->" + expense.amount +"->" + expense.category);
                found = true;
            }
        }
        if(!found) {
            System.out.println("No category found");
        }
    }

    public static void deleteIndex(Scanner sc, ArrayList<Expense> ex) {
        
        if(ex.isEmpty()) {
            System.out.println("No expenses available");
            return;
        }
        System.out.println("Enter the index to delete ->");
        int index = sc.nextInt();

        if(index >= 0 && index < ex.size()) {
            ex.remove(index);
            System.out.println("Expense deleted!");
        }
        else {
            System.out.println("Invalid Index..");
        }
    }
}