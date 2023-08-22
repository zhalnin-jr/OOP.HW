package HW7;

public class Vacancy {

//     Ссылка на компанию, подавшую заявку
    private Company company;

//    Заработная плата по данной вакансии
    private int salary;

//      Требуемая специальность

    private SpecialityType speciality;

    public Vacancy(Company company, SpecialityType speciality, int salary) {
        this.company = company;
        this.speciality = speciality;
        this.salary = salary;
    }

    public Company getCompany() {
        return company;
    }

    public SpecialityType getSpeciality() {
        return speciality;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        System.out.println("\n" + "=".repeat(20));
        return "Vacancy:\ncompany: " + company.getName() + " speciality: " + speciality + " salary: " + salary + "\n";

    }
}