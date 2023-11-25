import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];
        animals[0] = new Dog("Бобик");
        animals[1] = new Cat("Мурзик");
        animals[2] = new Tiger("Амур");

        Random random = new Random();
        int runDistance = random.nextInt(1000) + 1;
        int swimDistance = random.nextInt(1000) + 1;

        for (Animal animal : animals) {
            animal.run(runDistance);
            animal.swim(swimDistance);
            System.out.println();
        }
    }
}