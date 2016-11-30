package io.github.kjens93.edmunds;

import io.github.kjens93.edmunds.enums.Category;
import io.github.kjens93.edmunds.dto.Year;
import io.github.kjens93.edmunds.services.YearService;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kjensen on 11/23/16.
 */
public class EdmundsYearService_IT {

    private static final YearService edmunds = new Edmunds(System.getenv("EDMUNDS_API_KEY"));

    @Test
    public void test_findModelYear() {
        assertThat(edmunds.findModelYear("honda", "accord", 2013).get())
                .isEqualToIgnoringGivenFields(new Year(100537293, 2013), "styles");
    }

    @Test
    public void test_findModelYear_submodel() {
        assertThat(edmunds.findModelYear("honda", "accord", 2013).submodel("coupe").get().getStyles())
                .isNotEmpty()
                .allMatch(s -> s.getSubmodel().getBody().contentEquals("Coupe"));
    }

    @Test
    public void test_findModelYear_category() {
        assertThat(edmunds.findModelYear("honda", "accord", 2013).category(Category.COUPE).get().getStyles())
                .isNotEmpty()
                .allMatch(s -> s.getSubmodel().getBody().contentEquals("Coupe"));
    }

}
