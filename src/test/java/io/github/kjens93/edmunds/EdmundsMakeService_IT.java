package io.github.kjens93.edmunds;

import io.github.kjens93.edmunds.dto.Make;
import io.github.kjens93.edmunds.services.MakeService;
import org.junit.Test;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kjensen on 11/20/16.
 */
public class EdmundsMakeService_IT {

    private static final MakeService edmunds = new Edmunds(System.getenv("EDMUNDS_API_KEY"));
    private static final int thisYear = Calendar.getInstance().get(Calendar.YEAR);

    @Test
    public void test_findMake_get() {
        assertThat(edmunds.findMake("honda").get())
                .isInstanceOf(Make.class);
    }

}
