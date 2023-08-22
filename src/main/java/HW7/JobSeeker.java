package HW7;

public abstract class JobSeeker implements Observer, Comparable<JobSeeker> {

    protected String name;

    int salary;

    protected SpecialityType speciality;

    protected int raiting;

    public JobSeeker(String name) {
        this.name = name;
        speciality = SpecialityType.randomSpeciality();
    }

    public String getName() {
        return name;
    }

    public SpecialityType getSpeciality() {
        return speciality;
    }

    public abstract void receiveOffer(Vacancy vacancy);

    public abstract void setRating();

    public int getRaiting() {
        return raiting;
    }

    @Override
    public int compareTo(JobSeeker o) {
        return this.getRaiting() - o.getRaiting();
    }
}
