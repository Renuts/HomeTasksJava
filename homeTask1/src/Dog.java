
public class Dog extends Animal {
    public Dog(String name) {
        super("ϸ�", name, 500, 10);
    }

    @Override
    public void run(int distance) {
        if (distance <= runLimit) {
            System.out.println(type + " " + name + " �������� " + distance + " �");
        } else {
            System.out.println(type + " " + name + " �� ����� ��������� " + distance + " �");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= swimLimit) {
            System.out.println(type + " " + name + " ������� " + distance + " �");
        } else {
            System.out.println(type + " " + name + " �� ����� �������� " + distance + " �");
        }
    }
}
