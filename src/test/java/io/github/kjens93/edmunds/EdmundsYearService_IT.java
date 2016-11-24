package io.github.kjens93.edmunds;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kjensen on 11/23/16.
 */
public class EdmundsYearService_IT {

    private static final YearService edmunds = new EdmundsImpl("8zk4wr8dg5s9pv8hrwgerb5x");

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
