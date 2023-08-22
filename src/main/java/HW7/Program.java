package HW7;

import java.util.ArrayList;
import java.util.Random;

public class Program {

    static Random random = new Random();

    static JobSeeker generateJobSeeker(){
        String[] names = new String[] { "Григорий", "Петр", "Анатолий", "Владимир", "Евгений", "Евгения", "Павел", "Екатерина", "Татьяна", "Ильяс" };
        String[] surnames = new String[] { "Фолкин", "Бабий", "Шестаков", "Шахов", "Щукин", "Бирюков", "Попов", "Лыткарин", "Холодов", "Ильюшин" };
        int levelIndex = random.nextInt(4);
        switch (levelIndex)
        {
            case 0:
                return new Student(names[random.nextInt(10)] + " " + surnames[random.nextInt(10)]);
            case 1:
                return new Junior(names[random.nextInt(10)] + " " + surnames[random.nextInt(10)]);
            case 2:
                return new Middle(names[random.nextInt(10)] + " " + surnames[random.nextInt(10)]);
            case 3:
                return new Master(names[random.nextInt(10)] + " " + surnames[random.nextInt(10)]);
        }
        return null;
    }

    static ArrayList<JobSeeker> generateJobSeekers(int count){
        ArrayList<JobSeeker> jobSeekers = new ArrayList<>();
        for (int i = 0; i < count; i++){
            jobSeekers.add(generateJobSeeker());
        }
        return jobSeekers;
    }

    public static void main(String[] args) {

        Publisher jobAgency = new JobAgency();
        Company microsoft = new Company(jobAgency, "Microsoft", 110000);
        Company apple = new Company(jobAgency, "Apple", 130000);
        Company amazon = new Company(jobAgency, "Amazon", 100000);

        System.out.println("Список соискателей работы:");
        ArrayList<JobSeeker> jobSeekers = generateJobSeekers(10);
        for (JobSeeker jobSeeker : jobSeekers) {
            jobAgency.registerObserver(jobSeeker);
            System.out.println(jobSeeker);
        }

        System.out.println("\nОглашение вакансий:");
        microsoft.needEmployee();
        apple.needEmployee();
        amazon.needEmployee();

        System.out.println("\nДополнительные проверки:");
        // Adding additional checks
        jobAgency.removeObserver(jobSeekers.get(0));
        System.out.println("Соискатель " + jobSeekers.get(0) + " снят с рассмотрения");

        amazon.setMaxSalary(120000);
        System.out.println("Зарплата в компании Amazon установлена на 120000");

        Company google = new Company(jobAgency, "Google", 115000);
        System.out.println("Создана новая компания Google с зарплатой 115000");

        google.needEmployee();
    }
}
