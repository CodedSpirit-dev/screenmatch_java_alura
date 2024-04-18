public class Principal {
    public static void main(String[] args) {
        Movie TheMatrix;
        TheMatrix = new Movie();
        TheMatrix.name = "The Matrix";
        TheMatrix.year = 1999;
        TheMatrix.lengthInMinutes = 136;
        TheMatrix.includedInTheUserPlan = true;

        System.out.println("My movie is " + TheMatrix.name);
        System.out.println("It was released in " + TheMatrix.year);
        System.out.println("It lasts " + TheMatrix.lengthInMinutes + " minutes");
        System.out.println("Is it included in the user plan? " + TheMatrix.includedInTheUserPlan);

        Movie TheMatrixReloaded;
        TheMatrixReloaded = new Movie();
        TheMatrixReloaded.name = "The Matrix Reloaded";
        TheMatrixReloaded.year = 2003;
        TheMatrixReloaded.lengthInMinutes = 138;
        TheMatrixReloaded.includedInTheUserPlan = false;

        System.out.println("My movie is " + TheMatrixReloaded.name);
        System.out.println("It was released in " + TheMatrixReloaded.year);
        System.out.println("It lasts " + TheMatrixReloaded.lengthInMinutes + " minutes");
        System.out.println("Is it included in the user plan? " + TheMatrixReloaded.includedInTheUserPlan);

    }
}
