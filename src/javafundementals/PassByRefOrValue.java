package javafundementals;

public class PassByRefOrValue {

    public static class TestObject {
        public String word;
        public Integer age;

        public TestObject(String word, Integer age) {
            this.word = word;
            this.age = age;
        }

        @Override
        public String toString() {
            return "TestObject{" +
                    "word='" + word + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public void finialize() {

    }

    public static void main(String[] args) {
        TestObject obj = new TestObject("object 1", 10);
        System.out.println(obj);
        testMethod(obj);
        System.out.println(obj);
        testMethod2(obj);
        System.out.println(obj);
    }

    public static void testMethod(TestObject object) {
        object = new TestObject("object 2", 20);
    }

    public static void testMethod2(TestObject object) {
        object.word = object.word.toUpperCase();
        object.age *= 2;
    }
}
