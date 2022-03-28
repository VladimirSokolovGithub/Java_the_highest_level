package Les_2_Generics.exampleOnGenerics_Game;

public class TestMain {
    public static void main(String[] args) {
        Schoolar schoolar1 = new Schoolar("Ivan", 13);
        Schoolar schoolar2 = new Schoolar("Mariya", 15);

        Student student1 = new Student("Nikolay", 20);
        Student student2 = new Student("Kseniya", 18);

        Employee employee1 = new Employee("Vladimir", 41);
        Employee employee2 = new Employee("Mikhail", 47);

        Team<Schoolar> schoolarTeam = new Team<> ("Dragons");
        schoolarTeam.addNewParticipant(schoolar1);
        schoolarTeam.addNewParticipant(schoolar2);

        Team<Student> studentTeam = new Team<> ("Forward");
        studentTeam.addNewParticipant(student1);
        studentTeam.addNewParticipant(student2);

        Team<Employee> employeeTeam = new Team<> ("Hard workers");
        employeeTeam.addNewParticipant(employee1);
        employeeTeam.addNewParticipant(employee2);

        Team<Schoolar> schoolarTeam2 = new Team<> ("Wise men");
        Schoolar schoolar3 = new Schoolar("Sergey", 12);
        Schoolar schoolar4 = new Schoolar("Olya", 14);
        schoolarTeam2.addNewParticipant(schoolar3);
        schoolarTeam2.addNewParticipant(schoolar4);

        schoolarTeam.playWith(schoolarTeam2); // Но сыграть могут так же и Student и Employee со
                                            // школьниками или друг с другом, но так работать это не должно

        //Без Generics мы так же сможем добавить в schoolarTeam и student и employee, так как они
        // все extends Participant, но это нам не нужно, поэтому необходимо что-то сделать с классом Team.
        // переходим в класс Team и делаем его параметризованным

//        schoolarTeam.addNewParticipant(student1); //ошибка так как уже создан объект Team только типа Schoolar
//        schoolarTeam.addNewParticipant(employee2); //ошибка так как уже создан объект Team только типа Schoolar

        //Но теперь у нас возникает ещё одна проблема мы можем создать команду вообще любого типа,
        // например String млм Car.
        //Но так позволять работать нашей программе нельзя
        // поэтому в классе Team мы указываем тип не просто <T>, а <T extend Participant>
//        Team<String> anotherTeam = new Team<>("Fantasy");
//        anotherTeam.addNewParticipant("Hello");



    }
}
