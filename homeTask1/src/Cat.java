
public class Cat extends Animal {
    public Cat(String name) {
        super("���", name, 200, 0);
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
        System.out.println(type + " " + name + " �� ����� �������");
    }
}
