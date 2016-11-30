package io.github.kjens93.edmunds;

import io.github.kjens93.edmunds.services.StylesService;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kjensen on 11/23/16.
 */
public class EdmundsStylesService_IT {

    private static final StylesService edmunds = new Edmunds(System.getenv("EDMUNDS_API_KEY"));

    @Test
    public void test_findStyles() {
        assertThat(edmunds.findAllStyles().getCount())
                .isGreaterThanOrEqualTo(50367);
    }

}
