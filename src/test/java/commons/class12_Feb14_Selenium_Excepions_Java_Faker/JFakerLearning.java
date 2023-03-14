package commons.class12_Feb14_Selenium_Excepions_Java_Faker;
import com.github.javafaker.Faker;
import org.junit.Test;

public class JFakerLearning {

    @Test
    public void LearnFaker(){
        Faker faker = new Faker();

        System.out.println(faker.animal().name());
        System.out.println(faker.beer().name());
        System.out.println(faker.idNumber().ssnValid());
    }
}
