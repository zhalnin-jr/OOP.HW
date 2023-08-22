package HW7;

import java.util.Random;

public class Junior extends JobSeeker implements Observer {

    int salary = new Random().nextInt(20, 40) * 1000;

    public Junior(String name) {
        super(name);
    }

    @Override
    public void receiveOffer(Vacancy vacancy) {
        if (this.salary <= vacancy.getSalary()){
            System.out.printf("Junior %s: Мне нужна эта работа! (company: %s; speciality: " + speciality + "; salary: %d)\n", name,
                    vacancy.getCompany().getName(), vacancy.getSalary());
            setRating();
            vacancy.getCompany().setJobSeekersList(this);
        }
        else {
            System.out.printf("Junior %s: Я найду работу получше! (company: %s; speciality: " + speciality + "; salary: %d)\n", name,
                    vacancy.getCompany().getName(), vacancy.getSalary());
        }
    }

    @Override
    public void setRating() {
        Random random = new Random();
        raiting =  random.nextInt(10, 20);
    }

    @Override
    public String toString() {
        return "Junior " + name + ", Специальность: " + speciality +", Salary: " + salary;
    }
}
