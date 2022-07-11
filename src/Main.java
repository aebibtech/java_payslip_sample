
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
  public static Scanner input;
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    String employeeName = "";
    Double basicSalary = -1.0;
    Integer otHours = -1;

    input = new Scanner(System.in);

    System.out.println("*************Payslip Program***********");
    
    while (employeeName.equals("")) {
      try {
        employeeName = args[0];
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.print("Employee Name -> ");
        employeeName = input.nextLine();
      }
    }
    
    while (basicSalary <= 0.0) {
      try {
       basicSalary = Double.parseDouble(args[1]); 
      } catch (ArrayIndexOutOfBoundsException e) {
        basicSalary = inputSalary();
        if(basicSalary > 0) {
          break;
        }
      }
    }
    
    while (otHours < 0) {
      try {
       otHours = Integer.parseInt(args[2]);
      } catch (ArrayIndexOutOfBoundsException e) {
        otHours = inputOT();
        if(otHours > 0) {
          break;
        }
      }
    }
    
//    System.out.println(employeeName.concat(" ") + basicSalary.toString().concat(" ") + otHours.toString());
    
    Payslip payslip = new Payslip(employeeName, basicSalary, otHours);
    
    DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDateTime today = LocalDateTime.now();
    System.out.println("\n\n");
    System.out.println("*************Payslip***********\n");
    System.out.println("Date Generated:\t" + date.format(today));
    System.out.println();
    System.out.println("Employee Name:\t" + payslip.getEmployeeName());
    System.out.printf("Basic Salary:\t%s %.2f\n", "Php", payslip.getBasicSalary());
    System.out.println("Overtime Hours:\t" + payslip.getOtHours());
    System.out.println();
    System.out.printf("Overtime Pay:\t%s %.2f\n", "Php", payslip.getOtPay());
    System.out.printf("Gross Income:\t%s %.2f\n", "Php", payslip.getGrossIncome());
    System.out.println("\n*******Deductions*************\n");
    System.out.printf("Withholding Tax:\t%s %.2f\n", "Php", payslip.getWithHoldingTax());
    System.out.printf("SSS Contribution:\t%s %.2f\n", "Php", payslip.getSss());
    System.out.printf("Pag-Ibig Contribution:\t%s %.2f\n", "Php", payslip.getPagIbig());
    System.out.printf("PhilHealth Contribution: %s %.2f\n", "Php", payslip.getPhilHealth());
    System.out.println("\n********************************");
    System.out.println();
    System.out.printf("Net Pay:\t%s %.2f\n\n", "Php", payslip.getNetPay());
  }
  
  public static Double inputSalary() {
    Double salary;
    try {
      System.out.print("Basic Salary -> ");
      salary = input.nextDouble();
    } catch (InputMismatchException e) {
      System.out.println("\nInvalid input. Enter a number.");
      input.next();
      salary = inputSalary();
    }
    return salary;
  }
  
  public static Integer inputOT() {
    Integer ot;
    try {
      System.out.print("Overtime Hours -> ");
      ot = input.nextInt();
    } catch (InputMismatchException e) {
      System.out.println("\nInvalid input. Enter a number.");
      input.next();
      ot = inputOT();
    }
    return ot;
  }

}
