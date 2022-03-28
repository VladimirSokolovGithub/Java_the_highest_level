package Les_2_Generics.exampleOnGenerics_Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//public class Team {
    public class Team <T extends Participant> {
    private String name;
//    private List<Participant> participants = new ArrayList<>();
    private List<T> participants = new ArrayList<>();

    public Team(String name){
        this.name = name;
    }

//    public void addNewParticipant(Participant participant){
    public void addNewParticipant(T participant){
        participants.add(participant);
        System.out.println("В команду " + name + " был добавлен новый участник по имени "
//                + ((Participant)participant).getName());
                + participant.getName()); // и теперь так как у нас class Team <T extends Participant>, то
                                        // можно убрать кастинг. Теперь компилятор понимает что Т - это сам
                                        // Participant или его subclass(дети, наследники)
    }

//    public void playWith(Team team){
    public void playWith(Team<T> team){ // То есть мы можем играть с командой только типа <T>
        //Если мы создаём объект класса Team типа Student, то и играть могут между собой только команды типа Student
        String winnerName;
        Random random = new Random();
        int i = random.nextInt(2);
        if (i == 0){
            winnerName = this.name; //Если i == 0, то winnerName равен команде, которая вызывает на себя этот метод
        } else {
            winnerName = team.name; //Иначе это название команды в параметре метода с которой мы играем
        }
        System.out.println("Выиграла команда " + winnerName);
    }
}
