package HW7;

import java.util.Random;

public enum SpecialityType {
    Programmer,
    Tester,
    Analyst,
    ProductManager,
    ProjectManager;

    public static SpecialityType randomSpeciality() {
        Random random = new Random();
        SpecialityType[] specialityTypes = SpecialityType.values();
        return specialityTypes[random.nextInt(specialityTypes.length)];
    }
}