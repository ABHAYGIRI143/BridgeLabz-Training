public class AnimalHierarchy {
        String name;
        int age;

        AnimalHierarchy(String name, int age) {
            this.name = name;
            this.age = age;
        }

        void makeSound() {
            System.out.println("Animal makes a sound");
        }
    }

    class Dog extends AnimalHierarchy {
        Dog(String name, int age) {
            super(name, age);
        }

        @Override
        void makeSound() {
            System.out.println("Dog barks");
        }
    }

    class Cat extends AnimalHierarchy {
        Cat(String name, int age) {
            super(name, age);
        }

        @Override
        void makeSound() {
            System.out.println("Cat meows");
        }
    }

    class Bird extends AnimalHierarchy {
        Bird(String name, int age) {
            super(name, age);
        }

        @Override
        void makeSound() {
            System.out.println("Bird chirps");
        }
    }

    public class AnimalTest {
        public static void main(String[] args) {
            AnimalHierarchy[] animals = {
                    new Dog("Tommy", 3),
                    new Cat("Kitty", 2),
                    new Bird("Parrot", 1)
            };

            for (AnimalHierarchy a : animals) {
                a.makeSound(); // polymorphism
            }
        }
    }
