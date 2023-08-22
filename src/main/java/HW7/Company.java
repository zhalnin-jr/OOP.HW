package HW7;

import java.util.*;

public class Company {

    private Random random = new Random();

    Publisher jobAgency;

    private String name;

    private int maxSalary;

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    private List<JobSeeker> jobSeekersList = new ArrayList<>();

    public Company(Publisher jobAgency, String name, int maxSalary) {
        this.jobAgency = jobAgency;
        this.name = name;
        this.maxSalary = maxSalary;
    }

    public void setJobSeekersList(JobSeeker observer) {
        jobSeekersList.add(observer);
    }

    public void getJobSeekersList() {
        if (jobSeekersList.size() != 0) {
            System.out.println("\n" + "=".repeat(20));
            System.out.println("Список откликнувшихся соискателей:");
            for (JobSeeker jobSeeker:jobSeekersList) {
                System.out.printf(jobSeeker.getName() + "; ");
            }
            System.out.println();
        } else {
            System.out.println("\n" + "=".repeat(20));
            System.out.println("Соискателей нет");

        }
    }

    public String getName() {
        return name;
    }

    public void needEmployee(){
        Vacancy vacancy = new Vacancy(this, SpecialityType.randomSpeciality(), random.nextInt(maxSalary));
        System.out.println(vacancy);
        System.out.println("=".repeat(20));
        jobAgency.sendOffer(vacancy);
        getJobSeekersList();
        jobAgency.removeObserver((Observer) maxRating());
        jobSeekersList.clear();
    }

    public JobSeeker maxRating() {
        if (jobSeekersList.size() != 0) {
            Collections.sort(jobSeekersList);
            System.out.println("\n" + "=".repeat(20));
            for (JobSeeker jobSeeker : jobSeekersList) {
                System.out.printf("%s Rating: %d; ", jobSeeker.getName(), jobSeeker.getRaiting());
            }
            System.out.println();
            System.out.printf("%s принят на работу\n", jobSeekersList.get(jobSeekersList.size() - 1).getName());
            return jobSeekersList.get(jobSeekersList.size() - 1);
        } else {
            return null;
        }
    }

}
