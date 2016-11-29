package io.github.kjens93.edmunds;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kjensen on 11/23/16.
 */
public class EdmundsYearsService_IT {

    private static final YearsService edmunds = new Edmunds("8zk4wr8dg5s9pv8hrwgerb5x");

    @Test
    public void test_findModelYear() {
        assertThat(edmunds.findAllModelYears("honda", "accord").get()).isNotEmpty();
    }

}
