package io.github.kjens93.edmunds;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kjensen on 11/20/16.
 */
public class EdmundsModelService_IT {

    private static final ModelService edmunds = new EdmundsImpl("8zk4wr8dg5s9pv8hrwgerb5x");

    @Test
    public void test_findModel_get() {
        assertThat(edmunds.findModel("honda", "accord").state(State.NEW).year(2014).get())
                .isEqualTo(new Model("Honda_Accord", "Accord", "accord"));
    }

}
