package HW7;

import java.util.Random;

public class Middle extends JobSeeker implements Observer{

    int salary = new Random().nextInt(40, 60) * 1000;

    int koeff = 20;

    public Middle(String name) {
        super(name);
    }

    @Override
    public void receiveOffer(Vacancy vacancy) {
        if (this.salary <= vacancy.getSalary()){
            System.out.printf("Middle %s: Мне нужна эта работа! (company: %s; speciality: " + speciality + "; salary: %d)\n", name,
                    vacancy.getCompany().getName(), vacancy.getSalary());
            setRating();
            vacancy.getCompany().setJobSeekersList(this);
        }
        else {
            System.out.printf("Middle %s: Я найду работу получше! (company: %s; speciality: " + speciality + "; salary: %d)\n", name,
                    vacancy.getCompany().getName(), vacancy.getSalary());
        }
    }

    @Override
    public void setRating() {
        Random random = new Random();
        raiting =  random.nextInt(20, 30);
    }

    @Override
    public String toString() {
        return "Middle " + name + ", Специальность: " + speciality +", Salary: " + salary;
    }
}