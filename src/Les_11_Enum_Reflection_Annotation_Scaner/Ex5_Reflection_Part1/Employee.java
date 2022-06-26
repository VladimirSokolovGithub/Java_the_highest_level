package Les_11_Enum_Reflection_Annotation_Scaner.Ex5_Reflection_Part1;

//Java предоставляет класс, который называется "Class". Он находится в пакете java.lang.
//Экземпляры класса "Class", представляют классы и интерфейсы в работающем приложении java.
//Примитивные типы java так же представлены в виде объектов "Class". Т.е получается что у нас
// есть классы такие, как Car, Student, классы самой Jav-ы, например String? HashMap и другие
// и все они являются объектами класса "Class". Что бы исследовать информацию о классе нам нужен
// объект который эту информацию содержит. Таким объектом является объект класса "Class".
//

public class Employee {
    public int id;
    public String name;
    public String department;
//    private double salary;
    private double salary = 1000;

    public Employee(){
    }

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

//    public Employee(int id, String name, String department, double salary) {
//        this.id = id;
//        this.name = name;
//        this.department = department;
//        this.salary = salary;
//    }

    private Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

//    public double getSalary() {
//        return salary;
//    }
//
//    public void setSalary(double salary) {
//        this.salary = salary;
//    }

    private void changeDepartment(String newDepartment){
        department = newDepartment;
        System.out.println("New department is: " + department);
    }

    public void increaseSalary(){
        salary *= 2;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
