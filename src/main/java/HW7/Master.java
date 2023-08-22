package HW7;

import java.util.Random;

public class Master extends JobSeeker implements Observer {

    int salary = new Random().nextInt(60, 100) * 1000;

    public Master(String name) {
        super(name);
    }

    @Override
    public void receiveOffer(Vacancy vacancy) {
        if (this.salary <= vacancy.getSalary()){
            System.out.printf("Master %s: Мне нужна эта работа! (company: %s; speciality: " + speciality + "; salary: %d)\n", name,
                    vacancy.getCompany().getName(), vacancy.getSalary());
            setRating();
            vacancy.getCompany().setJobSeekersList(this);
        }
        else {
            System.out.printf("Master %s: Я найду работу получше! (company: %s; speciality: " + speciality + "; salary: %d)\n", name,
                    vacancy.getCompany().getName(), vacancy.getSalary());
        }
    }

    @Override
    public void setRating() {
        Random random = new Random();
        raiting =  random.nextInt(30, 40);
    }

    @Override
    public String toString() {
        return "Master " + name + ", Специальность: " + speciality +", Salary: " + salary;
    }
}
