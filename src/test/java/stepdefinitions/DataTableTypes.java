package stepdefinitions;

import io.cucumber.java.DataTableType;

public class DataTableTypes {

    @DataTableType(replaceWithEmptyString = "[blank]")
    public String stringType(String cell) {
        return cell;
    }
}
