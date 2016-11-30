package io.github.kjens93.edmunds;

import io.github.kjens93.edmunds.services.YearsService;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kjensen on 11/23/16.
 */
public class EdmundsYearsService_IT {

    private static final YearsService edmunds = new Edmunds(System.getProperty("EDMUNDS_API_KEY"));

    @Test
    public void test_findModelYear() {
        assertThat(edmunds.findAllModelYears("honda", "accord").get()).isNotEmpty();
    }

}
