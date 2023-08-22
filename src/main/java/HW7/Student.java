package HW7;

import java.util.Random;

public class Student extends JobSeeker implements Observer {

    int salary = 2000;

    public Student(String name) {
        super(name);
    }

    @Override
    public void receiveOffer(Vacancy vacancy) {
        if (this.salary <= vacancy.getSalary()){
            System.out.printf("Student %s: Мне нужна эта работа! (company: %s; speciality: " + speciality + "; salary: %d)\n",
                    name, vacancy.getCompany().getName(), vacancy.getSalary());
            setRating();
            vacancy.getCompany().setJobSeekersList(this);
        }
        else {
            System.out.printf("Student %s: Я найду работу получше! (company: %s; speciality: " + speciality + "; salary: %d)\n",
                    name, vacancy.getCompany().getName(), vacancy.getSalary());
        }
    }

    @Override
    public void setRating() {
        Random random = new Random();
        raiting =  random.nextInt(1, 10);
    }

    @Override
    public String toString() {
        return "Student " + name + ", Специальность: " + speciality +", Salary: " + salary;
    }
}
