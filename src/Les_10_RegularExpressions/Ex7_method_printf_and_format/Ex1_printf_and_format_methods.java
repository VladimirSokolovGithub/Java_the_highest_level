package Les_10_RegularExpressions.Ex7_method_printf_and_format;

//с помощью метода printf() можно красиво выводить данные на экран
//в первом параметре метода printf() мы даём команды как нужно выводить остальные параметры.

public class Ex1_printf_and_format_methods {

    public static void employeeInfo(Employee employee){
        System.out.printf("%03d \t Hello %-12s \t %-12s \t %,.1f \n"
                , employee.id, employee.name, employee.surname, employee.salary*(1+ employee.bonusPct));
    }

    public static void main(String[] args) {
//        System.out.printf("первый параметр String - нужно выравнить по левому краю" +
//                " а второй параметр - double - надо округлить до десятых", "privet", "3.1415");

        Employee employee1 = new Employee(1, "Vladimir", "Sokolov", 12345, 0.15);
        Employee employee2 = new Employee(15, "Artem", "Sokolov", 6542, 0.08);
        Employee employee3 = new Employee(123, "Maksim", "Sokolov", 8542, 0.12);

        employeeInfo(employee1);
        employeeInfo(employee2);
        employeeInfo(employee3);
        System.out.println();

        //метод format() - если мы хотим чтобы наш стринг не только красиво выводился на экран, ,
        // но и хранился в таком же виде, то нужно использовать метод format().
        String newString = String.format("%03d \t Hello %-12s \t %-12s \t %,.1f \n"
                , employee1.id, employee1.name, employee1.surname, employee1.salary*(1+ employee1.bonusPct));
        System.out.println(newString);

    }
}

class Employee{
    int id;
    String name;
    String surname;
    int salary;
    double bonusPct;

    public Employee(int id, String name, String surname, int salary, double bonusPct) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.bonusPct = bonusPct;
    }


}