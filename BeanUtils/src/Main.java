public class Main {
    public static void main(String[] args) {


        Person a = new Person("Alex", 25);
        Animal b = new Animal("turtle", 500);

        System.out.println(a.getName() + " " + a.getAge());

        BeanUtils.assign(a, b);

        //again printing object a
        System.out.println(a.getName() + " " + a.getAge());

    }
}
