package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class DataPickerComponent {

    public void setDate(String day, String month, String year) {
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--" + day + ":not(.react-datepicker__day--outside-month)").click();
    }
}