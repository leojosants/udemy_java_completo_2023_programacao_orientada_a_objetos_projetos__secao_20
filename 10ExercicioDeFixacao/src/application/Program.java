/*-------------------- packages --------------------*/
package application;

/*-------------------- libraries --------------------*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

/*-------------------- modules --------------------*/
import model.entities.Employee;

/*-------------------- class Program --------------------*/
public class Program {

	/*-------------------- functions --------------------*/
	private static Scanner generateInstanceScanner() {
		return new Scanner(System.in);
	}
	
	private static String requestPath(Scanner scanner) {
		String path = null;
		
		System.out.print("\nEntre com o caminho do arquivo [c:\\...\\file.txt] ..: ");
		path = scanner.nextLine().trim();
		
		while (path.isEmpty()) {
			System.out.print("-> campo vazio, tente novamente! Entre com o caminho do arquivo [c:\\...\\file.txt] ..: ");
			path = scanner.nextLine().trim();
		}
		
		return path;
	}
	
	private static File generateInstanceFile(String path) {
		return new File(path);
	}
	
	private static FileReader generateInstanceFileReader(File file_path) throws FileNotFoundException {
		return new FileReader(file_path);
	}
	
	private static BufferedReader generateInstanceBufferedReader(FileReader file_reader) {
		return new BufferedReader(file_reader);
	}
	
	private static String readerLine(BufferedReader buffered_reader) throws IOException {
		return buffered_reader.readLine();
	}
	
	private static List<Employee> generateListEmployee(){
		return new ArrayList<>();
	}
	
	private static String[] splitLine(String line) {
		return line.split(",");
	}
	
	private static Double convertStringFromDouble(String fields) {
		return Double.parseDouble(fields);
	}
	
	private static Employee generateInstanceEmployee(String name, String email, Double salary) {
		return new Employee(name, email, salary);
	}
	
	private static Double requestSalary(Scanner scanner) {
		Double reported_salary = null;
		
		System.out.print("Entre com o salário ..: R$ ");
		reported_salary = scanner.nextDouble();
		scanner.nextLine(); // buffer
		
		if (reported_salary <= 0.0) {
			throw new IllegalStateException("valor inválido!");
		}
		
		if (reported_salary <= 0.0) {
			throw new InputMismatchException("valor inválido!");
		}
		
		return reported_salary;
	}
	
	private static void displayData(Double reported_salary, Character letter, List<String> list_of_emails, Double sum) {
		System.out.printf("\nEmail dos funcionarios que possuem salario superior a .............: 'R$ %.2f'%n", reported_salary);
		list_of_emails.forEach(System.out::println);
		System.out.printf("\nSoma dos salarios dos funcionario que o nome comeca com a letra ...: '%s'%nR$ %.2f%n", letter, sum);
	}
	
	private static void displayMessageExceptions(Throwable e) {
		System.out.printf("-> erro: ..: %s%n", e.getMessage());
	}
		
	private static void displayMessageEndOfProgram() {
		System.out.println("\n-----> fim do programa <-----");
	}
	
	private static void runProgram() throws FileNotFoundException {
		Locale.setDefault(Locale.US);
		Scanner scanner = generateInstanceScanner();
		String path = requestPath(scanner);
		File file_path = generateInstanceFile(path);
		FileReader file_reader = generateInstanceFileReader(file_path);
		BufferedReader buffered_reader = generateInstanceBufferedReader(file_reader);
		List<Employee> list_of_employees = generateListEmployee();
				
		try (buffered_reader) {
			String line = readerLine(buffered_reader);

			while (line != null) {
				String[] fields = splitLine(line);
				String name = fields[0];
				String email = fields[1];
				Double salary = convertStringFromDouble(fields[2]);
				list_of_employees.add(generateInstanceEmployee(name, email, salary));
				line = readerLine(buffered_reader);
			}
			
			Double reported_salary = requestSalary(scanner);
			
			List<String> list_of_emails = list_of_employees.stream()
					.filter(employee -> employee.getSalary() > reported_salary)
					.map(employee -> employee.getEmail())
					.sorted()
					.collect(Collectors.toList());
						
			Character letter = 'M';
			
			Double sum = list_of_employees.stream()
					.filter(employe -> employe.getName().charAt(0) == letter)
					.map(employe -> employe.getSalary())
					.reduce(0.0, (salary_1, salary_2) -> salary_1 + salary_2);
			
			displayData(reported_salary, letter, list_of_emails, sum);;
		} 
		catch (IllegalStateException e) {
			displayMessageExceptions(e);
		}
		catch (InputMismatchException e) {
			displayMessageExceptions(e);
		}
		catch (FileNotFoundException e) {
			displayMessageExceptions(e);
		}
		catch (IOException e) {
			displayMessageExceptions(e);
		}
		catch (Exception e) {
			displayMessageExceptions(e);
		}
		finally {
			scanner.close();
			displayMessageEndOfProgram();
		}		
	}
	
	/*-------------------- main method --------------------*/
	public static void main(String[] args) throws FileNotFoundException {
		runProgram();
	}
}
