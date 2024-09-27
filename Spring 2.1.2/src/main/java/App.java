import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
Создайте POJO-класс Cat.
В классе AppConfig, по аналогии, создайте бин с именем “cat”.

Настройте этот бин так, чтобы он создавался новым при каждом запросе.

В классе App, по аналогии, вызовите еще раз бин HelloWorld, затем 2 раза вызовите бин cat.
Сравните 2 пары бинов по ссылке и выведите результат в консоль. Для пары HelloWorld должно вернуться true, для cat - false.
 Так вы можете увидеть результат того, как работает наш контейнер.
 */

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);

        HelloWorld beanHL1 = (HelloWorld) applicationContext.getBean("helloworld");
//        System.out.println(beanHL1.getMessage());
        HelloWorld beanHL2 = (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println(beanHL1 == beanHL2);

        Cat beanCat1 = (Cat) applicationContext.getBean("cat");
        Cat beanCat2 = (Cat) applicationContext.getBean("cat");

        System.out.println(beanCat1 == beanCat2);
    }
}